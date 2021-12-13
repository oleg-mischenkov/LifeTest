package com.mischenkov.dao;

import com.mischenkov.dto.TaskDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public interface TaskDAO {

    int insertTask(Connection con, TaskDTO taskDTO) throws SQLException;

    Optional<TaskDTO> selectTask(Connection con, int taskId) throws SQLException;

    void update(Connection con, TaskDTO taskDTO) throws SQLException;

    void delete(Connection con, int taskId) throws SQLException;
}
