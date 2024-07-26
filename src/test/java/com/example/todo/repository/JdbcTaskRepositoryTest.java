package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@JdbcTest
public class JdbcTaskRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new JdbcTaskRepository(jdbcTemplate);
    }

    @Test
    void it_can_select_all_tasks() {
        //TODO create respectable mock for datetime
        List<TaskDTO> taskList = taskRepository.selectAll();
        assertThat("01").isEqualTo(taskList.get(0).getId());
    }

    @Test
    void it_can_select_a_task_by_id() {
        TaskDTO task = taskRepository.selectById("01");
        assertThat("01").isEqualTo(task.getId());
    }

    @Test
    void it_can_update_a_task_selected_by_id() {
        String taskId = "01";
        String taskTitle = "Modified by test";
        // Modify task.title and task.description
        TaskInput taskInput = new TaskInput();
        taskInput.setId(taskId);
        taskInput.setTitle(taskTitle);
        taskInput.setDescription("description test");
        taskRepository.update(taskInput);
        TaskDTO modifiedTask = taskRepository.selectById(taskId);
        assertThat(modifiedTask.getTitle()).isEqualTo(taskTitle);
    }

    @Test
    void it_can_create_a_task() {
        String taskId = "test01";
        String taskTitle = "Created by test";
        TaskInput taskInput = new TaskInput();
        taskInput.setId(taskId);
        taskInput.setTitle(taskTitle);
        taskInput.setDescription("Description Created by test");
        taskRepository.create(taskInput);
        TaskDTO createdTask = taskRepository.selectById(taskId);
        assertThat(createdTask.getTitle()).isEqualTo(taskTitle);
    }

    @Test
    void it_can_delete_a_task() {
        String taskId = "01";
        taskRepository.deleteById(taskId);

        try {
            taskRepository.selectById(taskId);
        } catch (RuntimeException ex) {
            assertThat(ex).isInstanceOf(EmptyResultDataAccessException.class);
        }
    }
}
