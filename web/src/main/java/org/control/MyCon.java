package org.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MyCon {
	@RequestMapping("/my")
	public String my(){
		return "index";
	}
}
