package com.esh.start.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	

	
	@GetMapping("login")
	public void getLogin() throws Exception{
		
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		
		
		memberVO = memberService.getLogin(memberVO);
		
		if(memberVO != null) {

			session.setAttribute("check", memberVO);
			mv.setViewName("redirect:../");
		} else {
			mv.setViewName("./login");
		}
		
		return mv;
	}
	
	@GetMapping("join")
	public void setAdd(@ModelAttribute MemberVO memberVO)throws Exception{
		//MemberVO memberVO = new MemberVO();
		//model.addAttribute(memberVO);
	}
	
	@PostMapping("join")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{
		
//		if(bindingResult.hasErrors()) {
//			//검증에 실패하면 회원가입하는 jsp로 foward
//			log.info("===== 검증 에러 발생 =====");
//			mv.setViewName("member/add");
//			return mv;
//		}
		boolean check = memberService.getMemberError(memberVO,bindingResult);
		if(check) {
			log.info("===== 검증 에러 발생 =====");
			mv.setViewName("member/add");
		}
		
		//int result = memberService.setAdd(memberVO); 
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		System.out.println("로그아웃");
		//session 소멸
		session.invalidate();
		
		return "redirect:../";
	}
	
//	@GetMapping("idCheck")
//	@ResponseBody
//	public int getIdCheck(MemberVO memberVO) throws Exception{
//		return memberService.getIdCheck(memberVO);
//	}
//	
//	@PostMapping("test")
//	@ResponseBody
//	public MemberVO setTest(MemberVO memberVO, String[] ar) throws Exception{
//		log.info("=================]");
//		log.info("ID: {}", memberVO.getId());
//		log.info("name :{}",memberVO.getName());
//		log.info("ar :{}",ar);
//		
////		int result =memberService.getIdCheck(memberVO);
////		if (result ==0) {
////			
////			throw new Exception("뾰로롱");
////		}
////		return result;
//		
//		for(String s:ar) {
//			log.info("ar: {}",s);
//		}
//		
//		return memberVO;
//	}
	
}
