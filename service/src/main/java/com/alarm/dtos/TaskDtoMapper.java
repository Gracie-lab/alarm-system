package com.alarm.dtos;

import com.alarm.models.Task;
import com.sun.source.util.TaskListener;

public class TaskDtoMapper {

    public static Task mapTaskDtoToTaskObject(CreateTaskDto taskDto){
        Task task = new Task();

        task.setTaskName(taskDto.getTaskName());
        task.setTaskTime(taskDto.getTaskTime());
        task.setCategory(taskDto.getCategory());
        task.setTaskDate(taskDto.getTaskDate());
        task.setLevelOfImportance(taskDto.getImportance());

        return task;
    }
}
