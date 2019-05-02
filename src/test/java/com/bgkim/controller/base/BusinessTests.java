package com.bgkim.controller.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class BusinessTests {
	@Test
	public void test() {
		int endPage = (int)(Math.ceil(12/10.0))*10;
		
		System.out.println(endPage);
	}
}
