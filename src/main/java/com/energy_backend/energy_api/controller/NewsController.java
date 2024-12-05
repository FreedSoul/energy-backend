package com.energy_backend.energy_api.controller;

import com.energy_backend.energy_api.model.News;
import com.energy_backend.energy_api.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public Optional<List<News>> getAllNewsById(){
        return Optional.ofNullable(newsService.listAllNews());
    }

    @GetMapping("/news/{newsId}")
    public Optional<News> getOneNewsById(@PathVariable Integer newsId){
        return Optional.ofNullable(newsService.findById(newsId));
    }
}
