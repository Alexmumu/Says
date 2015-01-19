package org.control;

 
import java.io.Serializable;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.entity.SaysAlbum;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ModelAndView;
import org.vo.Page;
 
 
 

@Controller
@RequestMapping("/album")
public class AlbumControl implements ServletContextAware{
	
	private ServletContext servletContext;

	@Autowired
	private ISaysAlbumService albumService;
	
	@Autowired
	private ISaysUserService userService;
	/**
	 * 分页查询所有相册
	 * @param userid
	 * @param page
	 * @param albumstatus
	 * @return
	 */
	@RequestMapping("/listalbum" )
	public String listAlbum(@RequestParam("userid")String userid, Page<SaysAlbum> page,Model model )
	{
		if(page.getPageNo()==null)
		  {
			page.setPageNo(1);
		  }
		System.out.println("wolaol");
		SaysUser user =new SaysUser();
		user.setUserid(userid);
		SaysAlbum al=new SaysAlbum();
		al.setUserid(user);
	   	page=albumService.findByUserId(al, page);
		System.out.println("xy"+page.getResult());
		model.addAttribute("page",page);
		model.addAttribute("dqyhid", userid);
	    List user1=userService.selectSaysuserbyid(userid);
	    System.out.println("用户"+user1);
		model.addAttribute("user",user1.get(0));
		return "albumlist";
		
	}
	
	@RequestMapping("/toaddalbum" )
	public String toaddalbum(Model model,HttpSession session)
	{
		SaysUser suser=(SaysUser) session.getAttribute("myuser");
		model.addAttribute("userid", suser.getUserid());
		return "addalbum";
	}
	/**
	 * 获取要修改的相册信息
	 * @param albumid
	 * @return
	 */
	@RequestMapping("/getAlbumbyAlbumid")
	public String getAlbumByAlbumid(String albumid,Model model)
	{
		
		System.out.println("update");
		System.out.println("用户id"+albumid);
		SaysAlbum album =albumService.findAlbumByalbumid(albumid);
		model.addAttribute("album",album);
		return "update";
	}
	
	/**
	 * 修改指定的相册
	 * @param al
	 */
	@RequestMapping("/updateAlbum")
	public String updateAlbum(SaysAlbum al,@RequestParam("img")MultipartFile file,HttpSession session)
	{
		SaysUser user1=(SaysUser)session.getAttribute("myuser");
		SaysUser user=new SaysUser();
        user.setUserid(user1.getUserid());
		al.setUserid(user);
		al.setAlbumstatus(1);
		String title=al.getAlbumtitle();
		al.setAlbumtitle(title);
		String remark=al.getAlbumremark();
		al.setAlbumremark(remark);
		System.out.println("开始上传4");
	
          // 把临时文件保存到指定的目标中
		if (!file.isEmpty()) {
			System.out.println("开始上传5");
	        // 获得文件上传的目标
			String fileuppath = this.servletContext.getRealPath("WEB-INF/images/albumimg");
			// 根据路径创建File对象
			File uploadFile = new File(fileuppath);
			if (!uploadFile.exists()) {  // 判断是否存在目录
				uploadFile.mkdir();	// 创建目录
			}

		    FileOutputStream out;
			try {
				//获取当前的毫秒数
				long time = System.currentTimeMillis();
				out = new FileOutputStream(fileuppath + File.separator
						+time+".jpg");
				 FileCopyUtils.copy(file.getBytes(), out);
					
					System.out.println("修改了噢噢噢噢");
					 
						al.setAlbumtopimg(time+".jpg"+"");
//					 System.out.println("修改中噢噢噢噢");
//				    this.albumService.updateAlbum(al);
//					System.out.println("修改后噢噢噢噢");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		 this.albumService.updateAlbum(al);
		
		return "redirect:/album/listalbum?userid="+al.getUserid().getUserid();
 }
	
	/**
	 * 添加一个相册
	 * @param al
	 * @return
	 */
	@RequestMapping("/addAlbum")
	public String addAlbum(SaysAlbum al,@RequestParam("albumtopimg2")MultipartFile file,HttpServletRequest request,String userId )
	{
		System.out.println("用户名"+userId);
		SaysUser user=new SaysUser();
		user.setUserid(userId);
		al.setUserid(user);
		al.setAlbumstatus(1);
		// 把临时文件保存到指定的目标中
		if (!file.isEmpty()) {
			// 获得文件上传的目标
			String fileuppath = this.servletContext.getRealPath("WEB-INF/images/albumimg");
			// 根据路径创建File对象
			File uploadFile = new File(fileuppath);
			if (!uploadFile.exists()) {  // 判断是否存在目录
				uploadFile.mkdir();	// 创建目录
			}
			
			Serializable sli= this.albumService.addAlbum(al);
			al.setAlbumtopimg(sli+".jpg"+"");
			this.albumService.updateAlbum(al);
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

		}
		
		return "redirect:/album/listalbum?userid="+userId;
		
	}
	
	/**
	 * 删除一个相册
	 * @param albumid
	 * @param Ralbumid
	 */
	@RequestMapping("delectAlbum")
	public String delectAlbum(String albumid,HttpSession session)
	{
		SaysUser user=(SaysUser)session.getAttribute("myuser");
		String userid=user.getUserid();
		System.out.println("删除相册");
		albumService.delectAlbum(albumid,userid);
		return "redirect:/album/listalbum?userid="+userid;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext=arg0;
	}

	
}
