package org.control;

import java.util.List;

import org.entity.SaysLeaveword;
import org.entity.SaysUser;
import org.service.ISaysLeavewordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vo.Page;

@Controller
@RequestMapping("/user")
public class SaysLeavewordControl {
	@Autowired
	private ISaysLeavewordService saysLeavewordServiceImpl;
	
	
	@RequestMapping("/toLeaveword")
	public String toLeaveword(Model model){
		SaysLeaveword alw=new SaysLeaveword();
		Page<SaysLeaveword> page=new Page<SaysLeaveword>();
    	page.setPageNo(0);
    	page.setPageSize(2);
		Page<SaysLeaveword> page1=saysLeavewordServiceImpl.findAllSaysLeaveword(page, alw);
		model.addAttribute("page1", page1);
		return null;
	}
	
	@RequestMapping("/toLeavword")
	public String toLeavword(Model model){
		SaysLeaveword alw=new SaysLeaveword();
		SaysUser sus=new SaysUser();
		sus.setUserid("U001");
		alw.setUserid(sus);
		alw.setLevewodidstatus(1);
		Page<SaysLeaveword> page=new Page<SaysLeaveword>();
    	page.setPageNo(1);
    	page.setPageSize(2);
		Page<SaysLeaveword> page1=saysLeavewordServiceImpl.findAllSaysLeaveword(page, alw);
		model.addAttribute("page1", page1);
		System.out.println(page1.getResult().size());
		return "liuyanban";
	}
	
	
}
