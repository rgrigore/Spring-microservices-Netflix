package com.codecool.video.controller;

import com.codecool.video.controller.service.VideoService;
import com.codecool.video.model.VideoDetailed;
import com.codecool.video.model.VideoList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VideoController {

    private final VideoService service;

    @GetMapping("/all")
    public VideoList allVideos() {
        return service.getAllVideos();
    }

    @GetMapping("/{id}")
    public VideoDetailed video(@PathVariable Long id) {
        return service.getDetailedVideo(id);
    }
}
