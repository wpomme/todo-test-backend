package com.example.todo.controller;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskService taskService;

    @Test
    void it_can_get_tasks() throws Exception {
        TaskDTO task = new TaskDTO();
        task.setId("01");
        doReturn(task).when(taskService).todo();

        mockMvc.perform(
                get("/tasks")
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("01")));
    }
}
