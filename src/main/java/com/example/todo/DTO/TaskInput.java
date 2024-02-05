package com.example.todo.DTO;

import org.springframework.lang.NonNull;

public class TaskInput {
    @NonNull
    private String title;
    @NonNull
    private String description;

    public TaskInput(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
