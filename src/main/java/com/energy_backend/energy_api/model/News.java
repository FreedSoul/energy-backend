package com.energy_backend.energy_api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", nullable = false, length = 255)
    private String title;
    @Column(name = "content", nullable = false, columnDefinition = "text")
    private String content;
    @Column(name = "author", nullable = false, length = 255)
    private String author;
    @CreationTimestamp
    @Column(name = "publish_at", columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime datePublish;
    @ManyToMany
    @JoinTable(
            name = "news_comments",
            joinColumns = { @JoinColumn(name = "news_id") },
            inverseJoinColumns = { @JoinColumn(name = "comment_id") }
    )
    private Set<Comment> comments = new HashSet<>();

    public News(){}

    public News(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDateTime datePublish) {
        this.datePublish = datePublish;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
