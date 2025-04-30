package com.baont.service;

import com.baont.entity.Video;

import java.util.List;

public interface VideoService {
    Video getVideoById(Integer id);
    List<Video> getAllVideos();
}