package com.baont.service.impl;

import com.baont.entity.Video;
import com.baont.repository.VideoRepository;
import com.baont.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
