package com.baont.controller;

import com.baont.entity.Video;
import com.baont.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React frontend gọi
public class VideoRestController {

    private final VideoService videoService;

    public VideoRestController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/")
    public Video getVideoById(@RequestParam("id") Integer id) {
        return videoService.getVideoById(id);
    }
}