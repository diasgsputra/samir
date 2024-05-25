package com.example.samir.service;

import com.example.samir.request.TaskRequest;
import com.example.samir.response.TaskResponse;

import java.util.List;

public interface TaskService {
  String createTask(TaskRequest taskRequest);
  List<TaskResponse> getAllTask();
  String updateTask(Long id);
}
