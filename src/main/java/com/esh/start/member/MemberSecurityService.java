package com.esh.start.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
@Service
@Slf4j
public class MemberSecurityService implements UserDetailsService {

   @Autowired
   private MemberMapper memberMapper;
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //레퍼런스 타입
      log.info("============로그인 시도 중============");
      MemberVO memberVO = new MemberVO();
		try {
			memberVO = memberMapper.getLogin(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      log.info("MemberVO: {}", memberVO);
      return memberVO;
   }
   
   

}



