package com.alarm.dtos;

import com.alarm.models.Category;
import com.alarm.models.Importance;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditTaskDto {
    private String taskName;

    private LocalDate taskDate;

    private LocalTime taskTime;

    private Importance levelOfImportance;

    private String taskDescription;

    private Category category;
}
