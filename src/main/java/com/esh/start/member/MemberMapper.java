package com.esh.start.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public MemberVO getLogin(String username) throws Exception;
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception;
	
	public int setAdd(MemberVO memberVO)throws Exception;
	
	public int setMemberRole(MemberVO memberVO)throws Exception;
	
}
