package com.mischenkov.dao;

import com.mischenkov.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public interface EmployeeDAO {

    int insertEmployee(Connection con, EmployeeDTO employeeDTO) throws SQLException;

    Optional<EmployeeDTO> selectEmployee(Connection con, int employeeId) throws SQLException;

    void update(Connection con, EmployeeDTO employeeDTO) throws SQLException;

    void delete(Connection con, int employeeId) throws SQLException;
}
