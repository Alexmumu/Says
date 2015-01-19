package org.control;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.entity.SaysAlbum;
import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysFrequestService;
import org.service.ISaysFriendsService;
import org.service.ISaysMsgcenterService;
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
import org.vo.Page;

@Controller
@RequestMapping("/friends")
public class friendsControl {
	
	@Autowired
	private ISaysFriendsService saysfriendsservice;
	@Autowired
	private ISaysUserService saysUserServiceImpl ;
	@Autowired
	private ISaysFrequestService saysfrequestservice;
	
	@Autowired
	private ISaysMsgcenterService saysmsgcenterserviceImpl;
	
	@RequestMapping("/tomyfriends")
	public String tomyfriends(){
		
		return "user/findfriends";
	}
	
	@RequestMapping("/touserinfo")
	public String touserinfo(){
		
		return "user/myfriends";
	}
	
	//根据用户id，查询用户信息
	@RequestMapping(value="/finduserid")
	public String finduserid(String userid,Model model)
	{
		List<SaysUser> uid=saysUserServiceImpl.selectSaysuserbyid(userid);
		model.addAttribute("uid", uid);
		System.out.println(uid+"用户信息");
		return "user/findfriends";
	}
	
	
	//查询出用户的所有好友
	@RequestMapping("findallfriends")
	public String findallfriends(String userid,Page<SaysFriends> page,Model model)
	{
		System.out.println(userid+"date");
		System.out.println(page+"page");
		
		Page<SaysFriends> p= new Page<SaysFriends>();
    	p.setPageNo(1);
    	p.setPageSize(5);
		
		page=this.saysfriendsservice.findbyuseridallFriends(userid, p);
		
		model.addAttribute("page", page);
	
		return "user/myfriends";
	}
	
	
	//删除用户指定的好友
	@RequestMapping(value="/deletedfriends")
	public String deletedfriends(String friendid,String userid,Model model)
	{
		String msg3="已删除该好友！";
		System.out.println(friendid);
		saysfriendsservice.deletedFriends(friendid);
		model.addAttribute("msg", msg3);
		return "user/myfriends";
	}
	
	
	
	//添加用户指定的好友申请
	@RequestMapping(value="/addfrequest")
	public String addfrequest(SaysFrequest saysfrequest, Model model, SaysMsgcenter msg1 )
	{

		System.out.println(saysfrequest.getFruser().getUserid());
		System.out.println(saysfrequest.getFruserare().getUserid());
		System.out.println(saysfrequest.getShenqiliyou());
	
		saysfrequest.setFrstatus(1);
		
		String msg2="申请已发出，请等待！";
		
		 Serializable a = saysfrequestservice.addnewSaysFrequest(saysfrequest);
		System.out.println("a"+a);
		if(a!=null)
		{
			model.addAttribute("msg", msg2);
		}else
		{
			model.addAttribute("msg", msg2);
		}
		
	 	   msg1.setMcfromid((String) a);
	 	   msg1.setMctype(1);
	 	   msg1.setMcstatus(1);
	 	   
	 	  System.out.println("消息源id"+msg1.getUserid().getUserid());
	 	  
	 	   if(a!=null)
	 	   {
	 		  saysmsgcenterserviceImpl.addMsg(msg1);
	 	   }
		System.out.println(saysfrequest.getFruser().getUserid());
		return "user/myfriends";
	}
	
	
	//根据好友id查询好友的信息
	@RequestMapping(value="/finduserfriendid")
	public String finduserfriendid(String userfriendid,Model model)
	{
		System.out.println(userfriendid);
		
		List<SaysUser> ufid=saysUserServiceImpl.selectSaysuserbyid(userfriendid);
		model.addAttribute("ufid", ufid);
		System.out.println(ufid+"好友信息");
		return "user/friendsinfo";
	}

	
	
	
}
