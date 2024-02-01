package com.example.todo.DTO;

public class TaskDTO {
    public String taskId;
    public String description;
    public String statusId;
    public TaskDTO(String taskId, String description, String statusId) {
        this.taskId = taskId;
        this.description = description;
        this.statusId = statusId;
    }
}
