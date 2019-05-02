package com.bgkim.domain.business;

import com.bgkim.domain.base.Param;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author bgkim
 *
 * 게시판 기본 파라미터
 */

@Getter
@Setter

public class BusinessParam extends Param{

	public BusinessParam() {
		super(1, 10);
	}
	
}
