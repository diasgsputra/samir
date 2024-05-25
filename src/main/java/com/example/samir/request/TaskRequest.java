package com.example.samir.request;

import lombok.Data;

@Data
public class TaskRequest {
  private String task_title;
  private String task_description;
  private Long status;
  private Long priority;
}
