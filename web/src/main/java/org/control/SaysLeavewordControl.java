package org.control;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dao.ISaysMsgcenterDao;
import org.entity.SaysLeaveword;
import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.entity.SaysUserword;
import org.service.ISaysLeavewordService;
import org.service.ISaysUserwordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vo.Page;

@Controller
@RequestMapping("/Leavword")
public class SaysLeavewordControl {
	
	
	

	@Autowired
	private ISaysLeavewordService saysLeavewordServiceImpl;
	@Autowired
	private ISaysUserwordService saysUserwordServiceImpl;
	@Autowired
	private ISaysMsgcenterDao SaysMsgcenterDaoImpl;
	
	@RequestMapping("/toLeavwordneirong")
	public String toLeavwordNeiRong(Page<SaysLeaveword> page,SaysLeaveword sysleaveword,Model model,HttpSession session){
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		page.setPageSize(4);
		sysleaveword.setLevewodidstatus(1);
		Page page1=this.saysLeavewordServiceImpl.findAllSaysLeaveword(page, sysleaveword);
		
		model.addAttribute("page1", page1);
		model.addAttribute("pageNom", page.getPageNo());
		System.out.println(sysleaveword.getUserid().getUserid()+"Woccccccccccccccc");
		model.addAttribute("fangwenUserid", sysleaveword.getUserid().getUserid());
			
		
		return "liuyanban/liuyanbanneirong";
	}
	
	@RequestMapping("/toLeavword")
	public String toLeavword(Model model,SaysUser user){
		SaysUser ss=new SaysUser();
	//	ss.setUserid("U002");
		System.out.println(user.getUserid()+"11111111");
		
		SaysUserword  userword= saysUserwordServiceImpl.findSaysUserwordByUserId(user.getUserid());
		int dataSum =saysLeavewordServiceImpl.countAllSaysLeaveword(user.getUserid(), 1);
		Page<Object> page=new Page<Object>();
		page.setPageSize(4);
		page.setDataSum(dataSum);
		model.addAttribute("userword", userword);
		model.addAttribute("pageSum", page.getPageSum());
		model.addAttribute("fangwenUserid",user.getUserid());
		return "liuyanban/liuyanban";
	}
	
	@RequestMapping("/updateUserWord")
	public String updateUserWord(SaysUserword saysUserword,HttpSession session){
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		
		System.out.println(saysUserword.getUserid().getUserid());
		System.out.println(saysUserword.getUserwordcontent());
		System.out.println(saysUserword.getUserwordid());
		saysUserwordServiceImpl.updateSaysUserword(saysUserword);
		return "redirect:/Leavword/toLeavword?userid="+myuser.getUserid();
	}
	
	@RequestMapping("/deleteUserWord")
	public String deleteUserWord(Model model,SaysLeaveword saysLeaveword,HttpSession session,Page<SaysLeaveword> page){
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		
		System.out.println(saysLeaveword.getLeavewordid());
		saysLeavewordServiceImpl.deleteSaysLeaveword(saysLeaveword.getLeavewordid());
		
		return "redirect:/Leavword/toLeavwordneirong?"+myuser.getUserid()+"&pageNo=1";
	}
	
	@RequestMapping("/addSaysLeaveword")
	public String addSaysLeaveword(SaysLeaveword saysLeaveword,HttpSession session){
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		
		System.out.println(saysLeaveword.getLeavewordcontent()+"jjjjj");
		System.out.println(saysLeaveword.getUserid().getUserid()+"wwwwww");
		System.out.println(saysLeaveword.getFromuserid().getUserid()+"wwwwww");
		System.out.println(saysLeaveword.getLeavewordcontent());
		saysLeaveword.setLevewodidstatus(1);
		Serializable lw =this.saysLeavewordServiceImpl.saveSaysLeaveword(saysLeaveword);
		SaysMsgcenter msg=new SaysMsgcenter();
		msg.setMcstatus(1);
		msg.setMcfromid((String)lw);
		msg.setMctype(11);
		SaysUser sus3=new SaysUser();
		sus3.setUserid(saysLeaveword.getUserid().getUserid());
		msg.setUserid(sus3);
		SaysMsgcenterDaoImpl.save(msg);
		return "redirect:/Leavword/toLeavwordneirong?userid.userid="+myuser.getUserid()+"&pageNo=1";
		
	}
}
