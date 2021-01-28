package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.models.Task;

public interface TaskService {

    public Task createTask(CreateTaskDto taskDto) throws TaskException;

    public Task saveTask(Task task);

    public void removeTask(Integer taskId);

    public Task updateTask(Integer taskId);
}
