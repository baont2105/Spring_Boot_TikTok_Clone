package com.baont.controller;

import com.baont.entity.Video;
import com.baont.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VideoTestController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/video-test")
    public String showVideo(Model model) {
        Video video = videoService.getVideoById(1); // Lấy video có ID = 1
        model.addAttribute("video", video);
        return "video-test";
    }

    @PostMapping("/video-test")
    public String searchVideo(@RequestParam("id") Integer id, Model model) {
        Video video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        return "video-test";
    }

}