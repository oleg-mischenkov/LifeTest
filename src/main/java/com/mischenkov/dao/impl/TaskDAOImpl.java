package com.mischenkov.dao.impl;

import com.mischenkov.dao.JDBCTemplate;
import com.mischenkov.dao.RowMapper;
import com.mischenkov.dao.TaskDAO;
import com.mischenkov.dto.TaskDTO;
import com.mischenkov.entity.Task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class TaskDAOImpl implements TaskDAO {

    private static final String SELECT_TASK_BY_ID = "SELECT `id`, `title`, `description`, `employee_id` FROM task WHERE `id` = ?";
    private static final String INSERT_TASK = "INSERT INTO task (`title`, `description`, `employee_id`) VALUES (?, ?, ?)";
    private static final String UPDATE_TASK = "UPDATE task SET `title` = ?, `description` = ?, `employee_id`= ? WHERE `id` = ?";
    private static final String DELETE_TASK = "DELETE FROM task WHERE `id`= ?";

    private final JDBCTemplate template;

    public TaskDAOImpl(JDBCTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @Override
    public int insertTask(Connection con, TaskDTO taskDTO) throws SQLException {
        return template.insert(con, INSERT_TASK,
                taskDTO.getTask().getTitle(),
                taskDTO.getTask().getDescription(),
                taskDTO.getEmployeeId()
        );
    }

    @Override
    public Optional<TaskDTO> selectTask(Connection con, int taskId) throws SQLException {
        return template.executeQuery(con, SELECT_TASK_BY_ID, dtoRowMapper, taskId)
                .stream()
                .findFirst();
    }

    @Override
    public void update(Connection con, TaskDTO taskDTO) throws SQLException {
        template.update(con, UPDATE_TASK,
                taskDTO.getTask().getTitle(),
                taskDTO.getTask().getDescription(),
                taskDTO.getEmployeeId(),
                taskDTO.getId()
        );
    }

    @Override
    public void delete(Connection con, int taskId) throws SQLException {
        template.update(con, DELETE_TASK, taskId);
    }

    private final RowMapper<TaskDTO> dtoRowMapper = rs -> new TaskDTO()
            .setId(rs.getInt("id"))
            .setTask(new Task(
                    rs.getString("title"),
                    rs.getString("description")
                    ))
            .setEmployeeId(rs.getInt("employee_id"));

}
