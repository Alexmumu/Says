package org.control;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.service.ISaysMsgcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.ContentData;
import org.vo.MsgDataVo;
import org.vo.Page;

@Controller
@RequestMapping("/Msgcenter")
public class SaysMsgcenterController {

	@Autowired
	private ISaysMsgcenterService msgcenterService;
	
	@RequestMapping("/listMsg")
	public @ResponseBody Map<String,Object> listMsg(String id,Page<SaysMsgcenter> page){
		Page<MsgDataVo> pages=msgcenterService.findMsgByUser((Serializable)id,page );
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("pageSum",pages.getPageSum());
		map.put("dataSum",pages.getDataSum());
		map.put("msglist",pages.getResult());
		return map;
		
	}
	
	@RequestMapping("/deleteMsg")
	public @ResponseBody Map<String,Object> deleteMsg(String id){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("status", msgcenterService.deleteMsg(id));
		return map;
	}
	
	
}
