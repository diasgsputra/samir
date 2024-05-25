package com.example.samir.entity;

import com.example.samir.request.TaskRequest;
import lombok.Data;

import javax.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

import static java.time.LocalDate.now;

@Entity
@Data
@Table(name = "task")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String task_title;
  private String task_description;
  private Long status_id;
  private Long priority_id;

  public Task(TaskRequest taskRequest){
    this.task_title = taskRequest.getTask_title();
    this.task_description = taskRequest.getTask_description();
    this.status_id = taskRequest.getStatus();
    this.priority_id = taskRequest.getPriority();
  }

  public Task(){
  }

}

