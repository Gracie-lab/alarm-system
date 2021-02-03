package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.TaskDtoMapper;
import com.alarm.models.Task;
import com.alarm.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTaskFrom(CreateTaskDto taskDto) throws TaskException {
        boolean taskIsPresent = taskRepository.findByTaskName(taskDto.getTaskName()).isPresent();
        log.info(" -> {}", taskIsPresent);

        if(taskIsPresent) throw new TaskException("Task exists. Do you want to update this task?");
        else return createTask(taskDto);

    }


    private Task createTask(CreateTaskDto taskDto) {
        Task task = TaskDtoMapper.mapTaskDtoToTaskObjecr(taskDto);
        return taskRepository.save(task);
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
    public Task editTask(Integer taskId) {
            return null;
    }
}
