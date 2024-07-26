package com.example.todo.controller;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import com.example.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getTasks() {
        List<TaskDTO> taskList = taskService.todo();
        return ResponseEntity
                .ok()
                .body(taskList);
    }

    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editTask(
            @PathVariable String id,
            @Validated @RequestBody TaskInput taskInput
            ) {
        taskInput.setId(id);
        taskService.edit(taskInput);
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createTask(
            @Validated @RequestBody TaskInput taskInput
    ) {
        TaskDTO task = taskService.create(taskInput.getTitle(), taskInput.getDescription());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(task.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable String id) {
        taskService.delete(id);
    }
}
