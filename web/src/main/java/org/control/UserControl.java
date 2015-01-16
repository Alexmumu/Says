package org.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.entity.SaysUser;
import org.service.ISaysUserService;
import org.service.impl.SaysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserControl {
	
	@Autowired
	private ISaysUserService saysUserServiceImpl ;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		
		return "login";
	}
	
	@RequestMapping(value="/login")
	public @ResponseBody String login(
			SaysUser user){
		System.out.println(user.getUsername());
		String msg="shibai";
		try{
			List userlist=saysUserServiceImpl.loginuser(user.getUsername(),user.getUserpassword());
			msg="chenggong";

		}catch(RuntimeException e){
			//e.printStackTrace();
			msg="shibai";
		}
	
		return msg;
	}
	@RequestMapping("test")
	public @ResponseBody List test(){
		return this.saysUserServiceImpl.selectbyname("黄英鹏");
		
	}
	
	
	
}
