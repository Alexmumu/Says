package org.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;








import org.dao.ISaysCommentsDao;
import org.dao.ISaysNewsDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysNews;
import org.entity.SaysRelay;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.AbstractBaseService;
import org.service.ISaysLikeService;
import org.service.ISaysUserService;
import org.service.IsaysShouShouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.ContentData;
import org.vo.Page;

@Service
public class SaysShouShouServiceImpl extends AbstractBaseService implements IsaysShouShouService {
 
	@Autowired
	private ISaysShouShousDao shoushouDao;
    @Autowired
	private ISaysNewsDao newsDao;

   private ISaysCommentsDao commDao;
    
    @Autowired
   private ISaysLikeService likeDao;
    
    @Autowired
   private ISaysRelayDao relDao;
    
    @Autowired
   private ISaysUserService userDao;

 
	@Override
	public void updateShouShou(SaysShuoshuo ss) {
		shoushouDao.updateShouShou(ss);
		
	}
	@Override
	public int countShouShouByUserId(Serializable userid, int shuostatus) {
		// TODO Auto-generated method stub
		return shoushouDao.countShouShouByUserId(userid, shuostatus);
	}

	@Override
	public Serializable addShouShou(SaysShuoshuo ss) {
		// TODO Auto-generated method stub
		Serializable ssid = this.shoushouDao.addShouShou(ss);
		SaysNews news = new SaysNews();
		news.setUserid(ss.getUserid());
		news.setNewsstatus(1);
		news.setNewscontent((String)ssid);
		this.newsDao.AddNew(news);
		return ssid;
	}
	
	public boolean deleteShuoShuo(Serializable shuoid){
		try {
			SaysShuoshuo shuoshuo = shoushouDao.getById(shuoid);
			shuoshuo.setShuostatus(0);
			shoushouDao.update(shuoshuo);
			SaysNews news = this.newsDao.getNewsIDBynewscontent(shuoid);
			this.newsDao.delete(news);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Page<ContentData<Object>> findAllShuoShuo(String userid,
		Page<SaysShuoshuo> page) {
		Page<ContentData<Object>> pagecount=new Page<ContentData<Object>>();
		page.setDataSum(shoushouDao.countShouShouByUserId(userid, 0));
		List<SaysShuoshuo> list = shoushouDao.findAllShuoShuo(userid, page.getFirstResult(), page.getMaxResults(),0);
        List<ContentData<Object>> content= new ArrayList<ContentData<Object>>();
		for(SaysShuoshuo ss:list)
		{
			ContentData<Object> conn = new ContentData<Object>();
			conn.setData(ss);
			//统计评论
			conn.setPinglunnum(commDao.CountComments(ss.getShuoid(), "1"));
			//统计转发
			conn.setZhuanfanum(relDao.countByRelayfromSaysRelay(ss.getShuoid()));
			//统计点赞
			conn.setDianzannum(likeDao.countByLikeforSaysLike(ss.getShuoid()));
			System.out.println("完了");
			content.add(conn);
			 if(ss.getShuonature()==1){
				 //如果状态时1（转载）查询转载自哪里，返回转载表的对象
				System.out.println("完了1");
			   System.out.println("shousou"+ss.getShuoid());
			   SaysRelay re=relDao.findByUseridAndRelayafterSaysRelay(userid, ss.getShuoid());
			    
			   if(re==null)
			   {
				   System.out.println("没有查到");
			   }
			   System.out.println("完了2");
			 conn.setRalaydate(re.getRelaytime());
			 //再利用转载表里被转载的用户ID查询用户信息
			 System.out.println("完了3");
			 List user=userDao.selectSaysuserbyid(re.getUseridare().getUserid());
			 System.out.println("完了4");
			 SaysUser user1=(SaysUser) user.get(0);
			 conn.setFromid(user1.getUserid());
			 conn.setFromname(user1.getUsername());
			 //利用转载表里被转载的项目ID查询源头信息
			 SaysShuoshuo ss1= shoushouDao.fingByID(re.getRelayfrom());
			 conn.setRalaycontent(ss1.getShuocontent());
			}
			
			
		}
		pagecount.setResult(content);
		
		
		
		
		return pagecount;
		 
	}

}
