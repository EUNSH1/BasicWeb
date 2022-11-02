package com.esh.start.file;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.esh.start.board.qna.QnaFileVO;
import com.esh.start.board.qna.QnaService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	@Autowired
	private QnaService qnaService;
	
	
	@GetMapping("/fileDown/{path}") // RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable String path,QnaFileVO qnaFileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		//DB에서 정보 조회
		log.info("Path {}",path);
		
		// 경로에 맞는 service 사용 (db)
		if(path.equals("qna")) {
			
			qnaFileVO = qnaService.getFileCheck(qnaFileVO);
			
		} else if (path.equals("notice")) {
			
		}
				
		
		log.info("FileVO {}", qnaFileVO);
		
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		
		return mv;
	}
	
//	@GetMapping("/fileDown/notice")
//	public ModelAndView noticeFileDown(QnaFileVO qnaFileVO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		//DB에서 정보 조회
//		qnaFileVO.setFileName("title6.jpg");
//		qnaFileVO.setOriName("title6.jpg");
//		
//		mv.addObject("fileVO", qnaFileVO);
//		mv.addObject("path", "notice");
//		
//		mv.setViewName("fileManager");
//		
//		return mv;
//	}
}
