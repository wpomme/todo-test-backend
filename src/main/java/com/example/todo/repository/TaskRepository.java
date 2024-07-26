package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;

import java.util.List;
import java.util.Map;

public interface TaskRepository {
    List<TaskDTO> selectAll();
    TaskDTO selectById(String id);
    //TODO Fix to return something like "Success" | "Failed"
    void update(TaskInput taskInput);
    void create(TaskInput taskInput);
}
