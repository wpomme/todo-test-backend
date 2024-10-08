package com.example.todo.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskInput {
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
