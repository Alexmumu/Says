package org.control;

import java.util.List;

import org.entity.SaysComments;
import org.entity.SaysReply;
import org.entity.SaysUser;
import org.service.ISaysReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Reply")
public class SaysReplyControl {
	@Autowired
	private ISaysReplyService saysReplyServiceImpl;
	@RequestMapping(value="/addReply")
	public String addReply(SaysReply sr,SaysComments cs,int type)
	{
		System.out.println(sr.getReplycontent());
		System.out.println(sr.getUseridare().getUserid());
		System.out.println(sr.getUserid().getUserid());
		System.out.println(sr.getCommentid().getCommentid());
		sr.setReplystatus(1);
		System.out.println(cs.getCommentsforid()+"xmid");
		saysReplyServiceImpl.addReply(sr);
		
		return "redirect:/Comments/toCommentsaa?commentsforid="+cs.getCommentsforid()+"&userid.userid="+sr.getUseridare().getUserid()+"&type="+type+"&replycontent="+sr.getReplycontent();
	}

}
