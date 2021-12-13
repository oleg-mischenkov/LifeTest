package com.mischenkov;

import com.mischenkov.dao.CompanyDAO;
import com.mischenkov.dao.EmployeeDAO;
import com.mischenkov.dao.JDBCTemplate;
import com.mischenkov.dao.impl.CompanyDAOImpl;
import com.mischenkov.dao.impl.EmployeeDAOImpl;
import com.mischenkov.dao.impl.TaskDAOImpl;
import com.mischenkov.dto.CompanyDTO;
import com.mischenkov.dto.EmployeeDTO;
import com.mischenkov.dto.TaskDTO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main( String[] args ) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "oleg");
        properties.setProperty("password", "QW7784218qw");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/life_db?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false",
                properties
        );

        JDBCTemplate jdbcTemplate = new JDBCTemplate();

        TaskDAOImpl taskDAO = new TaskDAOImpl(jdbcTemplate);

        /*Select*/
        TaskDTO taskDTO = taskDAO.selectTask(connection, 353).get();
        LOGGER.info(taskDTO);

        /*Insert*/
        int id = taskDAO.insertTask(connection, taskDTO);
        taskDTO = taskDAO.selectTask(connection, id).get();
        LOGGER.info(taskDTO);

        /*Update*/
        taskDAO.update(connection,taskDTO.setId(355));
        LOGGER.info(taskDAO.selectTask(connection, 355).get());

        /*Delete*/
        taskDAO.delete(connection, id);

        /*EMPLOYEE*/
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(jdbcTemplate);

        /*Select*/
        EmployeeDTO employeeDTO = employeeDAO.selectEmployee(connection, 1).get();
        LOGGER.info(employeeDTO);

        /*Insert*/
        id = employeeDAO.insertEmployee(connection, employeeDTO);
        LOGGER.info(employeeDAO.selectEmployee(connection, id).get());

        /*Update*/
        employeeDAO.update(connection, employeeDTO.setId(25));
        LOGGER.info(employeeDAO.selectEmployee(connection, 25).get());

        /*Delete*/
        employeeDAO.delete(connection, id);

        /*COMPANY*/
        CompanyDAO companyDAO = new CompanyDAOImpl(jdbcTemplate);

        /*Select*/
        CompanyDTO companyDTO = companyDAO.selectEmployee(connection, 1).get();
        LOGGER.info(companyDTO);

        /*Insert*/
        id = companyDAO.insertCompany(connection, companyDTO);
        LOGGER.info(companyDAO.selectEmployee(connection, id).get());

        /*Update*/
        companyDAO.update(connection, companyDTO.setId(6));
        LOGGER.info(companyDAO.selectEmployee(connection, 6).get());

        /*Delete*/
        companyDAO.delete(connection, id);
    }
}
