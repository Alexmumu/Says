package org.control;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.entity.SaysAlbum;
import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysProtectionService;
import org.service.ISaysRizhitypeService;
import org.service.ISaysUserService;
import org.service.impl.SaysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ReaderContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.support.RequestContext;

@Controller
@RequestMapping("/user")
public class UserLoginControl {
	
	@Autowired
	private ISaysUserService saysUserServiceImpl;
	@Autowired
	private ISaysProtectionService saysprotectionImpl;
	
	
	//注册    注册成功后添加一个默认不可删除的相册和日志类型
	@RequestMapping(value="/useradd")
	public String useradd(SaysUser user,Model model)
	{
		user.getUsername();
		user.getUserpassword();
		user.setUsernickname("人类");
		user.setUsersex(0);
		user.setUserimg("touxiang1.jpg");
		user.setUsersig("帅哥或美女");
		user.setUserarea("地球");
    	
		System.out.println(user.getUsername()+user.getUserpassword());
		
		@SuppressWarnings("unchecked")
		List<SaysUser>  u=saysUserServiceImpl.selectbyname(user.getUsername());
		String msg="账号已存在！请重新注册！";
		if(u.size()!=0)
		{
			model.addAttribute("msg", msg);
			return "login";	
		}else 
		{
			 Serializable s = this.saysUserServiceImpl.addnewSaysuser(user);
		System.out.println(s);
			 List hh = saysUserServiceImpl.selectSaysuserbyid((String) s);
			System.out.println("hh"+hh);
			if(s!=null)
			{
//				SaysUser uu= new SaysUser();
//				uu.setUserid( (String) s);
//				System.out.println("id"+uu);
				model.addAttribute("hh", hh);
				return "userinfo";	
			}
		}
		return "login";
	}
	
	
	//添加完成后跳到完善信息页面，并修改用户信息
	@RequestMapping(value="/userupdate")
	public String userupdate(SaysUser user,Model model)
	{
		System.out.println(user.toString()+"信息");
		saysUserServiceImpl.updateSaysUserinfo(user);
		return "成功";
	}
	
	
	
	
	//根据用户id查询用户个人信息和密保到修改页面
	@RequestMapping(value="/finduser")
	public String finduser(String userid,Model model)
	{
		List<SaysUser> uinfo=saysUserServiceImpl.selectSaysuserbyid(userid);
		model.addAttribute("uinfo", uinfo);
		System.out.println(uinfo+"用户信息");
		
		List<SaysProtection> uplist=saysprotectionImpl.findSaysProtectionbyid(userid);
		System.out.println(uplist.toString());
		model.addAttribute("uplist", uplist);
		return "userinfoupdate";
	}
	//进行修改
	@RequestMapping(value="/finduserupdate")
	public String finduserupdate(SaysUser user,Model model)
	{
		System.out.println(user.toString()+"信息");
		saysUserServiceImpl.updateSaysUserinfo(user);
		return "userinfo";
	}
	
	
	
	
	
	
	
	
	
}
