package com.energy_backend.energy_api.repository.classes;

import com.energy_backend.energy_api.model.News;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CommentResponseRepo {
    private int id;
    private String body;
    @JsonProperty("user")
    private UserResponseRepo userResponseRepo;
    private LocalDateTime date;

    public CommentResponseRepo(int id, String body, UserResponseRepo userResponseRepo, LocalDateTime date) {
        this.id = id;
        this.body = body;
        this.userResponseRepo = userResponseRepo;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserResponseRepo getUserResponseRepo() {
        return userResponseRepo;
    }

    public void setUserResponseRepo(UserResponseRepo userResponseRepo) {
        this.userResponseRepo = userResponseRepo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
