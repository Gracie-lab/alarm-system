package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.EditTaskDto;
import com.alarm.models.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

    Task createTaskFrom(CreateTaskDto taskDto) throws TaskException;

    Task saveTask(Task task);

    void removeTask(Integer taskId);

//    Task editTask(Integer taskId, UpdateTaskDto updateTaskDto) throws NoSuchFieldException, IllegalAccessException;

    Task lockTask();

    Task getOneTask(Integer id);

    Task SearchForTask();
    Task updateTask(EditTaskDto editTaskDto, Integer taskId) throws NoSuchFieldException, IllegalAccessException;




}
