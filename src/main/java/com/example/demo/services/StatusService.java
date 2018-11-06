package com.example.demo.services;

import com.example.demo.models.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {
  private CommentService commentService;

  public StatusService(CommentService commentService) {
    this.commentService = commentService;
  }

  private static List<Status> statuses;
  {
    statuses = new ArrayList();
    statuses.add(new Status(1, "Hello World 1"));
    statuses.add(new Status(2, "Hello World 2"));
    statuses.add(new Status(3, "Hello World 3"));
  }

  public List<Status> list() {
    return statuses;
  }

  public Status get(Integer id) {
    var status = statuses.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    status.setComments(this.commentService.list(status.getId()));
    return status;
  }

  public Status create(String message) {
    var id = statuses.get(statuses.size() - 1).getId() + 1;
    var status = new Status(id, message);
    statuses.add(status);
    return status;
  }

  public Status update(Integer id, String message) {
    var status = this.get(id);
    status.setMessage(message);
    return status;
  }
}
