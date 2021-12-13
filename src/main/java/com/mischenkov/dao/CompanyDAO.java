package com.mischenkov.dao;

import com.mischenkov.dto.CompanyDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public interface CompanyDAO {

    int insertCompany(Connection con, CompanyDTO companyDTO) throws SQLException;

    Optional<CompanyDTO> selectEmployee(Connection con, int companyId) throws SQLException;

    void update(Connection con, CompanyDTO companyDTO) throws SQLException;

    void delete(Connection con, int companyId) throws SQLException;
}
