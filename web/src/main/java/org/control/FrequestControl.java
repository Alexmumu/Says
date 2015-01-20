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
@RequestMapping("/frequest")
public class FrequestControl {
	
	@Autowired
	private ISaysFrequestService saysrequestservice;
	
	
	
	//根据用户id，查询出用户的申请记录
	@RequestMapping(value="/findfrequest")
	public String findfrequest(String fruser,Page<SaysFrequest> page,Model model)
	{
		System.out.println("date"+fruser);
		System.out.println(page+"page");
		
		Page<SaysFrequest> p= new Page<SaysFrequest>();
    	p.setPageNo(1);
    	p.setPageSize(5);
		
		page=this.saysrequestservice.selectSaysFrequestall(fruser, p);
		model.addAttribute("page", page.getResult());
		
		System.out.println(page.getResult().size());
		return "user/frequestinfo";
	}
	
	
		//删除用户指定的好友申请记录
		@RequestMapping(value="/deletedfrequest")
		public String deletedfriends(String frid,Model model)
		{
			String msg3="已删除该记录！";
			System.out.println(frid);
			saysrequestservice.deletedSaysFrequestbyfrid(frid);
			model.addAttribute("msg", msg3);
			return "user/frequestinfo";
		}
	
}
