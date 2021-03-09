package com.alarm.dtos;

import com.alarm.models.Task;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UpdateObjectHelper {
    public static void updateObject(Object dto, Object actualObject) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] fieldsInDto = dto.getClass().getDeclaredFields();
        for(Field field : fieldsInDto){
            field.setAccessible(true);
            Object fieldValue = field.get(dto);
            if(fieldValue != null){
                String fieldName = fieldValue.getClass().getName();
                String setterMethod = getSetterMethod(fieldName);
                Method method = actualObject.getClass().getDeclaredMethod(setterMethod, field.getType());
                method.setAccessible(true);
                method.invoke(actualObject, fieldValue);

            }
        }
    }

    public static String getSetterMethod(String fieldValue) {
        String firstLetterOfFieldName = String.valueOf(fieldValue.charAt(0)).toUpperCase();
        String fieldNameWithoutFirstLetter = fieldValue.substring(1);
        String fieldName = firstLetterOfFieldName + fieldNameWithoutFirstLetter;
        String setterMethod = "set"+fieldName;
        return setterMethod;
    }
}
