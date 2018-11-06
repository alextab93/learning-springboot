package com.example.demo.services;

import com.example.demo.models.Comment;
import com.example.demo.models.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

  private static List<Comment> comments;
  {
    comments = new ArrayList();
    comments.add(new Comment(1, 1, "Hello World 1.1"));
    comments.add(new Comment(2, 1, "Hello World 1.2"));
    comments.add(new Comment(3, 2, "Hello World 2.1"));
    comments.add(new Comment(4, 2, "Hello World 2.2"));
    comments.add(new Comment(5, 3, "Hello World 3.1"));
    comments.add(new Comment(6, 3, "Hello World 3.2"));
  }

  public List list(Integer statusId) {
    return comments.stream()
            .filter(comment -> comment.getStatusId().equals(statusId))
            .collect(Collectors.toList());
  }

  public Comment get(Integer id) {
    return comments.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
  }

  public Comment create(Integer statusId, String message) {
    var id = comments.get(comments.size() - 1).getId() + 1;
    var comment = new Comment(id, statusId, message);
    comments.add(comment);
    return comment;
  }

  public Comment update(Integer id, String message) {
    var comment = this.get(id);
    comment.setMessage(message);
    return comment;
  }
}
