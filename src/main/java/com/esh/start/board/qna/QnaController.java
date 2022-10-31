package com.esh.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esh.start.board.qna.QnaVO;
import com.esh.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public ModelAndView getList(QnaVO qnaVO,Pager pager) throws Exception{
		  ModelAndView mv = new ModelAndView();
		 
		  pager.setPerPage(10L);
		  List<QnaVO> ar =  qnaService.getList(pager);		  
		  mv.addObject("list", ar);
		  mv.setViewName("/qna/list");
		  
		  return mv;
	}
	
	@GetMapping("add")
	  public void setAddBoard() throws Exception{
		  
		  System.out.println("list add get");
	  }
	  
	  @PostMapping("add")
	  public String setAddBoard(QnaVO qnaVO, RedirectAttributes redirectAttributes) throws Exception{
		  
		  int result = qnaService.setQnaList(qnaVO);
		  
		  redirectAttributes.addAttribute("result", result);		  
		  
		  return "redirect:./list";
	  }
	  
	  @GetMapping("detail")
	  public ModelAndView getListDetail(QnaVO qnaVO) throws Exception {
		  ModelAndView mv = new ModelAndView();
		  System.out.println(qnaVO.getNum());
		  qnaVO = qnaService.getListDetail(qnaVO);
		  
		  mv.addObject("qnaVO", qnaVO);
		  mv.setViewName("/qna/detail");
		  
		  return mv;
	  }
}
