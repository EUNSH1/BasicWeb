package com.esh.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esh.start.board.qna.QnaVO;
import com.esh.start.util.Pager;

@Service
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager) throws Exception{
		Long totalCount = qnaMapper.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return qnaMapper.getList(pager);
	}

	public int setQnaList(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.setQnaList(qnaVO);
	}
	
	public QnaVO getListDetail(QnaVO qnaVO) throws Exception {
		
		return qnaMapper.getListDetail(qnaVO);
	}
}
