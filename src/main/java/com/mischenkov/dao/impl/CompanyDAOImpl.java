package com.mischenkov.dao.impl;

import com.mischenkov.dao.CompanyDAO;
import com.mischenkov.dao.JDBCTemplate;
import com.mischenkov.dao.RowMapper;
import com.mischenkov.dto.CompanyDTO;
import com.mischenkov.entity.Company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class CompanyDAOImpl implements CompanyDAO {

    private final static String SELECT_COMPANY_BY_ID = "SELECT `id`, `company_name` FROM company WHERE `id`= ?";
    private final static String INSERT_COMPANY = "INSERT INTO company (`company_name`) VALUES (?)";
    private final static String UPDATE_COMPANY = "UPDATE company SET `company_name`= ? WHERE `id`= ?";
    private final static String DELETE_COMPANY = "DELETE FROM company WHERE `id`= ?";

    private final JDBCTemplate template;

    public CompanyDAOImpl(JDBCTemplate template) {
        this.template = template;
    }

    @Override
    public int insertCompany(Connection con, CompanyDTO companyDTO) throws SQLException {
        return template.insert(con, INSERT_COMPANY, companyDTO.getCompany().getName());
    }

    @Override
    public Optional<CompanyDTO> selectEmployee(Connection con, int companyId) throws SQLException {
        return template.executeQuery(con, SELECT_COMPANY_BY_ID, dtoRowMapper, companyId)
                .stream()
                .findFirst();
    }

    @Override
    public void update(Connection con, CompanyDTO companyDTO) throws SQLException {
        template.update(con, UPDATE_COMPANY,
                companyDTO.getCompany().getName(),
                companyDTO.getId()
        );
    }

    @Override
    public void delete(Connection con, int companyId) throws SQLException {
        template.update(con, DELETE_COMPANY, companyId);
    }

    private final RowMapper<CompanyDTO> dtoRowMapper = rs -> new CompanyDTO()
            .setId(rs.getInt("id"))
            .setCompany(new Company(
                    rs.getString("company_name")
            ));
}
