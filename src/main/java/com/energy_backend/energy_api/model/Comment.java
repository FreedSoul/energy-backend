package com.energy_backend.energy_api.model;

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
    @ManyToMany(mappedBy = "comments")
    private Set<News> news = new HashSet<>();
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//    ^^^ quitar comentarios cuando se agregue la tabla usuario
//
//    @OneToMany(mappedBy = "user") // Inverse side
//    private List<CommentRepository> comments;
//    ^^^ esto iria en la tabla/clase User
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
