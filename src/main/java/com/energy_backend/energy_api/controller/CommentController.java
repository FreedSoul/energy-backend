package com.energy_backend.energy_api.controller;

import com.energy_backend.energy_api.model.Comment;
import com.energy_backend.energy_api.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/comment")
    public ResponseEntity<String> findById(@Valid @RequestBody Comment comment) {
        commentService.insertComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body("comentario insertado con exito!");
    }

//    @GetMapping("/comments/{newsId}")
//    public List<Comment> getAllCommentsByNewsId(@PathVariable Integer newsId){
//
//        return List.of();
//    }
}
