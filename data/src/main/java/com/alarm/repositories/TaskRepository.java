package com.alarm.repositories;

import com.alarm.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
