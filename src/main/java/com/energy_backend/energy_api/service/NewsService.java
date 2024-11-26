package com.energy_backend.energy_api.service;

import com.energy_backend.energy_api.exceptions.DatabaseOperationException;
import com.energy_backend.energy_api.model.News;
import com.energy_backend.energy_api.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }

    public News findById(int id){
        try{
            return newsRepository.findById(id).orElseThrow(IllegalAccessException::new);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error al encontrar la referencia de la noticia por su id",e);
        }
    }

    public List<News> listAllNews(){
        try{
            return newsRepository.findAll();
        } catch (Exception e) {
            throw new DatabaseOperationException("No se encuentra la entidad correspondiente a noticias",e);
        }
    }

}


