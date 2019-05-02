package com.bgkim.domain.business;

import java.util.Date;

import lombok.Data;

@Data
public class BusinessVO {
	private long bno;
	private String title;
	private String content;
	private String register;
	private Date regdate;
	private Date updatedate;
}
