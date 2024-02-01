package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;

import java.util.List;

public interface TaskRepository {
    List<TaskDTO> selectAll();
}
