package org.control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private ISaysCommentsService saysCommentsServiceImpl;
	@RequestMapping("/toComments")
	public String toComments(SaysComments cs,Model model,Page<SaysComments> page){
		page=this.saysCommentsServiceImpl.findComments((String)cs.getCommentid(), page,"0");
		model.addAttribute("page", page);
		return "pinlun/pinlun";
	}
	
	@RequestMapping("/toAddComments")
	public @ResponseBody Map<String,Object> toAddComments(SaysComments cs,Model model){
		System.out.println(cs.getCommentcontent());
		System.out.println(cs.getUserid().getUserid());
		System.out.println(cs.getUseridare().getUserid());
		System.out.println(cs.getCommentsforid());
		cs.setCommentstatus("1");
		saysCommentsServiceImpl.addComments(cs);
		cs.setSaysreply(null);
		List<SaysComments> list=saysCommentsServiceImpl.FindCommentsNopage(cs.getCommentsforid(), cs.getUserid().getUserid(), cs.getUseridare().getUserid());	
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("pinlunlist", list);
		return map;
		
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(SaysComments cs,Model model){
		System.out.println(cs.getCommentid());
		
		saysCommentsServiceImpl.deleteComments(cs);
		return null;
	}
	
}
