package com.bgkim.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bgkim.domain.base.ListPageConfig;
import com.bgkim.domain.business.BusinessParam;
import com.bgkim.domain.business.BusinessVO;
import com.bgkim.service.BusinessService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j

@RequestMapping("/business")
@PreAuthorize("isAuthenticated()")
public class BusinessController {
	
	@Setter(onMethod_ = @Autowired)
	private BusinessService businessService;
	
	
	@GetMapping("/businessList")
	public void getList(BusinessParam param, Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("////////////////////////////////");
		log.info("param : " + param);
		
		model.addAttribute("list", businessService.getList(param));
		model.addAttribute("listPageConfig", new ListPageConfig(param, businessService.getTotal(param)));
	}
	
	@GetMapping("/businessWriteForm")
	public void getWriteForm(@ModelAttribute("param") BusinessParam param, Model model) {
		//model.addAttribute("param", param); 생략가능
	}
	
	@PostMapping("/businessWritePro")
	public String setWritePro(BusinessVO vo,  RedirectAttributes rttr) {
		
		businessService.setWritePro(vo);
		
		rttr.addFlashAttribute("flag", vo.getBno());
				
		return "redirect:/business/businessList";
	}
	
	@GetMapping("/businessUpdateForm")
	public void getUpdateForm(@ModelAttribute("param") BusinessParam param, @RequestParam("bno") long bno, Model model) {
		//model.addAttribute("param", param); 생략가능
		model.addAttribute("vo", businessService.getUpdateForm(bno));
	}
	
	@PostMapping("/businessUpdatePro")
	public String setUpdatePro(BusinessParam param, BusinessVO vo, RedirectAttributes rttr) {
		
		businessService.setUpdatePro(vo);
		
		rttr.addFlashAttribute("flag", "success");
		
		return "redirect:/business/businessUpdateForm" + param.getParamLink();
	}
	
	@PostMapping("/businessDelete")
	public String deletePro(BusinessParam param, @RequestParam("bno") long bno) {
		businessService.deletePro(bno);
		
		return "redirect:/business/businessList" + param.getParamLink();
	}
}
