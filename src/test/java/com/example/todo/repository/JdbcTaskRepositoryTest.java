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
        TaskDTO task1 = new TaskDTO("01", "aaa", "Active", timeMock, timeMock);
        // TaskDTO task2 = new TaskDTO("02", "bbb", "02");
        List<TaskDTO> taskList = taskRepository.selectAll();
        assertThat(task1.id).isEqualTo(taskList.get(0).id);
    }
}
