package org.control;

import java.util.List;

import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.service.ISaysProtectionService;
import org.service.ISaysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userzh")
public class UserzhanghaoControl {
	
	@Autowired
	private ISaysUserService saysUserServiceImpl ;
	
	@Autowired
	private ISaysProtectionService saysProtectionServiceImpl ;

	
	@RequestMapping("/touserzhanghao")
	public String touserzhanghao(){
		
		return "userzhanghao";
	}
	
	
	//根据输入的账号查找用户的信息和密保问题
	@RequestMapping(value="/findbyusername")
	public  String findbyusername(SaysUser user,Model model){
		System.out.println(user.getUsername());
		String msg="账号不存在！请重新输入！";
		try{
			@SuppressWarnings("unchecked")
			List<SaysUser> userinfo=saysUserServiceImpl.selectbyname(user.getUsername());
			System.out.println(userinfo.toString());
			model.addAttribute("user", userinfo);
			if(userinfo.size()==0||userinfo==null){
				model.addAttribute("msg", msg);
				return "userzhanghao";
			}else{
				System.out.println("执行了问题方法");
				List<SaysProtection> plist=saysProtectionServiceImpl.findSaysProtectionbyid(userinfo.get(0).getUserid());
				System.out.println(userinfo.get(0).getUserid());
				System.out.println(plist.get(0).getProtectionid());
				if(plist.size()!=0){
					model.addAttribute("plist", plist);
					return "userHuidawenti";
				}
			}
		}catch(RuntimeException e){
			//e.printStackTrace();
			msg="您目前没有设置密保！";
			model.addAttribute("msg", msg);
			return "userHuidawenti";
		}
		return msg;
	}
	
	
	//重置密码
	@RequestMapping(value="/updatepwd")
	public String updatepwd(SaysUser user){

		user.setUserpassword("123456");
		user.getUsername();
		user.getUsernickname();
		user.getUsersex();
		user.getUserimg();
		user.getUsersig();
		user.getUserbirthday();
		user.getUserregisterday();
		user.getUserarea();
		
		System.out.println(user.getUsername());
		System.out.println(user.getUsername()+"重置密码为：123456");
		System.out.println(user);
		
		saysUserServiceImpl.updateSaysUserinfo(user);
		return "login";
	}
	
	
	
	
}
