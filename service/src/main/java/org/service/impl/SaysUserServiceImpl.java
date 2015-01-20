package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysAlbumDao;
import org.dao.ISaysRizhitypeDao;
import org.dao.ISaysUserDao;
import org.dao.ISaysUserwordDao;
import org.entity.SaysAlbum;
import org.entity.SaysFriends;
import org.entity.SaysLeaveword;
import org.entity.SaysRizhitype;
import org.entity.SaysUser;
import org.entity.SaysUserword;
import org.service.ISaysAlbumService;
import org.service.ISaysLeavewordService;
import org.service.ISaysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.vo.Page;


@Service
public class SaysUserServiceImpl implements ISaysUserService{

	@Autowired
	private ISaysUserDao userdao;
	@Autowired
	private ISaysAlbumDao albumdao;
	@Autowired
	private ISaysRizhitypeDao rizhidao;
	@Autowired
	private ISaysUserwordDao userwordDao;


	
	@Override
	public List loginuser(String username, String userpassword)
			throws DataAccessException {
		
		List log = userdao.login(username, userpassword);
		
		if(log.size()==0)
		{
			throw new RuntimeException("登陆失败! 用户名或密码错误！");
		}
		return log;
	}

	@Override
	public Serializable addnewSaysuser(SaysUser saysuser) throws DataAccessException {
		
		
		List  u=userdao.selectbyusername(saysuser.getUsername());
		if(u.size()!=0)
		{
			System.out.println("账号已存在！");
			return null;
				
		}else 
		{
			Serializable s = userdao.save(saysuser);
			
				System.out.println("注册成功！"+s);

				SaysAlbum sal= new SaysAlbum();
		     	sal.setAlbumremark("本人靓照");
		     	sal.setAlbumstatus(2);
		     	sal.setAlbumtitle("我的相册");
		     	sal.setAlbumtopimg("fm.jpg");
		     	SaysUser user = new SaysUser();
		     	user.setUserid((String)s);
		     	sal.setUserid(user);
		     	System.out.println(sal.getUserid().getUserid()+"su");
		     	Serializable xc=albumdao.addAlbum(sal);
		     	System.out.println(xc.toString()+"默认相册");
		     	
		     	
		    	SaysRizhitype rzt = new SaysRizhitype();
		    	rzt.setTypename("个人日志");
		    	SaysUser ur = new SaysUser();
		    	ur.setUserid((String)s);
		    	rzt.setUserid(ur);
		    	rzt.setTypestatus(2);
		    	Serializable rz=rizhidao.save(rzt);
		     	System.out.println(rz.toString()+"默认日志类型");
		     	
		     	SaysUserword userword=new SaysUserword();
		     	userword.setUserid(ur);
		     	userword.setUserwordcontent("你很懒哦，暂时没有内容！");
		     	this.userwordDao.save(userword);
		     	return s;
		}
	}

	@Override
	public List selectSaysuserbyid(String userid) throws DataAccessException {
		// TODO Auto-generated method stub
		
		List info= userdao.selectSaysuser(userid);
		return info;
	}

	@Override
	public void updateSaysUserinfo(SaysUser saysuser)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
		userdao.updateSaysUser(saysuser);
	}

	@Override	
	public Page<SaysUser> mhcxSaysUserinfo(Serializable username,Page<SaysUser> page)throws DataAccessException{
		// TODO Auto-generated method stub
		
		page.setDataSum(userdao.countSaysFriends(username));
		
		List u2=userdao.mhcxSaysUser(username, page.getFirstResult(), page.getMaxResults());
		if(u2.size()==0){
			System.out.println("对不起,没有相关资料！");
		}
		System.out.println(u2.size());
		page.setResult(u2);
		System.out.println(page.getDataSum()+"haha");
		return page;
	}

	@Override
	public int countSaysFriendssl(Serializable username) throws DataAccessException {
		// TODO Auto-generated method stub
		
		return userdao.countSaysFriends(username);
	}

	@Override
	public List selectbyname(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return userdao.selectbyusername(username);
	}

	

}
