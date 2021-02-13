package com.alarm.dtos;

import com.alarm.models.Task;

import java.lang.reflect.Field;

public class UpdateTaskWith {


    public static Task updateTaskWith(UpdateTaskDto updateTaskDto, Task task) throws NoSuchFieldException {
        Field[] fieldsToUpdate = task.getClass().getDeclaredFields();
        Field[] fields = updateTaskDto.getClass().getDeclaredFields();
        for (Field field : fields){
            if(field != null){
                for(Field aField : fieldsToUpdate){
                    if(aField.getName().equals(field.getName())){
                        aField = field;
                    }
                }
            }
        }
        return task;
    }
}
