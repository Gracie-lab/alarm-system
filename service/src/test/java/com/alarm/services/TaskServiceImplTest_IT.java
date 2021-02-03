package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.models.Category;
import com.alarm.models.Importance;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceImplTest_IT {

    TaskServiceImpl taskService = new TaskServiceImpl();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateTaskService() throws TaskException {
        CreateTaskDto taskDto = new CreateTaskDto();
        taskDto.setTaskName("Pray");
        taskDto.setTaskTime(LocalTime.of(10,0));
        taskDto.setImportance(Importance.HIGH);
        taskDto.setTaskDate(LocalDate.of(2021, 9, 10));
        taskDto.setCategory(Category.RELIGIOUS);

        taskService.createTaskFrom(taskDto);

        assertThat(taskService.createTaskFrom(taskDto).getId()).isNotNull();
    }
}