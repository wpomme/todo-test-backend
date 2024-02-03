package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTaskRepository implements TaskRepository {
    private final JdbcTemplate jdbcTemplate;
    public JdbcTaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<TaskDTO> selectAll() {
        //TODO use template literal or that alternatives
        return jdbcTemplate.query(
                "SELECT task.id" +
                        ", task.title" +
                        ", task.description" +
                        ", status.status" +
                        ", task.created_at" +
                        ", task.updated_at " +
                "FROM task " +
                "JOIN status " +
                "  ON task.status_id = status.id", new DataClassRowMapper<>(TaskDTO.class));
    }

    @Override
    public TaskDTO selectById(String id) {
        return jdbcTemplate.queryForObject(
                "SELECT task.id, task.title, task.description, status.status, task.created_at, task.updated_at FROM task JOIN status   ON task.status_id = status.id WHERE task.id = ?",
                TaskDTO.class,
                id
        );
    }
}
