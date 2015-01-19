package org.control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dao.ISaysCommentsDao;
import org.entity.SaysComments;
import org.entity.SaysUser;
import org.service.ISaysCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.Page;

@Controller
@RequestMapping("/Comments")
public class SaysCommentsControl {
	@Autowired
	private ISaysCommentsDao saysCommentsDaoImpl;
	@Autowired
	private ISaysCommentsService saysCommentsServiceImpl;
	@RequestMapping("/toComments")
	public String toComments(SaysComments cs,Model model,Page<SaysComments> page){
		
			System.out.println(page.getPageNo());
			page.setPageSize(4);
			Page page1=saysCommentsServiceImpl.findComments(cs.getCommentsforid(), page, "1");
			model.addAttribute("page1", page1);
		
		return "pinlun/pinlunneirong";
	}

	@RequestMapping("/toCommentsaa")
	public String toCommentsaa(SaysComments cs,Model model,Page<SaysComments> page){
		
		int i=saysCommentsDaoImpl.CountComments(cs.getCommentsforid(),"1");
		System.out.println("iiiiii"+i);
		page.setPageSize(4);
		page.setDataSum(i);
		System.out.println("aassdfff"+page.getPageSum());
		model.addAttribute("pageSum", page.getPageSum());
		model.addAttribute("Commentsforid",cs.getCommentsforid());
		model.addAttribute("Userid",cs.getUserid().getUserid());
		return "pinlun/pinlun";
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(SaysComments cs,Model model){
		System.out.println("dddddddddddssssssssssss"+cs.getCommentid());
		SaysComments cs2=saysCommentsDaoImpl.getById(cs.getCommentid());
		cs2.setCommentstatus("0");
		saysCommentsDaoImpl.update(cs2);
		
		System.out.println(cs2.getCommentcontent());
		return "redirect:/Comments/toCommentsaa";
	}
	@RequestMapping("/addComments")
	public String addComments(SaysComments cs,Model model){
		System.out.println("99999666666666"+cs.getUserid().getUserid());
		System.out.println("sssssaaaa"+cs.getUseridare().getUserid());
		System.out.println("fsdsad"+cs.getCommentsforid());
		System.out.println("fsdsssaaaad"+cs.getCommentcontent());
		cs.setCommentstatus("1");
		
		saysCommentsDaoImpl.save(cs);
		return "redirect:/Comments/toCommentsaa?commentsforid="+cs.getCommentsforid()+"&userid.userid="+cs.getUseridare().getUserid();
	}
	
}
