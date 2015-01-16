package org.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.service.ISaysMsgcenterService;
import org.service.ISaysUserService;
import org.service.impl.SaysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myuser")
@RequestMapping("/user")
public class UserControl {

	@Autowired
	private ISaysUserService saysUserServiceImpl;
	@Autowired
	private ISaysMsgcenterService saysMesscenterServiceImpl; 
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		
		return "login";
	}
	
	//验证登录
	@RequestMapping(value="/login")
	public @ResponseBody Map<String,Object> login(
			SaysUser user,Model model){
		System.out.println(user.getUsername());	
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			List userlist=saysUserServiceImpl.loginuser(user.getUsername(),user.getUserpassword());
			if(userlist.size()<=0||userlist==null){
				map.put("msg", "shibai");
			}else{
				model.addAttribute("myuser", userlist.get(0));
				map.put("msg","chenggong");
			}
		
		}catch(RuntimeException e){
			map.put("msg","shibai");
		}
		System.out.println(map);
		return map;
	}
	
	/**
	 * 获取用户的未读消息数目
	 * @param session
	 * @return
	 */
	@RequestMapping("/countByMsgnum")
	public @ResponseBody Map<String,Object> countByMsgnum(HttpSession session){
		SaysUser user=(SaysUser) session.getAttribute("myuser");
		int num=saysMesscenterServiceImpl.findNewMsg(user.getUserid());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("xxnum",num);
		return map;
	}
	
	@RequestMapping("/toTop")
	public  String toTop(Model model) {

		
		return "top";
	}


}
