package com.bgkim.domain.base;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Param {
	private String searchType; //검색 분류
	private String searchValue; //검색 값
	
	private int pageNum; //현재 page번호
	private int pageAmount; //현재 page당 레코드 수
	
	
//	public Param() { //게시판 초기 파라미터 
//		this(1, 10);
//	}
	
	public Param(int pageNum, int pageAmount) {
		this.pageNum = pageNum;
		this.pageAmount = pageAmount;
	}
	
	public String[] getSearchTypeArr() {
		return searchType==null ? new String[] {} : searchType.split("");
	}
	
	public String getParamLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		builder.queryParam("pageNum", this.getPageNum());
		builder.queryParam("amount", this.getPageAmount());
		builder.queryParam("type", this.getSearchType());
		builder.queryParam("keyword", this.getSearchValue());
		
		return builder.toUriString();
	}	
}
