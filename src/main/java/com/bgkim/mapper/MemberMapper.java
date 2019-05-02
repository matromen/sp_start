package com.bgkim.mapper;

import com.bgkim.domain.security.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
}
