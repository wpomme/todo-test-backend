package com.example.todo.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDTO {
    public String id;
    public String description;
    public String statusId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public TaskDTO(String id, String description, String statusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.description = description;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
