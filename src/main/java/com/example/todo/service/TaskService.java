package com.example.todo.service;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;

import java.util.List;

public interface TaskService {
    List<TaskDTO> todo();
    int edit(String taskId, TaskInput taskInput);
}
