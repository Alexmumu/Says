package org.control;

import java.io.Serializable;
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
import org.entity.SaysLeaveword;
import org.entity.SaysMsgcenter;
import org.entity.SaysNews;
import org.entity.SaysRelay;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysRelayService;
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
	private ISaysShouShousDao saysShouShousDaoImpl;
	@Autowired
	private ISaysRizhiDao saysRizhiDaoImpl;
	@Autowired
	private IsaysShouShouService saysShouShouServiceImpl;
	@Autowired
	private ISaysRelayService saysRelayServiceImpl;
	@Autowired
	private ISaysRelayDao saysRelayDaoImpl;
	@Autowired
	private ISaysAlbumDao saysAlbumDaoImpl;
	@Autowired
	private IsaysShouShouService shuoshuoservice;
	
	@Autowired
	private ISaysMsgcenterDao SaysMsgcenterDaoImpl;
	
	@Autowired
	private ISaysNewsDao saysNewsDaoImpl;
	@Autowired
	private ISaysRizhitypeService saysRizhitypeService;
	@Autowired
	private ISaysAlbumService saysAlbumService;
	
	/**
	 * 转发服务的根接口
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
		sr.setRelayfrom("S001");
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
			
		}
		return "zhuanzai/zhuanfa";
	}
	@RequestMapping("/addRelay")
	public String addRelay(SaysRelay sr,int type,HttpSession session){
		//获取当前登录的用户
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		//说说被转发 
		System.out.println("woleaas"+sr.getUserid().getUserid());
		System.out.println("rwasda"+type);
				if(type==1){
					SaysShuoshuo  shuoshuo=new SaysShuoshuo();
					shuoshuo.setShuonature(1);
					shuoshuo.setShuostatus(1);
					shuoshuo.setUserid(sr.getUserid());
					
					//获取转发后另一个项目id
					Serializable sli=shuoshuoservice.addShouShou(shuoshuo);
					//在转发表中加数据
					sr.setRelayafter((String)sli);
					this.saysRelayServiceImpl.saveSaysRelay(sr);
					//添加消息表记录
					SaysMsgcenter msg=new SaysMsgcenter();
					msg.setMcfromid(sli.toString());
					msg.setMcstatus(0);
					msg.setMctype(3);
					msg.setUserid(myuser);
					SaysMsgcenterDaoImpl.save(msg);
					//动态表添加记录
					SaysNews sn=new SaysNews();
					sn.setNewscontent(sli.toString());
					sn.setNewsstatus(2);
					sn.setUserid(myuser);
					saysNewsDaoImpl.save(sn);
					
					
				}else if(type==2){
					//转载前添加一条转载的日志
					SaysRizhi srz=saysRizhiDaoImpl.getById(sr.getRelayfrom());
					SaysRizhi rz=new SaysRizhi();
					rz.setRizhititle(srz.getRizhititle());
					rz.setRizhicontent(srz.getRizhicontent());
					rz.setRizhitype(srz.getRizhitype());
					rz.setRizhiuserid(myuser);
					rz.setRizhinature(1);
					rz.setRizhistatus(1);
					saysRizhiDaoImpl.save(rz);
					//添加转载记录
					SaysRelay ssr1=new SaysRelay();
					ssr1.setRelayfrom("RZ01");
					ssr1.setRelayafter(rz.getRizhiid());
					SaysUser sus2=new SaysUser();
					sus2.setUserid(sr.getUseridare().getUserid());
					ssr1.setUserid(sus2);
					ssr1.setUseridare(srz.getRizhiuserid());
					ssr1.setRelayfor(sr.getRelayfor());
					saysRelayServiceImpl.saveSaysRelay(ssr1);
					//添加消息表记录
					SaysMsgcenter msg=new SaysMsgcenter();
					msg.setMcstatus(0);
					msg.setMcfromid("RZ01");
					msg.setMctype(6);
					SaysUser sus3=new SaysUser();
					sus3.setUserid(ssr1.getUserid().getUserid());
					msg.setUserid(sus3);
					SaysMsgcenterDaoImpl.save(msg);
					//动态表添加记录
					SaysNews sn=new SaysNews();
					sn.setNewscontent(srz.getRizhicontent());
					sn.setNewsstatus(4);
					SaysUser sus4=new SaysUser();
					sus4.setUserid(srz.getRizhiuserid().getUserid());
					sn.setUserid(sus4);
					saysNewsDaoImpl.save(sn);
					
					
				}else if(type==3){
					//转载前添加一条转载的相册
					SaysAlbum sal=saysAlbumDaoImpl.getById("A001");
					SaysAlbum sa=new SaysAlbum();
					sa.setAlbumtitle(sal.getAlbumtitle());
					sa.setAlbumremark(sa.getAlbumremark());
					sa.setAlbumtopimg(sal.getAlbumtopimg());
					SaysUser sus=new SaysUser();
					sus.setUserid(sr.getUseridare().getUserid());
					sa.setUserid(sus);
					sa.setAlbumstatus(1);
					saysAlbumDaoImpl.save(sa);
					//添加转载记录
					SaysRelay ssr1=new SaysRelay();
					ssr1.setRelayfrom("A001");
					ssr1.setRelayafter(sa.getAlbumid());
					SaysUser sus2=new SaysUser();
					sus2.setUserid(sr.getUseridare().getUserid());
					ssr1.setUserid(sus2);
					ssr1.setUseridare(sal.getUserid());
					ssr1.setRelayfor(sr.getRelayfor());
					saysRelayServiceImpl.saveSaysRelay(ssr1);
					//添加消息表记录
					SaysMsgcenter msg=new SaysMsgcenter();
					msg.setMcstatus(0);
					msg.setMcfromid("A001");
					msg.setMctype(9);
					SaysUser sus3=new SaysUser();
					sus3.setUserid(ssr1.getUserid().getUserid());
					msg.setUserid(sus3);
					SaysMsgcenterDaoImpl.save(msg);
					//动态表添加记录
					SaysNews sn=new SaysNews();
					sn.setNewscontent(sal.getAlbumremark());
					sn.setNewsstatus(6);
					SaysUser sus4=new SaysUser();
					sus4.setUserid(sal.getUserid().getUserid());
					sn.setUserid(sus4);
					
					saysNewsDaoImpl.save(sn);
				}
		
		return "redirect:/Relay/findall?relayfrom="+sr.getRelayfrom()+"&type="+type;
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
