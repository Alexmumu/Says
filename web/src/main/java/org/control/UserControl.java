package org.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.entity.SaysUser;
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
	private SaysUserServiceImpl suService ;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		
		return "login";
	}
	@ResponseBody
	@RequestMapping("/login")
	public String login(SaysUser user,HttpSession session,@RequestBody String requestbody){
		String msg="shibai";
		System.out.println(requestbody);
		List userlist=suService.loginuser(user.getUserarea(),user.getUserpassword());
		if(userlist.size()==0){
			session.setAttribute("myuser",userlist.get(0));
			msg="chenggong";
		}
		return msg;
	}
	
}
