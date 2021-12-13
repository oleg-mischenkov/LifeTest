package com.mischenkov.dao.impl;

import com.mischenkov.dao.EmployeeDAO;
import com.mischenkov.dao.JDBCTemplate;
import com.mischenkov.dao.RowMapper;
import com.mischenkov.dto.EmployeeDTO;
import com.mischenkov.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT `id`, `first_name`, `last_name`, `company_id` FROM employee WHERE `id`= ?";
    private static final String INSERT_TASK = "INSERT INTO employee (`first_name`, `last_name`, `company_id`) VALUES (?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET `first_name`= ?, `last_name`= ?, `company_id`= ? WHERE `id`= ?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE `id`= ?";

    private final JDBCTemplate template;

    public EmployeeDAOImpl(JDBCTemplate template) {
        this.template = template;
    }

    @Override
    public int insertEmployee(Connection con, EmployeeDTO employeeDTO) throws SQLException {
        return template.insert(con, INSERT_TASK,
                employeeDTO.getEmployee().getFirstName(),
                employeeDTO.getEmployee().getLastName(),
                employeeDTO.getCompanyId()
        );
    }

    @Override
    public Optional<EmployeeDTO> selectEmployee(Connection con, int employeeId) throws SQLException {
        return template.executeQuery(con, SELECT_EMPLOYEE_BY_ID, dtoRowMapper, employeeId)
                .stream()
                .findFirst();
    }

    @Override
    public void update(Connection con, EmployeeDTO employeeDTO) throws SQLException {
        template.update(con, UPDATE_EMPLOYEE,
                employeeDTO.getEmployee().getFirstName(),
                employeeDTO.getEmployee().getLastName(),
                employeeDTO.getCompanyId(),
                employeeDTO.getId()
        );
    }

    @Override
    public void delete(Connection con, int employeeId) throws SQLException {
        template.update(con, DELETE_EMPLOYEE, employeeId);
    }

    private final RowMapper<EmployeeDTO> dtoRowMapper = rs -> new EmployeeDTO()
            .setId(rs.getInt("id"))
            .setEmployee(new Employee(
                    rs.getString("first_name"),
                    rs.getString("last_name")
            ))
            .setCompanyId(rs.getInt("company_id"));
}
