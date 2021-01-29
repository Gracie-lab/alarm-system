package com.alarm.dtos;

import com.alarm.models.Task;

import java.lang.reflect.Field;

public class UpdateTaskWith {


    public Task updateTask(UpdateTaskDto updateTaskDto) throws NoSuchFieldException {
        Task task = null;
        Field[] fields = updateTaskDto.getClass().getDeclaredFields();
        for (Field field : fields){
            if(!field.equals(null)){
                Field fieldToUpdate = updateTaskDto.getClass().getDeclaredField(field.getName());
            }
        }
    }
}
