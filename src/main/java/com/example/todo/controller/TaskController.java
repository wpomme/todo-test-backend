package com.example.todo.controller;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    }}
