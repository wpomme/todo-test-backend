package com.example.todo.controller;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import com.example.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}
