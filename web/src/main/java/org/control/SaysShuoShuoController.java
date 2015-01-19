package org.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;




import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.ISaysNewsService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.vo.ContentData;
import org.vo.Page;

@Controller
@RequestMapping("/Shuoshuo")
public class SaysShuoShuoController implements ServletContextAware {

	
	
	private ServletContext servletContext;
	@Autowired
	private IsaysShouShouService shouService;
	
	@RequestMapping("/toshuoshuo")
	public String  findAllShuoShuo(String userid,
			Page<SaysShuoshuo> page,Model model){
	        
			if(page.getPageNo()==null){
	        	page.setPageNo(1);
	        }

			Page<ContentData<Object>> page2 =this.shouService.findAllShuoShuo(userid, page, 0);
			model.addAttribute("page2", page2.getResult());
			model.addAttribute("page1", page2);
			model.addAttribute("userid", userid);
			
			if(page2.getPageNo()==null){
	        	page2.setPageNo(1);
	        }
			
			
			System.out.println("----------------page2长度-------------");
			System.out.println(page2.getPageNo());
			System.out.println(page2.getPageSize());
			System.out.println(page2.getResult().size());
		
			return "shuoshuo/shuoshuolist";
	}
	
	@RequestMapping("/addshuoshuo")
	public String addShuoshuo(SaysShuoshuo ss,@RequestParam("shuoimg1")MultipartFile file,HttpSession session){
		System.out.println("shuoshuo");
		SaysUser user = (SaysUser)session.getAttribute("myuser");
	//	System.out.println(ss.getShuocontent());
		ss.setUserid(user);
		ss.setShuonature(0);
		ss.setShuostatus(1);
		System.out.println(ss);
		// 把临时文件保存到指定的目标中
				if (!file.isEmpty()) {
					// 获得文件上传的目标
					String fileuppath =  this.servletContext.getRealPath("WEB-INF/images/shuoshuo");
					// 根据路径创建File对象
					File uploadFile = new File(fileuppath);
					if (!uploadFile.exists()) {  // 判断是否存在目录
						uploadFile.mkdir();	// 创建目录
					}
					Serializable sli= this.shouService.addShouShou(ss);
					ss.setShuoimg(sli+".jpg"+"");
					this.shouService.updateShouShou(ss);;
					FileOutputStream out;
					try {
						out = new FileOutputStream(fileuppath + File.separator
								+ sli+".jpg");
						 FileCopyUtils.copy(file.getBytes(), out);
						
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}else{
					Serializable sli= this.shouService.addShouShou(ss);
				}
		
		return "redirect:/Shuoshuo/toshuoshuo?userid="+user.getUserid();
	}
	@RequestMapping("/deleteshuoshuo")
	public String deleteshuoshuoByID(String shuoid,HttpSession session){
		this.shouService.deleteShuoShuo(shuoid);
		SaysUser user = (SaysUser)session.getAttribute("myuser");
		return "redirect:/Shuoshuo/toshuoshuo?userid="+user.getUserid();
	}
	
	public void setServletContext(ServletContext arg0) {
		this.servletContext=arg0;
	}











}

	

