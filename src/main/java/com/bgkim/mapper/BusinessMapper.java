package com.bgkim.mapper;

import java.util.List;

import com.bgkim.domain.business.BusinessParam;
import com.bgkim.domain.business.BusinessVO;

public interface BusinessMapper {
	public int totalSelect(BusinessParam param);
	
	public List<BusinessVO> listSelect(BusinessParam param);
	
	public int writeProInsert(BusinessVO vo);
	
	public BusinessVO updateFormSelect(long bno);
	
	public int updateProUpdate(BusinessVO vo);
	
	public int deleteProDelete(long bno);
}
