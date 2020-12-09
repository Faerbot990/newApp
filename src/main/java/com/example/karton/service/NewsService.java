package com.example.karton.service;

import com.example.karton.model.News;


import java.util.List;

public interface NewsService {
    News getOne(Long id);

    List<News> findAll();

    void saveNewsInfoById(String Title,
                      String description,
                      String filename,
                      Long id);
    News save(News news);
}
