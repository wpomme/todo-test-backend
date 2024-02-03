package com.example.todo.entity;

public class Task {
    private String id;
    private String description;
    private String statusId;
    public Task(String id, String description, String statusId) {
        this.id = id;
        this.description = description;
        this.statusId = statusId;
    }
}
