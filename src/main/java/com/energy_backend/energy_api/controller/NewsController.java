package com.energy_backend.energy_api.controller;

import com.energy_backend.energy_api.model.Comment;
import com.energy_backend.energy_api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public List<Comment> getAllNewsById(){
        newsService.listAllNews();
        return List.of();
    }

//    @GetMapping("/news/{id}")
//    public List<Comment> getANewsById(@PathVariable Integer id){
//
//        return List.of();
//    }
}
