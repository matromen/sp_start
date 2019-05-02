package com.bgkim.service;

import java.util.List;


import com.bgkim.domain.business.BusinessParam;
import com.bgkim.domain.business.BusinessVO;

public interface BusinessService {
	public int getTotal(BusinessParam param);
	
	public List<BusinessVO> getList(BusinessParam param);
	
	public int setWritePro(BusinessVO vo);
	
	public BusinessVO getUpdateForm(long bno);
	
	public int setUpdatePro(BusinessVO vo);
	
	public int deletePro(long bno);
}
