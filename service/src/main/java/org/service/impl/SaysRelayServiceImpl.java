package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysAlbumDao;
import org.dao.ISaysMsgcenterDao;
import org.dao.ISaysNewsDao;
import org.dao.ISaysPhotoDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysRizhitypeDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysAlbum;
import org.entity.SaysComments;
import org.entity.SaysLeaveword;
import org.entity.SaysMsgcenter;
import org.entity.SaysNews;
import org.entity.SaysPhoto;
import org.entity.SaysRelay;
import org.entity.SaysReply;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
import org.service.ISaysAlbumService;
import org.service.ISaysPhotoService;
import org.service.ISaysRelayService;
import org.service.ISaysRizhitypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;
@Service
public class SaysRelayServiceImpl implements ISaysRelayService{
	@Autowired
	private ISaysRelayDao saysRelayDao;
	@Autowired
	private ISaysAlbumDao alDao;
	@Autowired
	private ISaysPhotoDao photoDao;
	@Autowired
	private ISaysRizhiDao rizhiDao;
	@Autowired
	private ISaysRizhitypeDao rizhitypeDao;
	@Autowired
	private ISaysNewsDao newsDao;
	@Autowired
	private ISaysMsgcenterDao mctDao;
	@Autowired
	private ISaysShouShousDao ssDao;
	
	@Override
	public Serializable saveSaysRelay(SaysRelay ar) {
		return this.saysRelayDao.save(ar);
		
	}

	@Override
	public void deleteSaysRelay(Serializable relayid) {
		this.saysRelayDao.deleteSaysRelay(relayid);
		
	}

	@Override
	public int countByUseridSaysRelay(Serializable userid) {
		
		return this.saysRelayDao.countByUseridSaysRelay(userid);
	}

	@Override
	public List<SaysRelay> findByUseridSaysRelay(Serializable userid) {
		// TODO Auto-generated method stub
		return this.saysRelayDao.findByUseridSaysRelay(userid);
	}

	@Override
	public int countByRelayfromSaysRelay(Serializable relayfrom) {
		return this.saysRelayDao.countByRelayfromSaysRelay(relayfrom);
	}

	@Override
	public int countByRelayafterSaysRelay(Serializable relayafter) {
		return this.saysRelayDao.countByRelayfromSaysRelay(relayafter);
	}

	@Override
	public int countByRelayFromAndUseridAndUseridareSaysRelay(Serializable relayfrom,
			Serializable userid, Serializable useridare) {
		return this.saysRelayDao.countByRelayFromAndUseridAndUseridareSaysRelay(relayfrom, userid, useridare);
	}

	@Override
	public int countByRelayFromAndUseridareSaysRelay(Serializable relayfrom,
			Serializable useridare) {
		 return this.saysRelayDao.countByRelayFromAndUseridareSaysRelay(relayfrom, useridare);
		
	}

	@Override
	public Page<SaysRelay> findCommentsByPage(Serializable relayfrom,
			Page<SaysRelay> page) {
		page.setDataSum(saysRelayDao.countByRelayfromSaysRelay(relayfrom));
		List<SaysRelay> list = saysRelayDao.FindSaysRelayByPage(relayfrom, page.getFirstResult(), page.getMaxResults());
		page.setResult(list);
		for(SaysRelay sl:list){
			//sl.setUserid(null);
			saysRelayDao.initialize(sl.getUserid());
			saysRelayDao.initialize(sl.getUseridare());
		}
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
		
	}

	public SaysRelay findByUseridAndRelayafterSaysRelay(
			Serializable userid, Serializable relayafter) {
		SaysRelay sr=this.saysRelayDao.findByUseridAndRelayafterSaysRelay(userid, relayafter);
		sr.setUserid(null);
		System.out.println(sr.getRelayfor());
		//saysRelayDao.initialize(sr.getUserid().getUserid());
		saysRelayDao.initialize(sr.getUseridare());
		return sr;
			
	
	}
	
	/**
	 * type     1.说说  2.日志  3.相片 	 * 
	 */
	@Override
	public boolean addRelay(SaysRelay sr, int type, SaysUser myuser,
			String alorrtypeId) {
		if(type==1){
			//获取要被转发的那条说说
			SaysShuoshuo fromshuoshuo=ssDao.getById(sr.getRelayfrom());
			//判断要转发的那条说说的状态，如果是已经删除的话 那么不能转发了 抛出异常
			if(fromshuoshuo.getShuostatus()==0){
				throw new RuntimeException("此说说的已被删除");
			}
			
			//新建一个说说 设置相应的属性
			SaysShuoshuo shuoshuo=new SaysShuoshuo();
			shuoshuo.setShuonature(1);
			shuoshuo.setShuostatus(1);
			shuoshuo.setUserid(myuser);
			//将说说保存 并获取他的id
			Serializable shuoli=this.ssDao.save(shuoshuo);
			//设置转发对象中被转发的另一个项目id
			sr.setRelayafter(shuoli.toString());
			
			//添加转发转载表 并获取id
			Serializable srli=this.saysRelayDao.save(sr);
			
			//添加消息表记录 向被转发的项目主人 推送消息
			SaysMsgcenter msg=new SaysMsgcenter();
			msg.setUserid(sr.getUseridare());
			msg.setMcfromid(srli.toString());
			msg.setMctype(3);
			msg.setMcstatus(1);
			this.mctDao.save(msg);
				
			//添加动态表记录
			SaysNews sn=new SaysNews();
			sn.setNewscontent(shuoli.toString());
			sn.setUserid(myuser);
			sn.setNewsstatus(2);
			this.newsDao.save(sn);
			
			
			
			return true;
		}else if(type==2){
			//获取要被转发的那个日志
			SaysRizhi rizhi=this.rizhiDao.getById(sr.getRelayfrom());
			//创建一个新的日志
			SaysRizhi newrizhi=new SaysRizhi();
			//获取即将要被存放的日志类型 并设置到那个新日志
			SaysRizhitype rizhitype=this.rizhitypeDao.getById(alorrtypeId);
			newrizhi.setRizhitype(rizhitype);
			newrizhi.setRizhititle(rizhi.getRizhititle());
			newrizhi.setRizhicontent(rizhi.getRizhicontent());
			newrizhi.setRizhiuserid(myuser);
			newrizhi.setRizhistatus(1);
			newrizhi.setRizhinature(1);
			
			//将日志存入 并获取他的返回id
			Serializable newrizhili =this.rizhiDao.save(newrizhi);
			
			//在转载表添加相应的记录 并获取返回的id
			sr.setRelayafter(newrizhili.toString());
			Serializable srli= this.saysRelayDao.save(sr);
			
			//在消息表添加相应的记录
			SaysMsgcenter msg=new SaysMsgcenter();
			msg.setUserid(sr.getUseridare());
			msg.setMcfromid(srli.toString());
			msg.setMctype(6);
			msg.setMcstatus(1);
			this.mctDao.save(msg);
			
			//添加动态表记录
			SaysNews sn=new SaysNews();
			sn.setNewscontent(newrizhili.toString());
			sn.setUserid(myuser);
			sn.setNewsstatus(4);
			this.newsDao.save(sn);


			return true;
		}else if(type==3){
			//获取要转发的那个相片
			SaysPhoto sp=this.photoDao.getById(sr.getRelayfrom());
			//新建一个相片
			SaysPhoto newsp=new SaysPhoto();
			//获取即将要存放的那个相册
			SaysAlbum al=this.alDao.getById(alorrtypeId);
			//将被转发的相片相关属性设置到新建的相片对象中
			newsp.setPhotosrc(sp.getPhotosrc());
			newsp.setPhotoremark(sp.getPhotoremark());
			newsp.setUserid(myuser);
			newsp.setAlbumid(al);
			newsp.setPhototype(1);
			newsp.setPhotostatus("1");
			
			//把这个相片存入到数据库 并获取返回的id
			Serializable newspli=this.photoDao.save(newsp);
			//在转载表添加相应的记录 并获取返回的id
			sr.setRelayafter(newspli.toString());
			Serializable srli= this.saysRelayDao.save(sr);
			
			//在消息表添加相应的记录 
			SaysMsgcenter msg=new SaysMsgcenter();
			msg.setUserid(sr.getUseridare());
			msg.setMcfromid(srli.toString());
			msg.setMctype(9);
			msg.setMcstatus(1);
			this.mctDao.save(msg);
			
			//添加动态表记录
			SaysNews sn=new SaysNews();
			sn.setNewscontent(newspli.toString());
			sn.setUserid(myuser);
			sn.setNewsstatus(6);
			this.newsDao.save(sn);

			return true;
		}
		return false;
	}

}
