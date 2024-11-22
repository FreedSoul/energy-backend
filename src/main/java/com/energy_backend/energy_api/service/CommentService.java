package com.energy_backend.energy_api.service;

import com.energy_backend.energy_api.model.Comment;
import com.energy_backend.energy_api.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository){}

    public Comment insertComment(Comment comment){
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> insertComment(Comment comment){
        try {
            return commentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
