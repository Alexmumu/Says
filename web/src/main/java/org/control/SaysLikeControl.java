package org.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dao.ISaysLikeDao;
import org.entity.SaysLike;
import org.entity.SaysUser;
import org.service.ISaysLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/Like")
public class SaysLikeControl {
	@Autowired
	private ISaysLikeService saysLikeServiceImpl; 
	
	@Autowired
	private ISaysLikeDao saysLikeDaoImpl;
	
	
	@RequestMapping("/pageDianZanNum")
	public String pageDianZanNum(SaysLike slk,Model model){
		System.out.println("qqq");
		SaysUser sus=new SaysUser();
		sus.setUserid("U001");
		slk.setLikefor("S001");
		slk.setUseridare(sus);
		int aa=saysLikeServiceImpl.countByLikeforAndUseridSaysLike(slk.getLikefor(), slk.getUseridare().getUserid());
		System.out.println(aa);
		model.addAttribute("Likecount", aa);
		return "rizhi/rizhineirong";
	}
	@RequestMapping("/clickReturnDianZanNum")
	public @ResponseBody Map<String,Object> clickReturnDianZanNum(SaysLike sl,Model model){
		System.out.println(sl.getUserid().getUserid());
		System.out.println(sl.getUseridare().getUserid());
		System.out.println(sl.getLikefor());
		saysLikeServiceImpl.saveSaysLike(sl);
		int aa=saysLikeServiceImpl.countByLikeforAndUseridSaysLike(sl.getLikefor(), sl.getUseridare().getUserid());
		System.out.println("YSha"+aa);
		List<SaysLike> lklist=saysLikeServiceImpl.findByLikeforAndUseridSaysLike(sl.getLikefor(), sl.getUseridare().getUserid());
		System.out.println("点赞信息"+lklist.size());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("dianzanNum",aa);
		map.put("dianzanlist", lklist);
		return map;
	}
	

}
