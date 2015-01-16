package org.control;

import org.entity.SaysMsgcenter;
import org.entity.SaysUser;
import org.service.ISaysMsgcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.MsgDataVo;
import org.vo.Page;

@Controller
@RequestMapping("/Msgcenter")
public class SaysMsgcenterController {

	@Autowired
	private ISaysMsgcenterService msgcenterService;
	
	@RequestMapping("/listMsg")
	public @ResponseBody Page<MsgDataVo> listMsg(SaysUser user,Page<SaysMsgcenter> page){
		
		return msgcenterService.findMsgByUser(user.getUserid(),page);
		
	}
	
}
