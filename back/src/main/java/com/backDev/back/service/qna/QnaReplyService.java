package com.backDev.back.service.qna;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backDev.back.model.User;
import com.backDev.back.model.qna.Board;
import com.backDev.back.model.qna.Reply;
import com.backDev.back.repository.qna.QnaRepository;
import com.backDev.back.repository.qna.QnaReplyRepository;

@Service
public class QnaReplyService {
	@Autowired
	QnaReplyRepository replyRepository;
	@Autowired
	QnaRepository boardRepository; 

	@Transactional
	public Reply 댓글저장(User user, int boardId, Reply reply ){
		Board board = boardRepository.findById(boardId).
				orElseThrow(()->{
					return new IllegalArgumentException("댓글 쓰기 실패: 아이디를 찾을수 없습니다.");
				});
		
	    if (reply.getContent() == null || reply.getContent().trim().isEmpty()) {
	        throw new IllegalArgumentException("댓글 내용이 없습니다.");
	    }
	    
		reply.setUser(user);
		reply.setBoard(board);
		replyRepository.save(reply);
		
		return reply;
	}
	
	@Transactional
	public void 댓글삭제(int replyId) {
		replyRepository.deleteById(replyId);
	}
	
	@Transactional
	public Reply 댓글수정(int replyId, Reply reply) {
		Reply findReply =  replyRepository.findById(replyId)
				.orElseThrow(()->{
					return new IllegalArgumentException("댓글 수정 실패: 아이디를 찾을수 없습니다.");
				});
		
		if (reply.getContent() == null || reply.getContent().trim().isEmpty()) {
	        throw new IllegalArgumentException("댓글 내용이 없습니다.");
	    }
		
		findReply.setContent(reply.getContent());
		findReply.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		return reply;
	}
	 
	@Transactional(readOnly = true)
	public Page<Reply>댓글목록(int boardId, Pageable pageable){
		return replyRepository.findByBoardId(boardId, pageable);
	} 
	 
}
