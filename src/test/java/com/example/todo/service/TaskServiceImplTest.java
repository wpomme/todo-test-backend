package com.example.todo.service;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import com.example.todo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {
    @InjectMocks
    TaskServiceImpl taskService;

    @Mock
    TaskRepository taskRepository;

    @Test
    void it_can_get_all_todo() {
        List<TaskDTO> todo = new ArrayList<>();
        doReturn(todo).when(taskRepository).selectAll();

        //FIXME
        List<TaskDTO> actual = taskService.todo();
        assertThat(actual.size()).isEqualTo(0);
    }

    @Test
    void it_can_edit_a_task() {
        TaskInput taskInput = new TaskInput();
        taskInput.setId("01");
        taskInput.setTitle("Modified Title");
        taskInput.setDescription("Modified Description");
        taskService.edit(taskInput);
        verify(taskRepository).updateById(any());
    }

    @Test
    void it_can_create_a_task() {
        taskService.create("title", "description");
        verify(taskRepository).create(any());
    }
}
