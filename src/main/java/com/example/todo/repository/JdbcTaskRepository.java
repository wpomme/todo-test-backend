package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
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
                "SELECT task.id, task.title, task.description, task.created_at, task.updated_at FROM task", new DataClassRowMapper<>(TaskDTO.class));
    }

    @Override
    public TaskDTO selectById(String id) {
        return jdbcTemplate.queryForObject(
                "SELECT task.id, task.title, task.description, task.created_at, task.updated_at FROM task WHERE task.id = ?",
                new DataClassRowMapper<>(TaskDTO.class),
                id
        );
    }

    @Override
    public void update(TaskInput taskInput) {
        jdbcTemplate.update(
                "UPDATE task SET title = ?, description = ? WHERE id = ?",
                taskInput.getTitle(),
                taskInput.getDescription(),
                taskInput.getId()
        );
    }

    @Override
    public void create(TaskInput taskInput) {
        jdbcTemplate.update(
                "INSERT INTO task (id, title, description) VALUES (?, ?, ?)",
                //TODO make id auto generated
                taskInput.getId(),
                taskInput.getTitle(),
                taskInput.getDescription()
        );
    }

    public void deleteById(String id) {
        jdbcTemplate.update(
                "DELETE FROM task WHERE id = ?",
                id
        );
    }
}
