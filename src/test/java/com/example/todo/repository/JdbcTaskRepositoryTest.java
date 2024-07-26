package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.DTO.TaskInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
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
        TaskDTO task = taskRepository.selectById(taskId);
        // Modify task.title and task.description
        TaskInput taskInput = new TaskInput();
        taskInput.setId(taskId);
        taskInput.setTitle("Modified by test");
        taskInput.setDescription("description test");
        int count = taskRepository.update(taskInput);
        // Express SUCCESS when count is 1
        if (count == 1) {
            TaskDTO modifiedTask = taskRepository.selectById("01");
            assertThat(modifiedTask.getTitle()).isEqualTo("Modified by test");
        }
    }
}
