package org.control;

import java.io.Serializable;

import org.entity.SaysAlbum;
import org.entity.SaysPhoto;
import org.service.ISaysPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vo.Page;


@Controller
@RequestMapping("/photo")
public class PhotoControl {
	
	@Autowired
	private ISaysPhotoService photoService;

	/**
	 * 根据albumid查询所有的照片
	 * @param albumid
	 * @param page
	 * @param photostatus
	 * @return
	 */
	@RequestMapping("/listphoto")
	public String listphoto(String albumid,Page<SaysPhoto> page ,String photostatus,Model model)
	{
		System.out.println("欢迎查看我的photo");
		System.out.println("相片ID"+albumid);
		SaysAlbum al=new SaysAlbum();
		al.setAlbumid(albumid);
		SaysPhoto ph=new SaysPhoto();
		ph.setAlbumid(al);
	    Page<SaysPhoto>	page1=photoService.findPhotoByAlbumId(ph, page, photostatus);
	    model.addAttribute("photo",page1);
	    System.out.println("page"+page1.getResult().size());
	    return "photo";
	}
	
	public Serializable addPhoto(SaysPhoto ph)
	{
		return photoService.addPhotoIntoAlbum(ph);
	}
	

	
}
