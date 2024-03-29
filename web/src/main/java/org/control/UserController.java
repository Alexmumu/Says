package org.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.entity.SaysMsgcenter;
import org.entity.SaysNews;
import org.entity.SaysUser;
import org.entity.SaysVisit;
import org.service.ICommonService;
import org.service.ISaysAlbumService;
import org.service.ISaysLeavewordService;
import org.service.ISaysMsgcenterService;
import org.service.ISaysNewsService;
import org.service.ISaysRizhiService;
import org.service.ISaysUserService;
import org.service.ISaysVisitService;
import org.service.IsaysShouShouService;
import org.service.impl.SaysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.vo.Page;

@Controller
@SessionAttributes("myuser")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ISaysUserService saysUserServiceImpl;
	@Autowired
	private ISaysMsgcenterService saysMesscenterServiceImpl; 
	@Autowired
	private ICommonService commonServiceImpl;
	@Autowired
	private ISaysNewsService newsServiceImpl;
	@Autowired
	private ISaysVisitService visitService;
	
	
	/**
	 * 跳转登录
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		
		return "user/login";
	}
	
	/**
	 * 验证登录
	 * @param user
	 * @param model
	 * @return
	 */
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
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		Map<String,Object> map=new HashMap<String, Object>();
		if(myuser!=null){
		int num=saysMesscenterServiceImpl.findNewMsg(myuser.getUserid());
		map.put("xxnum",num);
		}else{
		map.put("xxnum", 0);
		}return map;
	}
	
	@RequestMapping("/toTop")
	public  String toTop(Model model) {

		
		return "top";
	}
	
	/**
	 * 去传入的用户id的领土页面  并增加访问记录
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping("myhome")
	public String toUserMyHome(Model model ,SaysUser user,HttpSession session){
		Map<String,Object> map=this.commonServiceImpl.findMyCountByUserid(user.getUserid());
		user=(SaysUser) this.saysUserServiceImpl.selectSaysuserbyid(user.getUserid()).get(0);
		//访问者肯定是session用户
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		//如果访问者和被访问者不是同一个人 那么就要增加一条访问记录
		if(!myuser.getUserid().equals(user.getUserid())){
			SaysVisit sv=new SaysVisit();
			sv.setUserid(user);
			sv.setFromuserid(myuser);
			this.visitService.addSaysVisit(sv);
		}
		
		model.addAttribute("usercount", map);
		model.addAttribute("zyuser",user);
		return "wodelingtu";
	}
	@RequestMapping("zhuyedongtai")
	public String tozhuyedongtai(SaysUser user,Model model){
		user=(SaysUser) this.saysUserServiceImpl.selectSaysuserbyid(user.getUserid()).get(0);
		model.addAttribute("zhuyeuser",user);
		Page<SaysNews> page =new Page<SaysNews>();
		page.setPageNo(1);
		model.addAttribute("zongyeshu",newsServiceImpl.findMyNewsByUser(user.getUserid(),page ).getPageSum());
		return "zhuyedongtai";
	}
	
	@RequestMapping("toManger")
	public String toManger(Model model,int type){
		model.addAttribute("type",type);
		return "manager";
	}
	
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.removeAttribute("myuser");
		return "user/login";
	}





}
