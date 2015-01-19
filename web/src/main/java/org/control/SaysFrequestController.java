package org.control;

import javax.servlet.http.HttpSession;

import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ISaysFrequestService;
import org.service.ISaysFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户申请表
 * @author ipengyo
 *
 */
@Controller
@RequestMapping("Frequest")
public class SaysFrequestController {
	@Autowired
	private ISaysFrequestService sfservice;
	@Autowired
	private ISaysFriendsService friendService;
	/**
	 * 根据传入的用户id和状态修改相对应的数据
	 * @param frid
	 * @param frstatus
	 * @return
	 */
	@RequestMapping("update")
	public String update(String frid,int frstatus,HttpSession session){
		SaysFrequest sf= (SaysFrequest) sfservice.selectSaysFrequestbyid(frid).get(0);
		//状态为同意, 成为好机油
		if(frstatus==2){
			System.out.println("-------------------我要加好友--------------------");
			SaysUser user = sf.getFruser();
			SaysUser userare = (SaysUser)session.getAttribute("myuser");
			SaysFriends sf1=new  SaysFriends();
			sf1.setUserid(user);
			sf1.setUserfriendid(userare);
			SaysFriends sf2=new  SaysFriends();
			sf2.setUserid(userare);
			sf2.setUserfriendid(user);
			friendService.addnewSaysFriends(sf1);
			friendService.addnewSaysFriends(sf2);
		}
		sf.setFrstatus(frstatus);
		sfservice.updateSaysFrequestbyfrstatus(sf);
		return null;
	}
}
