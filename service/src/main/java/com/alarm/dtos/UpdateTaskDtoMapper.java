package com.alarm.dtos;

import com.alarm.models.Task;

import java.lang.reflect.Field;

public class UpdateTaskDtoMapper {


    public static Task updateTaskWith(UpdateTaskDto updateTaskDto, Task task) throws NoSuchFieldException, IllegalAccessException {
        Field[] fieldsInTaskObject = task.getClass().getDeclaredFields();
        Field[] fieldsInDto = updateTaskDto.getClass().getDeclaredFields();
        for (Field fieldInDto : fieldsInDto){
            fieldInDto.setAccessible(true);
            Object dtoFieldValue = fieldInDto.get(updateTaskDto);
            if(dtoFieldValue != null){
                for(Field fieldInTaskObject : fieldsInTaskObject){
                    fieldInTaskObject.setAccessible(true);
                    if(fieldInDto.getName().equals(fieldInTaskObject.getName())){
                        fieldInTaskObject.set(task, dtoFieldValue);
                    }
                }
            }
        }
        return task;
    }

//    public static void some(Task task) throws IllegalAccessException {
//        Field[] fields = task.getClass().getDeclaredFields();
////        Field[] fields = updateTaskDto.getClass().getDeclaredFields();
//
//        for (Field field : fields){
//            field.setAccessible(true);
//            String fieldName = field.getName();
//            Object fieldValue = field.get(task);
//            System.out.println(fieldName);
//            if(fieldValue == null){
//                System.out.println("yeah");
//            }
//            else{
//                System.out.println(fieldValue.toString());
//            }
//        }
//    }
}
