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
        return jdbcTemplate.query("SELECT id, description, status_id, created_at, updated_at FROM task", new DataClassRowMapper<>(TaskDTO.class));
    }
}
