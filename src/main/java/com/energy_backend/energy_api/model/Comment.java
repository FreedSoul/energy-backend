package com.energy_backend.energy_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "body", nullable = false, columnDefinition = "text")
    @NotNull(message = "el cuerpo del comentario no puede estar vacio")
    private String body;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false,columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date;
    @ManyToMany(mappedBy = "comments", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<News> news = new HashSet<>();

    public Comment( ) { }

    public Comment(int id, String body, LocalDateTime date, Set<News> news, User user) {
        this.id = id;
        this.body = body;
        this.date = date;
        this.news = news;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }
}
