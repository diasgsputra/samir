package com.example.samir.repository;

import com.example.samir.entity.Task;
import com.example.samir.projection.TaskProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  @Query(value = "SELECT t.id, t.task_title, t.task_description, s.status_name, tp.priority_name, t.created_at FROM task t " +
      "JOIN `status` s ON s.id = t.status_id " +
      "JOIN task_priority tp ON tp.id = t.priority_id " +
      "ORDER BY tp.id DESC", nativeQuery = true)
  List<TaskProjection> getALlTask();
}

