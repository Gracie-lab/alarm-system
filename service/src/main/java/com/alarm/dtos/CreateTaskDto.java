package com.alarm.dtos;

import com.alarm.models.Category;
import com.alarm.models.Importance;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CreateTaskDto {
    private String taskName;
    private LocalDate taskDate;
    private LocalTime taskTime;
    private Importance importance;
    private Category category;
}
