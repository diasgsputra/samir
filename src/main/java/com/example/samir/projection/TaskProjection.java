package com.example.samir.projection;

public interface TaskProjection {
  Long getId();
  String getTask_title();
  String getTask_description();
  String getStatus_name();
  String getPriority_name();
  String getCreated_at();

}
