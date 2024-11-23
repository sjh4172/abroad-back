package com.backDev.back.repository.video;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backDev.back.model.video.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
