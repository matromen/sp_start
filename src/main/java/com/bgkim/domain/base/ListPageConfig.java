package com.bgkim.domain.base;

import lombok.Getter;

@Getter

public class ListPageConfig {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private Param param;
	private int total;
	
	
	// criteria 파라미터 : searchType, searchValue, page레코드 수, 현재page 번호
	// total 검색된 레코드 수
	// page 네비게이션을 만듬
	public ListPageConfig(Param param, int total) {
		this.param = param;
		this.total = total;
		
		// startPage는 현재 기준 시작 번호를 생성 ex) 1 or 11 or 21 ..
		// endPage는 현재 기준 마지막 페이지 번호 대략적인 ex) 10 or 20 or 30....
		// realEndPage 전체 마지막 페이지 번호
		
		this.endPage = (int)(Math.ceil(param.getPageNum()/10.0))*10; //올림하여 계산, 현재페이지 기준 대략적인 마지막 페이지 계산. 현재페이지가 1~10->10, 11~20 -> 20 ....
		this.startPage = this.endPage - 9;
		
		int realEndPage = (int)Math.ceil((this.total*1.0)/param.getPageAmount()); //올림하여 계산, 검색결과 카운터를 파라미터 page레코드수로 나누어 실제 마지막 페이지를 구함.
		
		if(realEndPage < this.endPage) { //pageConfig object의 endPage 값(실제 화면에 뿌릴 마지막 page값). 실제 마지막 페이지와 현재기준 마지막 페이지가 같은경우 빼고는 실제 마지막 페이지가 endPage가 된다.
			this.endPage = realEndPage;
		}
		
		this.prev = this.startPage > 10;
		this.next = this.endPage < realEndPage;
	}
}
