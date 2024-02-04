package com.example.todo.repository;

import com.example.todo.DTO.TaskDTO;
import com.example.todo.entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
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
        LocalDateTime timeMock = LocalDateTime.of(2024, 02, 02, 12, 34, 56);
        TaskDTO task1 = new TaskDTO("01", "aaa", "foo", "01", timeMock, timeMock);
        List<TaskDTO> taskList = taskRepository.selectAll();
        assertThat(task1.id).isEqualTo(taskList.get(0).id);
    }

    @Test
    void it_can_select_a_task_by_id() {
        LocalDateTime timeMock = LocalDateTime.of(2024, 02, 02, 12, 34, 56);
        TaskDTO task1 = new TaskDTO("01", "aaa", "foo", "01", timeMock, timeMock);
        TaskDTO task = taskRepository.selectById("01");
        assertThat(task1.id).isEqualTo(task.id);
    }

    @Test
    void it_can_update_a_task_selected_by_id() {
        TaskDTO task = taskRepository.selectById("01");
        // Modify task.title and task.description
        task.title = "Modified by test";
        task.description = "description test";
        int count = taskRepository.update(task);
        // Express SUCCESS when count is 1
        if (count == 1) {
            TaskDTO modifiedTask = taskRepository.selectById("01");
            assertThat(modifiedTask.title).isEqualTo("Modified by test");
        }
    }
}
