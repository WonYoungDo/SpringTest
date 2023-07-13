package com.tawny.spring.test.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSTLCoreController {
	
	@GetMapping("jstl/test01")
	public String jstlCore() {
		return "jstl/test01";
	}
}
