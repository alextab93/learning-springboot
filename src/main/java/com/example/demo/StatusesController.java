package com.example.demo;

import com.example.demo.models.Comment;
import com.example.demo.services.StatusService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StatusesController {
  private StatusService statusService;

  @Autowired
  public StatusesController(StatusService statusService) {
    this.statusService = statusService;
  }

  @GetMapping(path = "/statuses")
  public List getAll() {
    return statusService.list().stream()
            .map(status -> status.toJson())
            .collect(Collectors.toList());
  }

  @GetMapping(path = "/statuses/{id}")
  public ResponseEntity getStatus(@PathVariable("id") Integer id) {
    return new ResponseEntity(statusService.get(id).toJson(), HttpStatus.OK);
  }

  @PostMapping(path = "/statuses")
  public ResponseEntity createStatus(@RequestParam(value = "message") String message) {
    return new ResponseEntity(statusService.create(message).toJson(), HttpStatus.OK);
  }

  @PutMapping(path = "/statuses/{id}")
  public ResponseEntity updateStatus(@PathVariable("id") Integer id, @RequestParam(value = "message") String message) {
    return new ResponseEntity(statusService.update(id, message).toJson(), HttpStatus.OK);
  }
}
