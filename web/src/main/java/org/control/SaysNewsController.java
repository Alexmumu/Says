package org.control;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.entity.SaysNews;
import org.entity.SaysUser;
import org.service.ISaysNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vo.ContentData;
import org.vo.Page;

@Controller
@RequestMapping("/News")
public class SaysNewsController {

	@Autowired
	private ISaysNewsService newsService;
	
	@RequestMapping("/listNews")
	public @ResponseBody Map<String,Object> listNews(HttpSession session,Page<SaysNews> page){
		System.out.println(page.getPageNo());
		System.out.println("-----------------");
		System.out.println(page.getPageSize());
		SaysUser user = (SaysUser)session.getAttribute("myuser");
		Page<ContentData<Object>> pages=newsService.findNewsByUser(user.getUserid(),page );

		Map<String,Object> map=new HashMap<String, Object>();
		map.put("pageSum",pages.getPageSum());
		map.put("dataSum",pages.getDataSum());
//		System.out.println(pages.getResult().get(0).getData().getClass());
		map.put("newslist",pages.getResult());
					
		return map;
	}
	@RequestMapping("tolistNews")
	public String tolistNews(){
		
		return "haoyoudongtai";
	}
	
	
}
