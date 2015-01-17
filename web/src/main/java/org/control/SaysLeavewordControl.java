package org.control;

import java.util.List;

import org.entity.SaysLeaveword;
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

	@RequestMapping("/toLeavwordneirong")
	public String toLeavwordNeiRong(Page<SaysLeaveword> page,SaysLeaveword sysleaveword,Model model){
		page.setPageSize(4);
		sysleaveword.setLevewodidstatus(1);
		Page page1=this.saysLeavewordServiceImpl.findAllSaysLeaveword(page, sysleaveword);
		
		model.addAttribute("page1", page1);
		
		return "liuyanban/liuyanbanneirong";
	}
	
	@RequestMapping("/toLeavword")
	public String toLeavword(Model model,SaysUser user){
		System.out.println(user  +"user");
		SaysUserword  userword= saysUserwordServiceImpl.findSaysUserwordByUserId(user.getUserid());
		int dataSum =saysLeavewordServiceImpl.countAllSaysLeaveword(user.getUserid(), 1);
		Page<Object> page=new Page<Object>();
		page.setPageSize(4);
		page.setDataSum(dataSum);
		model.addAttribute("userword", userword);
		model.addAttribute("pageSum", page.getPageSum());
		return "liuyanban/liuyanban";
	}
	
	@RequestMapping("/updateUserWord")
	public String updateUserWord(SaysUserword saysUserword){
		System.out.println(saysUserword.getUserid().getUserid());
		System.out.println(saysUserword.getUserwordcontent());
		System.out.println(saysUserword.getUserwordid());
		saysUserwordServiceImpl.updateSaysUserword(saysUserword);
		return "redirect:/Leavword/toLeavword?userid=U001";
	}
	
	@RequestMapping("/deleteUserWord")
	public String deleteUserWord(SaysLeaveword saysLeaveword){
		System.out.println(saysLeaveword.getLeavewordid());
		saysLeavewordServiceImpl.deleteSaysLeaveword(saysLeaveword.getLeavewordid());
		return "redirect:/Leavword/toLeavwordneirong?userid.userid=U001&pageNo=1";
	}
	
	@RequestMapping("/addUserWord")
	public String addUserWord(SaysLeaveword saysLeaveword){
		System.out.println(saysLeaveword.getLeavewordcontent());
		saysLeaveword.setLevewodidstatus(1);
		saysLeavewordServiceImpl.saveSaysLeaveword(saysLeaveword);
		return "redirect:/Leavword/toLeavwordneirong?userid.userid=U001&pageNo=1";
	}
}
