package com.example.todo.service;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<TaskDTO> todo() {
        return taskRepository.selectAll();
    }

    @Override
    public int edit(String taskId, TaskInput taskInput) {
        TaskDTO task = taskRepository.selectById(taskId);
        task.title = taskInput.title;
        task.description = taskInput.description;
        return taskRepository.update(task);
    }
}
