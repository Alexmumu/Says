package org.control;

import org.entity.SaysAlbum;
import org.entity.SaysShuoshuo;
import org.service.ISaysAlbumService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vo.ContentData;
import org.vo.Page;

@Controller
@RequestMapping("/shoushou")
public class ShoushouControl {

	@Autowired
	private IsaysShouShouService shoushouService;
	
	@RequestMapping("listshou")
	public String listShoushou(String userid ,Page<SaysShuoshuo> page,Model model ){
		System.out.println("用户id"+userid);
		if(page.getPageNo()==null)
		{
			page.setPageNo(1);
		}
		Page<ContentData<Object>>  page1= shoushouService.findAllShuoShuo(userid, page,0);
		System.out.println("的后的后"+page1.getResult().size());
		model.addAttribute("shou",page1);	
		return "shoushoulist";
	}
}
