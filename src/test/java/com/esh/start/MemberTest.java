package com.esh.start;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.esh.start.member.MemberMapper;
import com.esh.start.member.MemberVO;

@SpringBootTest(classes = MemberTest.class)
class MemberTest {
   
   @Autowired
   private MemberMapper memberMapper;
   
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Test
   void test() throws Exception {
      MemberVO memberVO = new MemberVO();
      memberVO.setId("admin1");
      //passwordEncoder.encode("admin1"); -> admin1이라는 비번을 인코딩 시키겠다.(암호화)
      memberVO.setPw(passwordEncoder.encode("admin1"));
      memberVO.setEmail("admin1@gmail.com");
      memberVO.setName("admin1");
      
      int result = memberMapper.setAdd(memberVO);
      assertEquals(1, result);
   }
}
