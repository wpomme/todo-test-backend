package com.example.todo.service;

import com.example.todo.DTO.TaskInput;
import com.example.todo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {
    @InjectMocks
    TaskServiceImpl taskService;

    @Mock
    TaskRepository taskRepository;

    @Test
    void it_can_edit_a_task() {
        TaskInput taskInput = new TaskInput();
        taskInput.setId("01");
        taskInput.setTitle("Modified Title");
        taskInput.setDescription("Modified Description");
        taskService.edit(taskInput);
        verify(taskRepository).update(any());
    }
}
