package org.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dao.ISaysCommentsDao;
import org.dao.ISaysFrequestDao;
import org.dao.ISaysLikeDao;
import org.dao.ISaysMsgcenterDao;
import org.dao.ISaysPhotoDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysComments;
import org.entity.SaysFrequest;
import org.entity.SaysLike;
import org.entity.SaysMsgcenter;
import org.entity.SaysPhoto;
import org.entity.SaysRelay;
import org.entity.SaysRizhi;
import org.entity.SaysShuoshuo;
import org.service.AbstractBaseService;
import org.service.ISaysMsgcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.ContentData;
import org.vo.MsgDataVo;
import org.vo.Page;

@Service
public class SaysMsgcenterServiceImpl extends AbstractBaseService implements
		ISaysMsgcenterService {
	
	@Autowired
	private ISaysMsgcenterDao msgcenterDao;
	@Autowired
	private ISaysFrequestDao frequestDao;
	@Autowired
	private ISaysCommentsDao commDao;
	@Autowired
	private ISaysRelayDao relayDao;
	@Autowired
	private ISaysLikeDao likeDao;
	
	
	@Autowired
	private ISaysShouShousDao shuoshuoDao;
	@Autowired
	private ISaysRizhiDao rizhiDao;
	@Autowired
	private ISaysPhotoDao photoDao;
	
	
	

	@Override
	public Serializable addMsg(SaysMsgcenter msg) {
		Serializable i = null;
		if(msgcenterDao.hasMsg(msg.getMcid())){
			i = msgcenterDao.AddMsg(msg);
		}
		return i;
	}

	@Override
	public boolean deleteMsg(Serializable mcid) {
		try {
			msgcenterDao.deleteById(mcid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int findNewMsg(Serializable userid) {
		return msgcenterDao.FindNewMsg(userid);
	}

	@Override
	public Page<MsgDataVo> findMsgByUser(Serializable userid,
			Page<SaysMsgcenter> page) {
		Page<MsgDataVo> msgData = new Page<MsgDataVo>();
		List<SaysMsgcenter> list = msgcenterDao.FindMsgByUser(userid, page
				.getFirstResult(), page.getMaxResults());
		List<MsgDataVo> content = new ArrayList<MsgDataVo>();
		for(SaysMsgcenter msg:list){
			System.out.println(msg.getMctype());
			//好友申请
			if(msg.getMctype()==1){
				MsgDataVo msgda = new MsgDataVo();
				System.out.println("-------------项目ID:-------------");
				System.out.println(msg.getMcfromid());
				SaysFrequest frequest = frequestDao.loadByID(msg.getMcfromid());
				frequestDao.initialize(frequest.getFruser());
				String fromid = frequest.getFruser().getUserid();
				msgda.setData(frequest);
				msgda.setUserid((String)userid);
				msgda.setFromid(fromid);
				msgda.setMctype(msg.getMctype());
				msgda.setMcstatus(msg.getMcstatus());
				msgda.setMsctime(((SaysFrequest)msgda.getData()).getFrtime());
				msgda.setMsgcontent("");
				SaysFrequest frequest2 = (SaysFrequest)msgda.getData();
				frequest2.getFruserare().setUserid(null);
				frequestDao.initialize(frequest2.getFruser());
				content.add(msgda);
			}
			//项目被评论
			if(msg.getMctype()==2 || msg.getMctype()==5 || msg.getMctype()==8){
				MsgDataVo msgda = new MsgDataVo();
				SaysComments comm = commDao.loadByID(msg.getMcfromid());
				//说说被评论
				if(msg.getMctype()==2){
					comm.setUseridare(null);
					commDao.initialize(comm.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(comm.getUserid().getUserid());
					msgda.setData(shuoshuoDao.loadByID(comm.getCommentsforid()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(comm.getCommentdate());
					msgda.setMsgcontent(comm.getCommentcontent());
					content.add(msgda);
				}
				//日志被评论
				if(msg.getMctype()==5){
					comm.setUseridare(null);
					commDao.initialize(comm.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(comm.getUserid().getUserid());
					msgda.setData(rizhiDao.loadByID(comm.getCommentsforid()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(comm.getCommentdate());
					msgda.setMsgcontent(comm.getCommentcontent());
					SaysRizhi rizhi = (SaysRizhi)msgda.getData();
					rizhiDao.initialize(rizhi.getRizhitype());
					rizhi.getRizhitype().setUserid(null);
					rizhiDao.initialize(rizhi.getRizhiuserid());
					content.add(msgda);
				}
				//相片被评论
				if(msg.getMctype()==8){
					comm.setUseridare(null);
					commDao.initialize(comm.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(comm.getUserid().getUserid());
					msgda.setData(photoDao.loadByID(comm.getCommentsforid()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(comm.getCommentdate());
					msgda.setMsgcontent(comm.getCommentcontent());
					SaysPhoto photo = (SaysPhoto)msgda.getData();
					photoDao.initialize(photo.getAlbumid());
					photo.getAlbumid().setUserid(null);
					photoDao.initialize(photo.getUserid());
					content.add(msgda);
				}
			}
			//项目被转发
			if(msg.getMctype()==3 || msg.getMctype()==6 || msg.getMctype()==9){
				MsgDataVo msgda = new MsgDataVo();
				SaysRelay relay = relayDao.loadByID(msg.getMcfromid());
				//说说被转发
				if(msg.getMctype()==3){
					relay.getUseridare().setUserid(null);
					relayDao.initialize(relay.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(relay.getUserid().getUserid());
					msgda.setData(shuoshuoDao.loadByID(relay.getRelayfrom()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(relay.getRelaytime());
					msgda.setMsgcontent("");
					content.add(msgda);
				}
				//日志被转发
				if(msg.getMctype()==6){
					relay.getUseridare().setUserid(null);
					relayDao.initialize(relay.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(relay.getUserid().getUserid());
					msgda.setData(rizhiDao.loadByID(relay.getRelayfrom()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(relay.getRelaytime());
					msgda.setMsgcontent(((SaysRizhi)msgda.getData()).getRizhititle());
					SaysRizhi rizhi = (SaysRizhi)msgda.getData();
					rizhiDao.initialize(rizhi.getRizhitype());
					rizhi.getRizhitype().setUserid(null);
					rizhiDao.initialize(rizhi.getRizhiuserid());
					content.add(msgda);
				}
				//相片被转发
				if(msg.getMctype()==9){
					relay.getUseridare().setUserid(null);
					relayDao.initialize(relay.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(relay.getUserid().getUserid());
					msgda.setData(photoDao.loadByID(relay.getRelayfrom()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(relay.getRelaytime());
					msgda.setMsgcontent(((SaysPhoto)msgda.getData()).getPhotoremark());
					SaysPhoto photo = (SaysPhoto)msgda.getData();
					photoDao.initialize(photo.getAlbumid());
					photo.getAlbumid().setUserid(null);
					photoDao.initialize(photo.getUserid());
					content.add(msgda);
				}
			}
			//项目被赞
			if(msg.getMctype()==4 || msg.getMctype()==7 || msg.getMctype()==10){
				MsgDataVo msgda = new MsgDataVo();
				SaysLike like = likeDao.loadByID(msg.getMcfromid());
				//说说被赞
				if(msg.getMctype()==4){
					like.getUseridare().setUserid(null);
					likeDao.initialize(like.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(like.getUserid().getUserid());
					msgda.setData(shuoshuoDao.loadByID(like.getLikefor()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(like.getLiketime());
					msgda.setMsgcontent("");
					content.add(msgda);
				}
				//日志被赞
				if(msg.getMctype()==7){
					like.getUseridare().setUserid(null);
					likeDao.initialize(like.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(like.getUserid().getUserid());
					msgda.setData(rizhiDao.loadByID(like.getLikefor()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(like.getLiketime());
					msgda.setMsgcontent(((SaysRizhi)msgda.getData()).getRizhititle());
					SaysRizhi rizhi = (SaysRizhi)msgda.getData();
					rizhiDao.initialize(rizhi.getRizhitype());
					rizhi.getRizhitype().setUserid(null);
					rizhiDao.initialize(rizhi.getRizhiuserid());
					content.add(msgda);
				}
				//相片被赞
				if(msg.getMctype()==10){
					like.getUseridare().setUserid(null);
					likeDao.initialize(like.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(like.getUserid().getUserid());
					msgda.setData(photoDao.loadByID(like.getLikefor()));
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsctime(like.getLiketime());
					msgda.setMsgcontent(((SaysPhoto)msgda.getData()).getPhotoremark());
					SaysPhoto photo = (SaysPhoto)msgda.getData();
					photoDao.initialize(photo.getAlbumid());
					photo.getAlbumid().setUserid(null);
					photoDao.initialize(photo.getUserid());
					content.add(msgda);
				}
			}
		}
		msgData.setDataSum(msgcenterDao.CountMsg(userid));
		msgData.setResult(content);
		System.out.println(msgData.getDataSum());
		System.out.println(content.size());
		return msgData;
	}

}
