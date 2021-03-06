package com.alarm.repositories;

import com.alarm.DataConfig;
import com.alarm.models.Task;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.AnnotationTargetKind;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DataConfig.class)
@ActiveProfiles("tests")
@Slf4j
class TaskRepositoryTest {
    @Autowired
    TaskRepository taskRepository;
    Date date = new Date();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveTask(){
        Task task = new Task();
        task.setTaskName("Meeting");
        task.setTaskDescription("Meeting with the board of directors");
        task.setTaskDate(LocalDate.of(2021,2,2));
        task.setTaskTime(LocalTime.of(9,30));
        taskRepository.save(task);

        assertNotNull(task.getId());
    }

    @Test
    void updateTask(){
        Task task = new Task();
        task.setTaskName("Exercise");
        task.setTaskDescription("Workout with family");
        task.setTaskDate(LocalDate.of(2021,2,2));
        task.setTaskTime(LocalTime.of(9,30));
        taskRepository.save(task);

        task.setTaskTime(LocalTime.of(7,0));
        taskRepository.save(task);

        assertEquals(LocalTime.of(7,0), task.getTaskTime());


    }

    @Test
    void findTaskById(){
        Task task = new Task();
        task.setId(6);

//        Optional<Task> findTask = taskRepository.findById(6);
        Task getTask = taskRepository.getOne(6);
        assertThat(getTask).isNotNull();
        log.info(getTask.getId().toString());
    }

}