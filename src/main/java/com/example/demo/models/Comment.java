package com.example.demo.models;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class Comment {
  private Integer id;
  private Integer statusId;
  private String message;

  public Comment(Integer id, Integer statusId, String message) {
    this.id = id;
    this.statusId = statusId;
    this.message = message;
  }

  public Comment() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getStatusId() {
    return statusId;
  }

  public void setStatusId(Integer statusId) {
    this.statusId = statusId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public JSONObject toJson() {
    JSONObject entity = new JSONObject();
    entity.put("id", this.getId());
    entity.put("message", this.getMessage());
    return entity;
  }
}
