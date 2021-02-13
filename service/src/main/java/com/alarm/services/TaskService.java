package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.UpdateTaskDto;
import com.alarm.models.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

    Task createTaskFrom(CreateTaskDto taskDto) throws TaskException;

    Task saveTask(Task task);

    void removeTask(Integer taskId);

    Task editTask(Integer taskId, UpdateTaskDto updateTaskDto) throws NoSuchFieldException;

    Task lockTask();

    Task SearchForTask();




}
