package com.example.samir.service;

import com.example.samir.entity.Task;
import com.example.samir.exception.BadRequestException;
import com.example.samir.projection.TaskProjection;
import com.example.samir.repository.TaskRepository;
import com.example.samir.request.TaskRequest;
import com.example.samir.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
  @Autowired
  private TaskRepository taskRepository;

  @Override
  public String createTask(TaskRequest taskRequest) {
    try {
      Task task = new Task(taskRequest);
      taskRepository.save(task);
      return "task saved";
    }catch(Exception e){
      throw new BadRequestException("Request failed");
    }
  }

  @Override
  public List<TaskResponse> getAllTask(){

    try{
      List<TaskProjection> blogs = taskRepository.getALlTask();

      return blogs.stream()
          .map(TaskResponse::new)
          .collect(Collectors.toList());
    }catch(Exception e) {
      throw new BadRequestException("Data is not found");
    }
  }

  @Override
  public String updateTask(Long id) {
    try {
      Optional<Task> taskOptional = taskRepository.findById(id);
      if (taskOptional.isPresent()) {
        Task task = taskOptional.get();
        task.setStatus_id(3L);
        taskRepository.save(task);
        return "Task completed";
      } else {
        throw new BadRequestException("Data is not found");
      }
    }catch(Exception e){
      throw new BadRequestException("Request error");
    }
  }
}
