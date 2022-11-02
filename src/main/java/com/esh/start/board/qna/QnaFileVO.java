package com.esh.start.board.qna;

import lombok.Data;


// 상속받을때는 data 안 씀 단독으로 사용할때만
@Data
public class QnaFileVO {
	private Long fileNum;
	private Long num;
	private String fileName;
	private String oriName;
 	
}