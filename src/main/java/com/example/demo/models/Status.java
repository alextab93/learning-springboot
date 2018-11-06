package com.example.demo.models;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Status {
  private Integer id;
  private String message;
  private List<Comment> comments;

  public Status(Integer id, String message) {
    this.id = id;
    this.message = message;
    this.comments = new ArrayList<>();
  }

  public Status() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List comments) {
    this.comments = comments;
  }

  public JSONObject toJson() {
    JSONObject entity = new JSONObject();
    entity.put("id", this.getId());
    entity.put("message", this.getMessage());
    if(this.comments.size() > 0) {
      JSONArray comments = new JSONArray();
      for (Comment c : this.getComments()) {
        comments.add(c.toJson());
      }
      entity.put("comments", comments);
    }
    return entity;
  }
}
