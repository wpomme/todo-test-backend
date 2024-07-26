package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;

import java.util.List;

public interface TaskRepository {
    List<TaskDTO> selectAll();
    TaskDTO selectById(String id);
    void update(TaskInput taskInput);
    void create(TaskInput taskInput);
    void deleteById(String id);
}
