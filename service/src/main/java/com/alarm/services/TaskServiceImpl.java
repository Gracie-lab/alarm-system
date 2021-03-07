package com.alarm.services;

import com.alarm.Exeptions.TaskException;
import com.alarm.dtos.CreateTaskDto;
import com.alarm.dtos.TaskDtoMapper;
import com.alarm.dtos.UpdateTaskDto;
import com.alarm.dtos.UpdateTaskDtoMapper;
import com.alarm.models.Task;
import com.alarm.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Task task = TaskDtoMapper.mapTaskDtoToTaskObject(taskDto);
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

//    @Override
//    public Task editTask(Integer taskId, UpdateTaskDto updateTaskDto) throws NoSuchFieldException, IllegalAccessException {
//        Optional<Task> taskToBeEdited = findTaskById(taskId);
//        Task editedTask = UpdateTaskDtoMapper.updateTaskWith(updateTaskDto, taskToBeEdited.get());
//        return saveTask(editedTask);
//    }

    @Override
    public Task lockTask() {
        return null;
    }

    @Override
    public Task getOneTask(Integer id) {
        return taskRepository.getOne(id);
    }

    @Override
    public Task SearchForTask() {
        return null;
    }

    @Override
    public Task updateTask(UpdateTaskDto updateTaskDto, Integer taskId) throws NoSuchFieldException, IllegalAccessException {
        Task task= getOneTask(taskId);
        UpdateTaskDtoMapper.updateTaskWith(updateTaskDto, task);
        return saveTask(task);
    }

    public Task updateTask(UpdateTaskDto updateTaskDto, Task task) throws NoSuchFieldException, IllegalAccessException {
        UpdateTaskDtoMapper.updateTaskWith(updateTaskDto, task);
        return saveTask(task);
    }

    public Optional<Task> findTaskById(Integer taskId) {
        return taskRepository.findById(taskId);
    }
}
