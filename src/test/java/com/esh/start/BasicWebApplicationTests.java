package com.esh.start;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esh.start.board.qna.QnaMapper;
import com.esh.start.board.qna.QnaVO;

@SpringBootTest
class BasicWebApplicationTests {

	@Autowired
	private QnaMapper qnaMapper;
	
	//@Test
	void test2() throws Exception {

		QnaVO qnaVO = new QnaVO();
		int result = 0;
		for(int i =0; i<100;i++) {
			qnaVO.setTitle("Title"+i);
			qnaVO.setContents("Contents" + i);
			qnaVO.setWriter("Admin");
			
			result = qnaMapper.setQnaList(qnaVO);
				
		}
		
		assertNotEquals(0, result);
		
	}

}
