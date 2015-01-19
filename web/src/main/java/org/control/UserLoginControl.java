package org.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.entity.SaysAlbum;
import org.entity.SaysProtection;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysProtectionService;
import org.service.ISaysRizhitypeService;
import org.service.ISaysUserService;
import org.service.impl.SaysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ReaderContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;

@Controller
@RequestMapping("/user")
public class UserLoginControl implements ServletContextAware {

	@Autowired
	private ISaysUserService saysUserServiceImpl;
	@Autowired
	private ISaysProtectionService saysprotectionImpl;

	private ServletContext servletContext;

	// 注册 注册成功后添加一个默认不可删除的相册和日志类型
	@RequestMapping(value = "/useradd")
	public String useradd(SaysUser user, Model model) {
		user.getUsername();
		user.getUserpassword();
		user.setUsernickname("人类");
		user.setUsersex(0);
		user.setUserimg("touxiang1.jpg");
		user.setUsersig("帅哥或美女");
		user.setUserarea("地球");

		System.out.println(user.getUsername() + user.getUserpassword());

		@SuppressWarnings("unchecked")
		List<SaysUser> u = saysUserServiceImpl.selectbyname(user.getUsername());
		String msg = "账号已存在！请重新注册！";
		if (u.size() != 0) {
			model.addAttribute("msg", msg);
			return "user/login";
		} else {
			Serializable s = this.saysUserServiceImpl.addnewSaysuser(user);
			System.out.println(s);
			List hh = saysUserServiceImpl.selectSaysuserbyid((String) s);
			System.out.println("hh" + hh);
			if (s != null) {
				// SaysUser uu= new SaysUser();
				// uu.setUserid( (String) s);
				// System.out.println("id"+uu);
				model.addAttribute("hh", hh);
				return "user/userinfo";
			}
		}
		return "user/login";
	}

	// 添加完成后跳到完善信息页面，并修改用户信息
	@RequestMapping(value = "/userupdate")
	public String userupdate(SaysUser user, Model model) {
		System.out.println(user.toString() + "信息");
		saysUserServiceImpl.updateSaysUserinfo(user);
		return "user/login";
	}

	// 根据用户id查询用户个人信息和密保到修改页面
	@RequestMapping(value = "/finduser")
	public String finduser(String userid, Model model) {
		List<SaysUser> uinfo = saysUserServiceImpl.selectSaysuserbyid(userid);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String d = format.format(uinfo.get(0).getUserbirthday());
		try {
			Date date = format.parse(d);
			System.out.println("生日" + date.getTime());
			model.addAttribute("date", date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("uinfo", uinfo);
		System.out.println(uinfo + "用户信息");

		return "user/userinfoupdate";
	}

	// 进行修改
	@RequestMapping(value = "/finduserupdate")
	public String finduserupdate(SaysUser user, Model model) {
		String msg = "修改成功！";
		System.out.println(user.toString() + "信息");
		saysUserServiceImpl.updateSaysUserinfo(user);
		model.addAttribute("msg", msg);

		return "user/userinfoupdate";
	}

	@RequestMapping("/updatetouxiang")
	public String updatetouxiang(@RequestParam("tximg") MultipartFile file,
			HttpSession session) {
		SaysUser myuser=(SaysUser) session.getAttribute("myuser");
		// 把临时文件保存到指定的目标中
		if (!file.isEmpty()) {
			// 获得文件上传的目标
			String fileuppath = this.servletContext
					.getRealPath("WEB-INF/images/touxiang");
			// 根据路径创建File对象
			File uploadFile = new File(fileuppath);
			if (!uploadFile.exists()) { // 判断是否存在目录
				uploadFile.mkdir(); // 创建目录
			}
			FileOutputStream out; 
			try {
				out = new FileOutputStream(fileuppath + File.separator
						+ myuser.getUserid()+".jpg");
				
				FileCopyUtils.copy(file.getBytes(), out);
				myuser.setUserimg(myuser.getUserid()+".jpg");
				this.saysUserServiceImpl.updateSaysUserinfo(myuser);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user/finduser?userid="+myuser.getUserid();


	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext=arg0;
	}
}
