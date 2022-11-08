package com.esh.start;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/user")
	   public String member() {
		   return "Member Role";
	   }
	   
	   @GetMapping("/admin")
	   public String admin() {
		   return "Admin Role";
	   }
	   
	   @GetMapping("/manager")
	   public String manager() {
		   return "Manager Role";
	   }
	   
	   @GetMapping("/")
	   public ModelAndView home(Model model,HttpSession session) throws Exception {
	      log.info("==========================");
	      Enumeration<String> er =session.getAttributeNames();
	      
	      while(er.hasMoreElements()) {
	    	  log.info("er -> {} ",er.nextElement());
	      }
		
	      ModelAndView mv = new ModelAndView();
	      //System.out.println("Message : " + message);
//	      List<QnaVO> ar = qnaMapper.getList();
	      
//	       log.info("List : {}  size {}", ar, ar.size());
//	      mv.addObject("list", ar);
	     
	      mv.setViewName("index");
	      
	      
	      
	      return mv;
	}
}
