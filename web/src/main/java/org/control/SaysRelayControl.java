package org.control;

import java.util.HashMap;
import java.util.Map;

import org.dao.ISaysRelayDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysLeaveword;
import org.entity.SaysRelay;
import org.entity.SaysRizhi;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.ISaysRelayService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/findall")
	public String findall(Model model){
		SaysUser sus=new SaysUser();
		sus.setUserid("U004");
		SaysRelay sr=new SaysRelay();
		sr.setRelayfrom("S001");
		sr.setUseridare(sus);
		model.addAttribute("Relay",sr);
		return "zhuanzai/zhuanfa";
	}
	
	@RequestMapping("/addRelayshuoshuo")
	public @ResponseBody Map<String,Object> addRelayshuoshuo(SaysRelay sr){
		//转载前添加一条转载的说说
		SaysShuoshuo ss=saysShouShousDaoImpl.getById("S001");
		System.out.println("neirong"+ss.getShuocontent());
		System.out.println("img"+ss.getShuoimg());
		SaysShuoshuo ss2=new SaysShuoshuo();
		ss2.setShuocontent(ss.getShuocontent());
		ss2.setShuoimg(ss.getShuoimg());
		ss2.setShuostatus(1);
		SaysUser sus=new SaysUser();
		sus.setUserid(sr.getUseridare().getUserid());
		ss2.setUserid(sus);
		ss2.setShuonature(1);
		saysShouShousDaoImpl.save(ss2);
		//添加转载记录
		SaysRelay ssr1=new SaysRelay();
		ssr1.setRelayfrom("S001");
		ssr1.setRelayafter(ss2.getShuoid());
		SaysUser sus2=new SaysUser();
		sus2.setUserid(sr.getUseridare().getUserid());
		ssr1.setUserid(sus2);
		ssr1.setUseridare(ss.getUserid());
		ssr1.setRelayfor(sr.getRelayfor());
		saysRelayServiceImpl.saveSaysRelay(ssr1);
		int i=saysRelayServiceImpl.countByRelayFromAndUseridareSaysRelay(ssr1.getRelayfrom(), ssr1.getUseridare().getUserid());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("zhuanzaiNum",i);
		return map;
	}
	
	@RequestMapping("/addRelayRizhi")
	public String addRelayRizhi(SaysRelay sr){
		//转载前添加一条转载的说说
		SaysRizhi srz=saysRizhiDaoImpl.getById("RZ01");
		System.out.println(srz.getRizhicontent());
		SaysRizhi srz2=new SaysRizhi();
		srz2.setRizhititle(srz.getRizhititle());
		srz2.setRizhicontent(srz.getRizhicontent());
		srz2.setRizhitype(srz.getRizhitype());
		SaysUser sus=new SaysUser();
		sus.setUserid(sr.getUseridare().getUserid());
		srz2.setRizhiuserid(sus);
		srz2.setRizhinature(1);
		srz2.setRizhistatus(1);
		saysRizhiDaoImpl.save(srz2);
		//添加转载记录
		SaysRelay ssr1=new SaysRelay();
		ssr1.setRelayfrom("RZ01");
		ssr1.setRelayafter(srz2.getRizhiid());
		SaysUser sus2=new SaysUser();
		sus2.setUserid(sr.getUseridare().getUserid());
		ssr1.setUserid(sus2);
		ssr1.setUseridare(srz.getRizhiuserid());
		ssr1.setRelayfor(sr.getRelayfor());
		saysRelayServiceImpl.saveSaysRelay(ssr1);
		return "zhuanzai/aaa";
	}
	
	
}
