package org.control;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.entity.SaysAlbum;
import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysFrequestService;
import org.service.ISaysFriendsService;
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
	
	@RequestMapping("/tomyfriends")
	public String tomyfriends(){
		
		return "findfriends";
	}
	
	@RequestMapping("/touserinfo")
	public String touserinfo(){
		
		return "myfriends";
	}
	
	//根据用户id，查询用户信息
	@RequestMapping(value="/finduserid")
	public String finduserid(String userid,Model model)
	{
		List<SaysUser> uid=saysUserServiceImpl.selectSaysuserbyid(userid);
		model.addAttribute("uid", uid);
		System.out.println(uid+"用户信息");
		return "findfriends";
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
	
		return "myfriends";
	}
	
	
	//删除用户指定的好友
	@RequestMapping(value="/deletedfriends")
	public String deletedfriends(String friendid,String userid)
	{
		System.out.println(friendid);
		saysfriendsservice.deletedFriends(friendid);

		return "myfriends";
	}
	
	
	
	//添加用户指定的好友申请
	@RequestMapping(value="/addfrequest")
	public String addfrequest(SaysFrequest saysfrequest)
	{

		System.out.println(saysfrequest.getFruser().getUserid());
		System.out.println(saysfrequest.getFruserare().getUserid());
		System.out.println(saysfrequest.getShenqiliyou());
	
		saysfrequest.setFrstatus(1);
		saysfrequestservice.addnewSaysFrequest(saysfrequest);
		
		System.out.println(saysfrequest.getFruser().getUserid());
		return "myfriends";
	}
	
	
	//根据好友id查询好友的信息
	@RequestMapping(value="/finduserfriendid")
	public String finduserfriendid(String userfriendid,Model model)
	{
		System.out.println(userfriendid);
		
		List<SaysUser> ufid=saysUserServiceImpl.selectSaysuserbyid(userfriendid);
		model.addAttribute("ufid", ufid);
		System.out.println(ufid+"好友信息");
		return "friendsinfo";
	}

	
	
	
}
