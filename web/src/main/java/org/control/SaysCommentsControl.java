package org.control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.entity.SaysComments;
import org.service.ISaysCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Comments")
public class SaysCommentsControl {
	@Autowired
	private ISaysCommentsService saysCommentsServiceImpl;
	@RequestMapping("/toComments")
	public String toComments(Model model){
		return "pinlun/pinlun";
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/toAddComments")
	public @ResponseBody void toAddComments(SaysComments cs,Model model){
		System.out.println(cs.getCommentcontent());
		System.out.println(cs.getUserid().getUserid());
		System.out.println(cs.getUseridare().getUserid());
		System.out.println(cs.getCommentsforid());
		cs.setCommentstatus("1");
		saysCommentsServiceImpl.addComments(cs);
		List<SaysComments> list=saysCommentsServiceImpl.FindCommentsNopage(cs.getCommentsforid(), cs.getUserid().getUserid(), cs.getUseridare().getUserid());
		System.out.println(list.size());
		
	}
}
