package com.alarm.services;

import com.alarm.DataConfig;
import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.EditTaskDto;
import com.alarm.models.Category;
import com.alarm.models.Importance;
import com.alarm.models.Task;
import com.alarm.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = DataConfig.class)
class TaskServiceImplTest_IT {
    @Autowired
    TaskServiceImpl taskService;

    @Autowired
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateTaskService() throws TaskException {
        CreateTaskDto taskDto = new CreateTaskDto();
        taskDto.setTaskName("Prays");
        taskDto.setTaskTime(LocalTime.of(10,0));
        taskDto.setImportance(Importance.HIGH);
        taskDto.setTaskDate(LocalDate.of(2021, 9, 10));
        taskDto.setCategory(Category.RELIGIOUS);

        taskService.createTaskFrom(taskDto);

        assertThat(taskService.createTaskFrom(taskDto).getId()).isNotNull();
    }

    @Test
    void can_update_task() throws NoSuchFieldException, IllegalAccessException {

        Task task = new Task();
        task.setTaskName("Read");
        task.setCategory(Category.PERSONAL);
        task.setLevelOfImportance(Importance.HIGH);
        taskService.saveTask(task);
        assertThat(task.getId()).isNotNull();
        log.info("Task before update -> {}", task);

        EditTaskDto editTaskDto = new EditTaskDto();
        editTaskDto.setTaskName("Sleep");
        editTaskDto.setCategory(Category.OFFICIAL);
//        UpdateTaskDtoMapper.updateTaskWith(updateTaskDto, task);
        taskService.updateTask(editTaskDto, task);
        log.info("Task after update -> {}", task);
        assertThat(task.getTaskName()).isEqualTo("Sleep");

    }
}