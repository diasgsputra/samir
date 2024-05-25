package com.example.samir.response;

import com.example.samir.projection.TaskProjection;
import lombok.Data;

@Data
public class TaskResponse {
  private Long id;
  private String task_title;
  private String task_description;
  private String status;
  private String priority;
  private String created_at;
  public TaskResponse(TaskProjection task){
    this.id = task.getId();
    this.task_title = task.getTask_title();
    this.task_description = task.getTask_description();
    this.status = task.getStatus_name();
    this.priority = task.getPriority_name();
    this.created_at = task.getCreated_at();
  }
}
