package org.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysPhotoService;
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
@RequestMapping("/photo")
public class PhotoControl implements ServletContextAware{
	
	private ServletContext servletContext;


	@Autowired
	private ISaysPhotoService photoService;
	
	
	@Autowired
	private ISaysAlbumService albumDao;

	/**
	 * 根据albumid查询所有的照片
	 * @param albumid
	 * @param page
	 * @param photostatus
	 * @return
	 */
	@RequestMapping("/listphoto")
	public String listphoto(String albumid,Page<SaysPhoto> page ,Model model)
	{
		System.out.println("欢迎查看我的photo");
		System.out.println("相片ID"+albumid);
		if(page.getPageNo()==null)
		{
			page.setPageNo(1);
		}
        Page<ContentData<Object>> page1= photoService.findPhotoByAlbumId(albumid, page);
	    model.addAttribute("photo",page1);
	    System.out.println("nihao"+page1.getResult().size());
	    
	    return "photo";
	}
	
	
	@RequestMapping("/toadd")
	public String toaddPhoto(String albumid,Model model)
	{
		System.out.println("我来了");
		System.out.println("ID"+albumid);
	   SaysAlbum album=albumDao.findAlbumByalbumid(albumid);
	 
	   model.addAttribute("album",album);
	   return "addphoto";
	}
	
	@RequestMapping("addPhoto")
	public String addPhoto(SaysPhoto ph,@RequestParam("myphoto") MultipartFile[] myphoto,Model model)
	{
         System.out.println("上传图片");
         System.out.println("相册"+ph.getAlbumid().getAlbumid());
          
         SaysUser user =new SaysUser();
         user.setUserid("U001");
         ph.setUserid(user);
		for(int i=0;i<myphoto.length;i++){
			if (!myphoto[i].isEmpty()){
				int pre = (int) System.currentTimeMillis(); 
				String path = this.servletContext.getRealPath("WEB-INF/images/photo/");
				File uploadFile = new File(path);
				if (!uploadFile.exists()) {  
					uploadFile.mkdir();
				}
				
				ph.setPhotoremark("我的照片");
				ph.setPhotostatus("1");
				Serializable p=photoService.addPhotoIntoAlbum(ph);
		        ph.setPhotosrc(p+".jpg"+"");
				photoService.updatePhoto(ph);
				 
				try {
			         FileOutputStream out =  new FileOutputStream(path + File.separator
								+ p+".jpg");
			         FileInputStream in = (FileInputStream) myphoto[i].getInputStream(); 
			         FileCopyUtils.copy(in, out);
			          
					 
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
			
		}
		    
         
        return "redirect:/photo/listphoto?albumid="+ph.getAlbumid().getAlbumid();  
     
	}
	
	
	@RequestMapping("delectphoto")
	public String delectphoto(String photoid,String albumid){
		System.out.println("ID"+photoid);
		System.out.println("AID"+albumid);
		photoService.delect(photoid);
		return "redirect:/photo/listphoto?albumid="+albumid;
	} 
	

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext=arg0;
	}	
}
