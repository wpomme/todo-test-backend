package com.example.todo.service;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.entity.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskListImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<TaskDTO> todo() {
        return taskRepository.selectAll();
    }
}
