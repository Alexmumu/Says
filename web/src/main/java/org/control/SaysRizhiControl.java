package org.control;

import java.io.Serializable;
import java.util.List;







import javax.xml.ws.Service.Mode;

import org.dao.impl.SyasPhotoDaoImpl;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.service.ISaysRizhiService;
import org.service.ISaysRizhitypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.Page;

@Controller
@RequestMapping("/rizhi")
public class SaysRizhiControl {

	@Autowired
	private ISaysRizhiService saysRizhiService;
	@Autowired
	private ISaysRizhitypeService saysRizhitypeService;
	
	@RequestMapping("/toRizhi")
	private String toRizhi(Model model,Page<SaysRizhi> page,SaysUser user){
		System.out.println(user.getUserid()+"userid");
		SaysRizhi srz = new SaysRizhi();
		System.out.println(page.getPageNo());
		user.setUserid(user.getUserid());
		srz.setRizhiuserid(user);
		srz.setRizhistatus(0);
        if(page.getPageNo()==null){
        	page.setPageNo(1);
        }
		System.out.println(page.getPageSize());
		page = saysRizhiService.findSaysRizhi(srz,page);
		model.addAttribute("page",page);
		List<SaysRizhitype> listtype = saysRizhitypeService.find("U001",0);
		model.addAttribute("type",listtype);
//		SaysUser user1 = new SaysUser();
//		user1.setUserid("U001");
//		model.addAttribute("uid",user1);
		return "rizhi/rizhilist" ;
	}
	
	
	
	
	@RequestMapping("/findrizhitype")
	private String findrizhitype(Model model,Page<SaysRizhi> page,SaysUser user){
		System.out.println(user.getUserid()+"userid");
		SaysRizhi srz = new SaysRizhi();
		System.out.println(page.getPageNo());
		user.setUserid(user.getUserid());
		srz.setRizhiuserid(user);
		srz.setRizhistatus(0);
        if(page.getPageNo()==null){
        	page.setPageNo(1);
        }
		System.out.println(page.getPageSize());
		page = saysRizhiService.findRizhitype(srz, page);
		model.addAttribute("page",page);
		List<SaysRizhitype> listtype = saysRizhitypeService.find(user.getUserid(),0);
		model.addAttribute("type",listtype);
//		SaysUser user1 = new SaysUser();
//		user1.setUserid("U001");
//		model.addAttribute("uid",user1);
		return "rizhi/rizhilist" ;
	}
	
	@RequestMapping("/deleterizhibyid")
	private String deleterizhibyid(Model model,SaysRizhi rz){
		//System.out.println(rz.getRizhiuserid().getUserid());
		saysRizhiService.deleteStatus(rz.getRizhiid(), 0);
		
		return "redirect:/rizhi/toRizhi?userid="+rz.getRizhiuserid().getUserid();
	}
//	@RequestMapping("/rizhilist")
//	private @ResponseBody Page<SaysRizhi> Rizhilist(Model model) {
//		SaysRizhi srz = new SaysRizhi();
//		SaysUser user = new SaysUser();
//		user.setUserid("U001");
//		srz.setRizhiuserid(user);
//		srz.setRizhistatus(0);
//		System.out.println(page.getPageNo());
//		System.out.println(page.getPageSize());
//		page = saysRizhiService.findSaysRizhi(srz,page);
//		model.addAttribute("page",page);
//		System.out.println(page.getResult().size());
//		return page;
//	}
	
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
	private String getRizhiid(Model model,	SaysRizhi rz){
		SaysRizhi srz = saysRizhiService.SaysRizhiById(rz.getRizhiid());
		//System.out.println(srz.getRizhitype().getTypename());
		model.addAttribute("srz",srz);
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
		List<SaysRizhitype> listtype = saysRizhitypeService.find("U001",0);
		model.addAttribute("type",listtype);
		return "rizhi/addrizhi";
		
	}
	@RequestMapping("/addrizhi")
	private String addrizhi(Model model,SaysRizhi rz){
		System.out.println(rz.getRizhititle());
		System.out.println(rz.getRizhicontent());
		System.out.println(rz.getRizhitype().getTypeid());
		System.out.println(rz.getRizhiuserid().getUserid());
		rz.setRizhistatus(1);
		saysRizhiService.addSaysRizhi(rz);
		
		return "rizhi/addrizhi";
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
		saysRizhitypeService.updataRizhitype(rzt);
		
		return "redirect:/rizhi/toRizhitypegl?userid.userid="+rzt.getUserid().getUserid();
	}
	@RequestMapping("/toupdatarizhi")
	private String toupdatarizhi(Model model,SaysRizhi rz){
		System.out.println(rz.getRizhiuserid().getUserid());
		SaysRizhi rz1 =this.saysRizhiService.SaysRizhiById(rz.getRizhiid());
		List<SaysRizhitype> listtype = saysRizhitypeService.find(rz.getRizhiuserid().getUserid(),0);
		model.addAttribute("type",listtype);
		model.addAttribute("rz1",rz1);
		return "rizhi/updaterizhi";
	}
	
	@RequestMapping("/updaterizhi")
	private String updaterizhi(Model model,SaysRizhi rz){
		saysRizhiService.updateSaysRizhi(rz);
		return "redirect:/rizhi/toRizhi?userid="+rz.getRizhiuserid().getUserid();
	}
	
}
