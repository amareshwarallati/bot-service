package com.wow.botservice.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticWeb {
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
}
