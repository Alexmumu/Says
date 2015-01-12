package org.service.impl;

import java.io.Serializable;
import java.util.List;











import org.dao.ISaysUserDao;
import org.entity.SaysFriends;
import org.entity.SaysUser;
import org.service.ISaysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.vo.Page;


@Service
public class SaysUserServiceImpl implements ISaysUserService{

	@Autowired
	private ISaysUserDao userdao;
	
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
		// TODO Auto-generated method stub
		
		List  u=userdao.selectbyusername(saysuser.getUsername());
		if(u.size()!=0)
		{
			System.out.println("账号已存在！");
			return false;	
		}else 
		{
			Serializable s = this.userdao.addSaysuser(saysuser);
			if(s!=null)
			{
				System.out.println("注册成功！");
				return true;	
			}
		}
		return saysuser; 
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
