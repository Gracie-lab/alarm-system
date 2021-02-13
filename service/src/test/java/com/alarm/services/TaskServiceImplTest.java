package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.TaskDtoMapper;
import com.alarm.models.Category;
import com.alarm.models.Importance;
import com.alarm.models.Task;
import com.alarm.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@Slf4j
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatICanCreatTask() throws TaskException {
        CreateTaskDto task = new CreateTaskDto();
        task.setCategory(Category.RELIGIOUS);
        task.setTaskName("My task");
        task.setTaskDate(LocalDate.of(2020, 2, 5));
        task.setTaskTime(LocalTime.of(8,30));
        task.setImportance(Importance.MEDIUM);

        Task newTask = TaskDtoMapper.mapTaskDtoToTaskObject(task);

        when(taskRepository.findByTaskName("My task")).thenReturn(Optional.empty());
        when(taskRepository.save(newTask)).thenReturn(newTask);

        taskService.createTaskFrom(task);

        verify(taskRepository, times(1)).findByTaskName("My task");
        verify(taskRepository, times(1)).save(newTask);


    }
}