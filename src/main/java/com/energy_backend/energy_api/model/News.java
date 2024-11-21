package com.energy_backend.energy_api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "publish_at")
    @CurrentTimestamp
    private Date date_publish;
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

    public Date getDate_publish() {
        return date_publish;
    }

    public void setDate_publish(Date date_publish) {
        this.date_publish = date_publish;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
