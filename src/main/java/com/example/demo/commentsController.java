package com.example.demo;

import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class commentsController {

  private CommentService commentService;

  @Autowired
  public commentsController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping(path = "/comments/{statusId}")
  public List getAll(@PathVariable("statusId") Integer statusId) {
    return commentService.list(statusId);
  }

  @PostMapping(path = "/comments/{statusId}")
  public ResponseEntity createStatus(@PathVariable("statusId") Integer statusId, @RequestParam(value = "message") String message) {
    return new ResponseEntity(commentService.create(statusId, message).toJson(), HttpStatus.OK);
  }

  @PutMapping(path = "/comments/{id}")
  public ResponseEntity updateStatus(@PathVariable("id") Integer id, @RequestParam(value = "message") String message) {
    return new ResponseEntity(commentService.update(id, message).toJson(), HttpStatus.OK);
  }

}
