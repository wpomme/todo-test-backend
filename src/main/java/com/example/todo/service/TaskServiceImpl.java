package com.example.todo.service;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public void edit(TaskInput taskInput) {
        taskRepository.updateById(taskInput);
    }

    @Override
    public TaskDTO create(String title, String description) {
        UUID uuid = UUID.randomUUID();
        TaskInput taskInput = new TaskInput();
        //FIXME Fix to not change uuid's type
        taskInput.setId(uuid.toString());
        taskInput.setTitle(title);
        taskInput.setDescription(description);
        taskRepository.create(taskInput);
        return taskRepository.selectById(uuid.toString());
    }

    @Override
    public void delete(String id) {
        taskRepository.deleteById(id);
    }
}
