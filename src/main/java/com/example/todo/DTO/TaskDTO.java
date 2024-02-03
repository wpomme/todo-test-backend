package com.example.todo.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDTO {
    public String id;
    public String description;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public TaskDTO(String id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
