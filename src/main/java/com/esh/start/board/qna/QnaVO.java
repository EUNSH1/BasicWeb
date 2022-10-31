package com.esh.start.board.qna;

import java.sql.Date;

import com.esh.start.board.qna.QnaVO;

import lombok.Data;

@Data
public class QnaVO {
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
}
