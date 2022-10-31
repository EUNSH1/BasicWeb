package com.esh.start.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.esh.start.board.qna.QnaVO;
import com.esh.start.util.Pager;

@Mapper
public interface QnaMapper {
	public List<QnaVO> getList(Pager pager) throws Exception;
	
	public int setQnaList(QnaVO qnaVO) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;
	
	public QnaVO getListDetail(QnaVO qnaVO) throws Exception;
}
