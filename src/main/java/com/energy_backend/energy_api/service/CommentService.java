package com.energy_backend.energy_api.service;

import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.Comment;
import com.energy_backend.energy_api.model.News;
import com.energy_backend.energy_api.model.User;
import com.energy_backend.energy_api.repository.CommentRepository;
import com.energy_backend.energy_api.repository.NewsRepository;
import com.energy_backend.energy_api.repository.UserRepository;
import com.energy_backend.energy_api.repository.classes.commentRepo;
import com.energy_backend.energy_api.repository.classes.userRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, NewsRepository newsRepository, UserRepository userRepository){
        this.commentRepository = commentRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;

    }

    public void insertComment(commentRepo commentBody, Integer newsId){
            News news = newsRepository.findById(newsId).orElseThrow(()-> new EntityNotFoundException("Noticia con "+newsId+"no encontrada"));
            User user = userRepository.findById(commentBody.getUser_id()).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
            System.out.println(commentBody);
            Comment commentToSave = new Comment();
            commentToSave.setBody(commentBody.getBody());
            commentToSave.getNews().add(news);
            commentToSave.setUser(user);
            news.getComments().add(commentToSave);
        try {
            commentRepository.save(commentToSave);
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
