package org.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dao.ISaysAlbumDao;
import org.dao.ISaysMsgcenterDao;
import org.dao.ISaysNewsDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysAlbum;
import org.entity.SaysRelay;
import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysRelayService;
import org.service.ISaysReplyService;
import org.service.ISaysRizhitypeService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.Page;

@Controller
@RequestMapping("/Relay")
public class SaysRelayControl {

	@Autowired
	private ISaysRizhitypeService saysRizhitypeService;
	@Autowired
	private ISaysAlbumService saysAlbumService;
	@Autowired
	private ISaysRelayDao saysRelayDaoImpl;
	@Autowired
	private ISaysRelayService saysRelayServiceImpl;
	

	

	

	/**
	 * 去转发服务的根接口
	 * @param sr 转发数据封装 请求需带上 被转发的项目id，被转发的用户id 
	 * @param model
	 * @param page
	 * @param type 请求需带上类型    1.说说  2.日志  3.相片 
	 * @return
	 */
	@RequestMapping("/findall")
	public String findall(SaysRelay sr,Model model,Page<SaysRelay> page,int type,HttpSession session){
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		sr.setUserid(myuser);
		page.setPageSize(4);
		int a=saysRelayDaoImpl.countByRelayfromSaysRelay(sr.getRelayfrom());
		page.setDataSum(a);
		model.addAttribute("pageSum", page.getPageSum());
		model.addAttribute("mytype",type);
		model.addAttribute("mysr", sr);
		if(type==2){
			List<SaysRizhitype> rtypelist=this.saysRizhitypeService.find(myuser.getUserid(), 0);
			model.addAttribute("rtypelist", rtypelist);
		}else if(type==3){
			SaysAlbum al=new SaysAlbum();
			al.setUserid(myuser);
			Page<SaysAlbum> alpage=new Page<SaysAlbum>();
			alpage.setPageNo(1);
			alpage.setPageSize(100);
			List<SaysAlbum> allist= this.saysAlbumService.findByUserId(al, alpage).getResult();
			model.addAttribute("allist", allist);
		}
		return "zhuanzai/zhuanfa";
	}
	
	/**
	 * 实现真正的转发服务。调用service层
	 * @param sr
	 * @param type
	 * @param alorrtypeId
	 * @param session
	 * @return
	 */
	@RequestMapping("/addRelay")
	public @ResponseBody Map<String,Object> addRelay(SaysRelay sr,int type,String alorrtypeId,HttpSession session,Model model){
		//获取当前登录的用户
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		Map<String,Object> map=new HashMap<String, Object>();
		try{
		this.saysRelayServiceImpl.addRelay(sr, type, myuser, alorrtypeId);
		}catch(RuntimeException e){
			map.put("msg", "shibai");
		}
		map.put("msg","chenggong");
		return map;
	}
	
	@RequestMapping("/list")
	public String list(SaysRelay sr,Model model,Page<SaysRelay> page){
		System.out.println("ttttttttttttrr"+sr.getRelayfrom());
		page.setPageSize(4);
		
		page=saysRelayServiceImpl.findCommentsByPage(sr.getRelayfrom(), page);
		System.out.println("wweerrtt");
		model.addAttribute("page", page);
		return "zhuanzai/zhuanfaneirong";
	}
	
}
