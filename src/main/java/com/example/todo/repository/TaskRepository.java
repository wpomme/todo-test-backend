package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;

import java.util.List;

public interface TaskRepository {
    List<TaskDTO> selectAll();
    TaskDTO selectById(String id);
    //TODO Fix to return something like "Success" | "Failed"
    int update(TaskDTO task);
}
