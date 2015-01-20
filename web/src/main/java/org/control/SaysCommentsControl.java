package org.control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dao.ISaysCommentsDao;
import org.dao.ISaysMsgcenterDao;
import org.entity.SaysComments;
import org.entity.SaysMsgcenter;
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
	@Autowired
	private ISaysMsgcenterDao saysMsgcenterDaoImpl;
	
	/**
	 * 
	 * @param cs  评论需要传项目id 访问的用户id 和type
	 * @param model 1为评论说说  2为评论日志 3为评论相册
	 * @param page
	 * @return
	 */
	@RequestMapping("/toComments")
	public String toComments(SaysComments cs,Model model,Page<SaysComments> page){
			System.out.println(page.getPageNo());
			System.out.println(cs.getUseridare().getUserid()+"我草你吗个比");
			page.setPageSize(4);
			Page page1=saysCommentsServiceImpl.findComments(cs.getCommentsforid(), page, "1");
			model.addAttribute("page1", page1);
			model.addAttribute("aaa", cs.getUseridare().getUserid());
		return "pinlun/pinlunneirong";
	}

	@RequestMapping("/toCommentsaa")
	public String toCommentsaa(SaysComments cs,Model model,Page<SaysComments> page,int type){	
		int i=saysCommentsDaoImpl.CountComments(cs.getCommentsforid(),"1");
		System.out.println("iiiiii"+i);
		page.setPageSize(4);
		page.setDataSum(i);
		System.out.println("aassdfff"+page.getPageSum());
		model.addAttribute("pageSum", page.getPageSum());
		model.addAttribute("Commentsforid",cs.getCommentsforid());
		model.addAttribute("Userid",cs.getUserid().getUserid());
		model.addAttribute("type",type);
		System.out.println(cs.getUserid().getUserid());
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
	/**
	 * 
	 * @param cs 
	 * @param model
	 * @param type 1为评论说说  2为评论日志 3为评论相册
	 * @return
	 */
	@RequestMapping("/addComments")
	public String addComments(SaysComments cs,Model model,int type,HttpSession session){
		System.out.println(cs.getUseridare().getUserid()+"WaWA");
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		
		cs.setCommentstatus("1");
		System.out.println(type+"oooooooooppppp");
		
		if(type==2)
		{
			SaysMsgcenter msg=new SaysMsgcenter();
			msg.setMcstatus(1);
			msg.setMcfromid(cs.getCommentid());
			msg.setMctype(5);
			msg.setUserid(cs.getUserid());	
			saysMsgcenterDaoImpl.save(msg);	
		}
		if(type==3)
		{
			SaysMsgcenter msg=new SaysMsgcenter();
			msg.setMcstatus(1);
			msg.setMcfromid(cs.getCommentid());
			msg.setMctype(8);
			msg.setUserid(cs.getUserid());	
			saysMsgcenterDaoImpl.save(msg);	
		}
		model.addAttribute("beipinlunid", cs.getUseridare().getUserid());
		saysCommentsDaoImpl.save(cs);
		if(type==1)
		{
//			SaysMsgcenter msg=new SaysMsgcenter();
//			msg.setMcstatus(1);
//			msg.setMcfromid(cs.getCommentid());
//			msg.setMctype(2);
//			msg.setUserid(cs.getUserid());	
//			saysMsgcenterDaoImpl.save(msg);	
			System.out.println(cs.getCommentsforid()+"1111");
			System.out.println(cs.getUseridare().getUserid()+"22222");
			System.out.println(myuser.getUserid()+"33333333333");
			List<SaysComments> list=saysCommentsDaoImpl.FindCommentsNopage(cs.getCommentsforid(), myuser.getUserid(), cs.getUseridare().getUserid());
			for(int i=0;i<list.size();i++)
			{
				SaysMsgcenter msg=new SaysMsgcenter();
				msg.setMcstatus(1);
				msg.setMcfromid(list.get(i).getCommentid());
				msg.setMctype(2);
				msg.setUserid(list.get(i).getUserid());	
				saysMsgcenterDaoImpl.save(msg);
			}
		}
		return "redirect:/Comments/toCommentsaa?commentsforid="+cs.getCommentsforid()+"&userid.userid="+cs.getUseridare().getUserid()+"&type="+type;
	}
	
	
}