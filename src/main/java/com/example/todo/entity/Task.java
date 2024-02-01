package com.example.todo.entity;

public class Task {
    private String taskId;
    private String description;
    private String statusId;
    public Task(String taskId, String description, String statusId) {
        this.taskId = taskId;
        this.description = description;
        this.statusId = statusId;
    }
}
