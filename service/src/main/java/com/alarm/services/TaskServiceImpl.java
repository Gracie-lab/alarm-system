package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.TaskDtoMapper;
import com.alarm.models.Task;
import com.alarm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTask(CreateTaskDto taskDto) throws TaskException {
        if(taskRepository.findByTaskName(taskDto.getTaskName()).isPresent()){
            throw new TaskException("Task exists. Do you want to update this task?");
        }
        else{
            Task task = TaskDtoMapper.mapTaskDtoToTaskObjecr(taskDto);
            return taskRepository.save(task);

        }
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void removeTask(Integer taskId) {
        taskRepository.deleteById(taskId);

    }

    @Override
    public Task updateTask(Integer taskId) {
            return null;
    }
}
