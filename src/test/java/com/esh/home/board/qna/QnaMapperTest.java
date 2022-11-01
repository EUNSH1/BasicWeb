package com.esh.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.esh.start.board.qna.QnaMapper;
import com.esh.start.board.qna.QnaVO;

// 상속 안 받고 추가만 하면 됨

@SpringBootTest(classes = QnaMapperTest.class)
class QnaMapperTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
