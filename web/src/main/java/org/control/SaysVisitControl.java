package org.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.entity.SaysUser;
import org.entity.SaysVisit;
import org.service.ISaysVisitService;
import org.service.impl.SaysVisvitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.Page;

@Controller
@RequestMapping("/visit")
public class SaysVisitControl {
	@Autowired
	private ISaysVisitService  svservice;
	
	/**
	 * 查询我看过谁   --访客表
	 * @param page
	 * @return	
	 */
	@RequestMapping("/findByMy")
	public @ResponseBody Page<SaysVisit> findByMyAndPage(Page<SaysVisit> page,HttpSession session){
		SaysUser user=(SaysUser) session.getAttribute("myuser");
		SaysVisit sv=new SaysVisit();
		sv.setFromuserid(user);
		page=this.svservice.findMySaysVisit(sv, page);
		
		return page;
	}
	/**
	 * 查询谁看过我 -访客表    
	 * @param page 
	 * @param session
	 * @return
	 */
	@RequestMapping("/findBy")
	public @ResponseBody Page<SaysVisit> findByPage(Page<SaysVisit> page,HttpSession session){
		SaysUser user=(SaysUser) session.getAttribute("myuser");
		SaysVisit sv=new SaysVisit();
		sv.setUserid(user);
		page=this.svservice.findSaysVisitsUseridByAndPage(sv, page);
		return page;

	}
	
	
}
