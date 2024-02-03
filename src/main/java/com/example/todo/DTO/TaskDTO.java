package com.example.todo.DTO;

public class TaskDTO {
    public String id;
    public String description;
    public String statusId;
    public TaskDTO(String id, String description, String statusId) {
        this.id = id;
        this.description = description;
        this.statusId = statusId;
    }
}
