package com.codecool.video.controller.service;

import com.codecool.video.controller.repository.VideoRepository;
import com.codecool.video.model.Video;
import com.codecool.video.model.VideoDetailed;
import com.codecool.video.model.VideoList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VideoService {

    private final VideoRepository repository;
    private final RecommendationsServiceCaller recommendationsServiceCaller;

    public VideoList getAllVideos() {
        return VideoList.builder().videos(repository.findAll()).build();
    }

    public Video getVideo(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public VideoDetailed getDetailedVideo(Long videoId) {
        return VideoDetailed.builder()
                .video(getVideo(videoId))
                .recommendations(recommendationsServiceCaller.getRecommendations(videoId))
                .build();
    }
}
