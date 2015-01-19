package org.control;

import java.util.List;

import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ISaysFriendsService;
import org.service.ISaysMsgcenterService;
import org.service.ISaysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vo.Page;

@Controller
@RequestMapping("/finduser")
public class friendssqliyouControl {
	
	@Autowired
	private ISaysFriendsService saysfriendsservice;
	@Autowired
	private ISaysUserService saysUserServiceImpl ;
	

	
	@RequestMapping("/tosqfriends")
	public String tomyfriends(String userid,Model model){
		System.out.println(userid);
		model.addAttribute("bsquser",saysUserServiceImpl.selectSaysuserbyid(userid).get(0));
		return "user/sqliyou";
	}
	
	
	//搜索用户
	@RequestMapping(value="/findfriend")
	public String findfriend(String username,String userid,Page<SaysUser> page,Model model)
	{
		System.out.println(username+"用户名");
	
		
		Page<SaysUser> p= new Page<SaysUser>();
    	p.setPageNo(1);
    	p.setPageSize(7);

		page= saysUserServiceImpl.mhcxSaysUserinfo(username, p);
		System.out.println("xy"+page.getResult());
		model.addAttribute("page",page);
		
		
		
		Page<SaysFriends> p2= new Page<SaysFriends>();
    	p2.setPageNo(1);
    	p2.setPageSize(7);
    	
    	System.out.println("userid2"+userid);
		Page<SaysFriends> page2 =saysfriendsservice.findbyuseridallFriends(userid, p2);
		model.addAttribute("page2", page2);
		System.out.println("page2222"+page2.getDataSum());
		
		
		
		
		
		return "user/findfriends";
	}
	
	
	
}
