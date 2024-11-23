package com.backDev.back.repository.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backDev.back.model.qna.Reply;
import com.backDev.back.model.video.VideoReply;

public interface VideoReplyRepository extends JpaRepository<VideoReply, Integer>{
	public Page<VideoReply> findByVideoId(int videoId, Pageable pageable);

}
