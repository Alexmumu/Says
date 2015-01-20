package org.control;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Service.Mode;

import org.dao.impl.SyasPhotoDaoImpl;
import org.entity.SaysBrowse;
import org.entity.SaysRelay;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.service.ISaysBrowseService;
import org.service.ISaysRelayService;
import org.service.ISaysRizhiService;
import org.service.ISaysRizhitypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vo.ContentData;
import org.vo.Page;

@Controller
@RequestMapping("/rizhi")
public class SaysRizhiControl {

	@Autowired
	private ISaysRizhiService saysRizhiService;
	@Autowired
	private ISaysRizhitypeService saysRizhitypeService;
	@Autowired
	private ISaysRelayService saysRelayService; 
	@Autowired
	private ISaysBrowseService saysBrowseService;
	
	@RequestMapping("/toRizhi")
	private String toRizhi(Model model,Page<SaysRizhi> page,SaysUser user){
		System.out.println(user.getUserid()+"userid");
		SaysRizhi srz = new SaysRizhi();
		user.setUserid(user.getUserid());
		srz.setRizhiuserid(user);
		srz.setRizhistatus(0);
        if(page.getPageNo()==null){
        	page.setPageNo(1);
        }
		System.out.println(page.getPageSize());
	System.out.println(user.getUserid()+"用户id");
		List<SaysRizhitype> listtype = saysRizhitypeService.find(user.getUserid(),0);
		
		page = saysRizhiService.findSaysRizhi(srz,page);
		System.out.println(page.getResult().size()+"查出来的数量");
		model.addAttribute("page",page);
		model.addAttribute("type",listtype);
		model.addAttribute("uid",user.getUserid());
		model.addAttribute("rz","to");
		return "rizhi/rizhilist" ;
	}
	
	
	
	
	@RequestMapping("/typeRizhi")
	private String typeRizhi(Model model,Page<SaysRizhi> page,SaysUser user,SaysRizhi rz){
		System.out.println(user.getUserid()+"userid");
		System.out.println(rz.getRizhitype().getTypeid());
		String typeid = rz.getRizhitype().getTypeid();
		model.addAttribute("typeid", typeid);
		
		user.setUserid(user.getUserid());
		rz.setRizhiuserid(user);
		rz.setRizhistatus(0);
        if(page.getPageNo()==null){
        	page.setPageNo(1);
        }
		System.out.println(page.getPageSize());
		page = saysRizhiService.findRizhitype(rz, page);
		List<SaysRizhitype> listtype = saysRizhitypeService.find(user.getUserid(),0);
		System.out.println(page.getResult().size());
		model.addAttribute("page",page);
		model.addAttribute("type",listtype);
		model.addAttribute("uid",user.getUserid());
		model.addAttribute("rz","type");
		return "rizhi/rizhilist" ;
	}
	
	@RequestMapping("/deleterizhibyid")
	private String deleterizhibyid(Model model,SaysRizhi rz){
		//System.out.println(rz.getRizhiuserid().getUserid());
		saysRizhiService.deleteStatus(rz.getRizhiid(), 0);
		
		return "redirect:/rizhi/toRizhi?userid="+rz.getRizhiuserid().getUserid();
	}
	
	@RequestMapping("/addrizhitype")
	private String addrizhitype(Model model,SaysRizhitype srzt){
		try {
			saysRizhitypeService.addRizhitype(srzt);
		} catch (Exception e) {
			// TODO: handle exception
			 
			model.addAttribute("cz","此类型已存在");
		}
	
		List<SaysRizhitype> listtype = saysRizhitypeService.find(srzt.getUserid().getUserid(),0);
		model.addAttribute("type",listtype);
		
		
		return "rizhi/rizhitypeguanli";
		
	}
	@RequestMapping("/toRizhitypegl")
	private String toRizhitypegl(Model model,SaysRizhitype rzt){
		
		System.out.println(rzt.getUserid().getUserid());
		List<SaysRizhitype> listtype = saysRizhitypeService.find(rzt.getUserid().getUserid(),0);
		model.addAttribute("type",listtype);
		
		return "rizhi/rizhitypeguanli";
		
	}
	
	@RequestMapping("/getRizhiid")
	private String getRizhiid(Model model,	SaysRizhi rz,HttpSession session){
		SaysUser user=(SaysUser) session.getAttribute("myuser");
		ContentData<SaysRizhi>  data= saysRizhiService.SaysRizhiById(rz.getRizhiid());
		//添加一天阅读信息表
		SaysBrowse saysBrowse = new SaysBrowse();
		SaysUser rzuserid = new SaysUser();
		rzuserid.setUserid(rz.getRizhiuserid().getUserid());
		saysBrowse.setUserid(rzuserid);
		saysBrowse.setUseridare(user);
		saysBrowse.setBrowsefor(rz.getRizhiid());
		this.saysBrowseService.saveSaysBrowse(saysBrowse);
		//阅读信息表结束
		
		
		//System.out.println(srz.getRizhitype().getTypename());
		SaysRizhi srz = data.getData();
		//判断是否转发日志
		if(srz.getRizhinature()==1){
			System.out.println(srz.getRizhiid());
			System.out.println(srz.getRizhiuserid().getUserid());
			SaysRelay rzr=this.saysRelayService.findByUseridAndRelayafterSaysRelay(srz.getRizhiuserid().getUserid(),srz.getRizhiid());
			System.out.println(rzr.getUseridare().getUsername());
			model.addAttribute("rzr",rzr);
		}
		model.addAttribute("uid",data.getData().getRizhiuserid().getUserid());
		model.addAttribute("srz",data);
		model.addAttribute("yuedu",this.saysBrowseService.countByBrowseforSaysBrowse(rz.getRizhiid()));
		return "rizhi/rizhibyid";
		
	}
	@RequestMapping("/getRizhitypeid")
	private String getRizhitypeid(Model model,SaysRizhitype rzt){
		System.out.println(rzt.getTypeid()+"sdsf");
		SaysRizhitype rzt1 = saysRizhitypeService.SaysRizhiById(rzt.getTypeid());
		model.addAttribute("rzt",rzt1);
		return "rizhi/rizhitypebyid";
		
	}
	
	@RequestMapping("/toaddrizhi")
	private String toaddrizhi(Model model,SaysUser user){
		List<SaysRizhitype> listtype = saysRizhitypeService.find(user.getUserid(),0);
		model.addAttribute("type",listtype);
		return "rizhi/addrizhi";
		
	}
	@RequestMapping("/addrizhi")
	private String addrizhi(Model model,SaysRizhi rz){
		rz.setRizhistatus(1);
		saysRizhiService.addSaysRizhi(rz);
		return "redirect:/rizhi/toRizhi?userid="+rz.getRizhiuserid().getUserid();
	}
	@RequestMapping("/deleterizhitype")
	private String deleterizhitype(Model model,SaysRizhitype rzt){
		System.out.println(rzt.getUserid().getUserid());
		saysRizhitypeService.deleteRizhitype(rzt);
		
		return "redirect:/rizhi/toRizhitypegl?userid.userid="+rzt.getUserid().getUserid();
	}

	@RequestMapping("/updatarizhitype")
	private String updatarizhitype(Model model,SaysRizhitype rzt){
		System.out.println(rzt.getUserid().getUserid());
		try {
			saysRizhitypeService.updataRizhitype(rzt);
		} catch (Exception e) {
			// TODO: handle exception	
		}
		return "redirect:/rizhi/toRizhitypegl?userid.userid="+rzt.getUserid().getUserid();
	}
	@RequestMapping("/toupdatarizhi")
	private String toupdatarizhi(Model model,SaysRizhi rz){
		System.out.println(rz.getRizhiuserid().getUserid());
		ContentData<SaysRizhi>  data= saysRizhiService.SaysRizhiById(rz.getRizhiid());
		List<SaysRizhitype> listtype = saysRizhitypeService.find(rz.getRizhiuserid().getUserid(),0);
		model.addAttribute("type",listtype);
		model.addAttribute("rz1",data.getData());
		return "rizhi/updaterizhi";
	}
	
	@RequestMapping("/updaterizhi")
	private String updaterizhi(Model model,SaysRizhi rz){
		saysRizhiService.updateSaysRizhi(rz);
		return "redirect:/rizhi/toRizhi?userid="+rz.getRizhiuserid().getUserid();
	}
	
}
