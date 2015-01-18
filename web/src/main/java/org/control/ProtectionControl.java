package org.control;

import java.io.Serializable;
import java.util.List;















import javax.servlet.http.HttpSession;

import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.service.ISaysProtectionService;
import org.service.ISaysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/protection")
public class ProtectionControl {
	
	@Autowired
	private ISaysProtectionService saysprotectionImpl ;
	
	@Autowired
	private ISaysUserService saysUserServiceImpl ;
	
	@RequestMapping("/toprotection")
	public String toprotection(){
		
		return "protectionAdd";
	}
	
	@RequestMapping("/toprotectionupdate")
	public String toprotectionupdate(){
		
		return "protectionupdate";
	}
	
	@RequestMapping("/touserinfo")
	public String touserinfo(){
		
		return "userinfo";
	}
	
	//添加密保
	@RequestMapping(value="/protectionadd")
	public String protectionadd(SaysProtection Protection,Model model){
		
		System.out.println(Protection);
		String msg="添加成功！无法再次添加！";
		 Serializable sp = saysprotectionImpl.addnewSaysProtection(Protection);
		System.out.println(sp+"sp");
		if((boolean) (sp=false)){
			model.addAttribute("msg", msg);
			return "userinfo";
		}else{
			msg="您已添加密保,无法再次添加！";
			model.addAttribute("msg", msg);
			return "userinfo";
		}
	}

	
	//验证密保答案是否正确
		@RequestMapping("/yanzhen")
		public String yanzhen(SaysProtection saysprotection, Model model){
			
			System.out.println("验证");
			System.out.println(saysprotection.getProtectionid());
			System.out.println(saysprotection.getUserid().getUserid()+"用户id");
			System.out.println(saysprotection+"密保");
			
			@SuppressWarnings("unchecked")
			List<SaysUser> uinfo=saysUserServiceImpl.selectSaysuserbyid(saysprotection.getUserid().getUserid());
			model.addAttribute("uinfo", uinfo);
			System.out.println(uinfo+"用户信息");
			
			boolean sp=saysprotectionImpl.yanzhenSaysProtection(saysprotection);
			System.out.println(sp+"mib");
			System.out.println(uinfo+"用户信息");
			if(sp==false)
			{
				return "login";
			}else{
				return "userUpdatepwd";
			}
		}
		
		
		//问题回答正确后，修改密码
		@RequestMapping(value="/updatepwd2")
		public String updatepwd2(SaysUser user){

			System.out.println(user.getUserid());
			System.out.println(user.getUsername()+"重置密码");
			System.out.println(user);
			
			saysUserServiceImpl.updateSaysUserinfo(user);
			return "login";
		}
	
		
		//根据用户id查询出密保问题
		@RequestMapping(value="/findidprotection")
		public  String findidprotection(SaysProtection saysprotection,Model model){
			System.out.println(saysprotection.getUserid().getUserid());	
			List<SaysProtection> pulist=saysprotectionImpl.findSaysProtectionbyid(saysprotection.getUserid().getUserid());
			System.out.println(pulist.toString());
			model.addAttribute("pulist", pulist);
			return "protectionupdate";
		}
		//修改密保问题
		@RequestMapping(value="/protectionupdate")
		public  String protectionupdate(SaysProtection saysprotection,Model model){
			
			System.out.println(saysprotection.toString());
			boolean up = saysprotectionImpl.updateSaysProtections(saysprotection);
			System.out.println(up);
			return "userinfo";
		}
		
		
		
}
