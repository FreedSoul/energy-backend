package com.energy_backend.energy_api.service;

import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.Comment;
import com.energy_backend.energy_api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment insertComment(Comment comment){
        try {
            return commentRepository.save(comment);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error al ejecutar el guardado del comentario en BD",e);
        }
    }

    public List<Comment> findAllCommentsByNewsId(Integer newsId){
        try {
            return commentRepository.findCommentsByNewsId(newsId);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error al listar los comentarios de la BD",e);
        }
    }
}
