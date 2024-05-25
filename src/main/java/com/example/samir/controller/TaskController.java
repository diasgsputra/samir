package com.example.samir.controller;

import com.example.samir.request.TaskRequest;
import com.example.samir.response.TaskResponse;
import com.example.samir.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping
  public ResponseEntity<String> createTask(@RequestBody TaskRequest taskRequest
  ) {
    String create = taskService.createTask(taskRequest);
    return ResponseEntity.ok(create);
  }

  @GetMapping
  public ResponseEntity<List<TaskResponse>> getTasks() {
    List<TaskResponse> tasks = taskService.getAllTask();
    return ResponseEntity.ok(tasks);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(@PathVariable Long id) {
    String update = taskService.updateTask(id);
    return ResponseEntity.ok(update);
  }

}

