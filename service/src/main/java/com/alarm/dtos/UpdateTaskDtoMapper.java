package com.alarm.dtos;

import com.alarm.models.Task;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UpdateTaskDtoMapper {


    public static Task updateTaskWith(EditTaskDto editTaskDto, Task task) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
       UpdateObjectHelper.updateObject(editTaskDto, task);
        return task;
    }


}
