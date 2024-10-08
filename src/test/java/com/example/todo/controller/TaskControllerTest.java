package com.example.todo.controller;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import com.example.todo.service.TaskService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskService taskService;

    @Test
    void it_can_get_tasks() throws Exception {
        TaskDTO task1 = new TaskDTO();
        task1.setId("01");
        doReturn(List.of(task1)).when(taskService).todo();

        mockMvc.perform(
                        get("/tasks")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("01")));
    }

    //TODO write test (E2E test succeeded using curl)
    @Test
    void it_can_put_task() throws Exception {
//        mockMvc.perform(
//                put("/tasks", "01")
//        )
//                .andExpect(status().isNoContent());
    }

    @Test
    void it_can_post_task() throws Exception {
        TaskDTO task = new TaskDTO();
        task.setId("01");

        TaskInput taskInput = new TaskInput();
        taskInput.setTitle("Test Title");
        taskInput.setDescription("Test Description");
        doReturn(task).when(taskService).create(taskInput.getTitle(), taskInput.getDescription());

        String json = new ObjectMapper().writeValueAsString(taskInput);

        mockMvc.perform(
                post("/tasks")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isCreated())
                .andExpect(forwardedUrl("/tasks"));
    }
}