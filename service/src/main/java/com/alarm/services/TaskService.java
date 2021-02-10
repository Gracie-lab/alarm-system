package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.UpdateTaskDto;
import com.alarm.models.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

    public Task createTaskFrom(CreateTaskDto taskDto) throws TaskException;

    public Task saveTask(Task task);

    public void removeTask(Integer taskId);

    public Task editTask(Integer taskId, UpdateTaskDto updateTaskDto) throws NoSuchFieldException;
}
