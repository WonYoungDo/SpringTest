package com.tawny.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03 {
	
	@RequestMapping("lifecycle/test03")
	public String jsp() {
		return "lifecycle/test03";
	}
}
