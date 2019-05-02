package com.bgkim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bgkim.domain.business.BusinessParam;
import com.bgkim.domain.business.BusinessVO;
import com.bgkim.mapper.BusinessMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j

public class BusinessServiceImpl implements BusinessService{
	
	@Setter(onMethod_ = @Autowired)
	private BusinessMapper mapper;

	
	@Override
	public int getTotal(BusinessParam param) {
		return mapper.totalSelect(param);
	}
	
	@Override
	public List<BusinessVO> getList(BusinessParam param) {
		
		log.info("#####################bussiness @Service");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		log.info(authentication);
		log.info("#####################bussiness @Service");
		return mapper.listSelect(param);
	}

	@Override
	@Transactional
	public int setWritePro(BusinessVO vo) {
		return mapper.writeProInsert(vo);
	}

	@Override
	public BusinessVO getUpdateForm(long bno) {
		return mapper.updateFormSelect(bno);
	}

	@Override
	public int setUpdatePro(BusinessVO vo) {
		return mapper.updateProUpdate(vo);
	}

	@Override
	public int deletePro(long bno) {
		return mapper.deleteProDelete(bno);
	}


}
