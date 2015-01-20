package org.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dao.ISaysCommentsDao;
import org.dao.ISaysFrequestDao;
import org.dao.ISaysLeavewordDao;
import org.dao.ISaysLikeDao;
import org.dao.ISaysMsgcenterDao;
import org.dao.ISaysPhotoDao;
import org.dao.ISaysRelayDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysShouShousDao;
import org.entity.SaysAlbum;
import org.entity.SaysComments;
import org.entity.SaysFrequest;
import org.entity.SaysLeaveword;
import org.entity.SaysLike;
import org.entity.SaysMsgcenter;
import org.entity.SaysPhoto;
import org.entity.SaysRelay;
import org.entity.SaysRizhi;
import org.entity.SaysRizhitype;
import org.entity.SaysShuoshuo;
import org.entity.SaysUser;
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
	@Autowired
	private ISaysLeavewordDao leaveDao;
	
	
	

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
			SaysMsgcenter msg = msgcenterDao.getById(mcid);
			msg.setMcstatus(0);
			msgcenterDao.update(msg);
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
				SaysFrequest frequest = frequestDao.getById(msg.getMcfromid());
				System.out.println(frequest);
				String fromid = frequest.getFruser().getUserid();
				frequest.setFruserare(null);
				
				msgda.setData(frequest);
				msgda.setUserid((String)userid);
				msgda.setFromid(fromid);
				msgda.setMctype(msg.getMctype());
				msgda.setMcstatus(msg.getMcstatus());
				msgda.setMsgid(msg.getMcid());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = frequest.getFrtime();
				msgda.setMsctime(sdf.format(date));
				msgda.setMsgcontent("");
				content.add(msgda);
			}
			//项目被评论
			if(msg.getMctype()==2 || msg.getMctype()==5 || msg.getMctype()==8){
				MsgDataVo msgda = new MsgDataVo();
				SaysComments comm = commDao.getById(msg.getMcfromid());
				//说说被评论
				if(msg.getMctype()==2){
					SaysShuoshuo shuoshuo=  shuoshuoDao.getById(comm.getCommentsforid());
					System.out.println(shuoshuo);
					SaysUser user=new SaysUser();
					user.setUserid(shuoshuo.getUserid().getUserid());
					shuoshuo.setUserid(user);
					msgda.setData(shuoshuo);
					comm.setUseridare(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(comm.getUserid().getUserid());
					msgda.setFromname(comm.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(comm.getCommentcontent());
					content.add(msgda);
				}
				//日志被评论
				if(msg.getMctype()==5){
					SaysRizhi rizhi=rizhiDao.getById(comm.getCommentsforid());
					SaysRizhitype rizhitype = new SaysRizhitype();
					rizhitype.setTypeid(rizhi.getRizhitype().getTypeid());
					rizhitype.setTypename(rizhi.getRizhitype().getTypename());
					rizhitype.setUserid(null);
					rizhi.setRizhitype(rizhitype);
					SaysUser user = new SaysUser();
					user.setUserid(rizhi.getRizhiuserid().getUserid());
					user.setUsername(rizhi.getRizhiuserid().getUsername());
					user.setUserimg(rizhi.getRizhiuserid().getUserimg());
					rizhi.setRizhiuserid(user);
					msgda.setData(rizhi);
					comm.setUseridare(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(comm.getUserid().getUserid());
					msgda.setFromname(comm.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(comm.getCommentcontent());
					content.add(msgda);
				}
				//相片被评论
				if(msg.getMctype()==8){
					SaysPhoto photo = photoDao.getById(comm.getCommentsforid());
					SaysAlbum album = new SaysAlbum();
					album.setAlbumid(photo.getAlbumid().getAlbumid());
					album.setAlbumtitle(photo.getAlbumid().getAlbumtitle());
					album.setUserid(null);
					photo.setAlbumid(album);
					SaysUser user = new SaysUser();
					user.setUserid(photo.getUserid().getUserid());
					user.setUsername(photo.getUserid().getUsername());
					user.setUserimg(photo.getUserid().getUserimg());
					photo.setUserid(user);
					msgda.setData(photo);
					comm.setUseridare(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(comm.getUserid().getUserid());
					msgda.setFromname(comm.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(comm.getCommentcontent());
					content.add(msgda);
				}
			}
			//项目被转发
			if(msg.getMctype()==3 || msg.getMctype()==6 || msg.getMctype()==9){
				MsgDataVo msgda = new MsgDataVo();
				SaysRelay relay = relayDao.getById(msg.getMcfromid());
				//说说被转发
				if(msg.getMctype()==3){
					SaysShuoshuo shuoshuo=  shuoshuoDao.getById(relay.getRelayfrom());
					System.out.println(shuoshuo);
					SaysUser user=new SaysUser();
					user.setUserid(shuoshuo.getUserid().getUserid());
					user.setUsername(shuoshuo.getUserid().getUsername());
					user.setUserimg(shuoshuo.getUserid().getUserimg());
					shuoshuo.setUserid(user);
					msgda.setData(shuoshuo);
					relay.setUseridare(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(relay.getUserid().getUserid());
					msgda.setFromname(relay.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent("");
					content.add(msgda);
				}
				//日志被转发
				if(msg.getMctype()==6){
					SaysRizhi rizhi=rizhiDao.getById(relay.getRelayfrom());
					SaysRizhitype rizhitype = new SaysRizhitype();
					rizhitype.setTypeid(rizhi.getRizhitype().getTypeid());
					rizhitype.setTypename(rizhi.getRizhitype().getTypename());
					rizhitype.setUserid(null);
					rizhi.setRizhitype(rizhitype);
					SaysUser user = new SaysUser();
					user.setUserid(rizhi.getRizhiuserid().getUserid());
					user.setUsername(rizhi.getRizhiuserid().getUsername());
					user.setUserimg(rizhi.getRizhiuserid().getUserimg());
					rizhi.setRizhiuserid(user);
					msgda.setData(rizhi);
					relay.getUseridare().setUserid(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(relay.getUserid().getUserid());
					msgda.setFromname(relay.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(((SaysRizhi)msgda.getData()).getRizhititle());
					content.add(msgda);
				}
				//相片被转发
				if(msg.getMctype()==9){
					SaysPhoto photo = photoDao.getById(relay.getRelayfrom());
					SaysAlbum album = new SaysAlbum();
					album.setAlbumid(photo.getAlbumid().getAlbumid());
					album.setAlbumtitle(photo.getAlbumid().getAlbumtitle());
					album.setUserid(null);
					photo.setAlbumid(album);
					SaysUser user = new SaysUser();
					user.setUserid(photo.getUserid().getUserid());
					user.setUsername(photo.getUserid().getUsername());
					user.setUserimg(photo.getUserid().getUserimg());
					photo.setUserid(user);
					msgda.setData(photo);
					relay.getUseridare().setUserid(null);
					relayDao.initialize(relay.getUserid());
					msgda.setUserid((String)userid);
					msgda.setFromid(relay.getUserid().getUserid());
					msgda.setFromname(relay.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(((SaysPhoto)msgda.getData()).getPhotoremark());
					content.add(msgda);
				}
			}
			//项目被赞
			if(msg.getMctype()==4 || msg.getMctype()==7 || msg.getMctype()==10){
				MsgDataVo msgda = new MsgDataVo();
				SaysLike like = likeDao.getById(msg.getMcfromid());
				//说说被赞
				if(msg.getMctype()==4){
					SaysShuoshuo shuoshuo=  shuoshuoDao.getById(like.getLikefor());
					System.out.println(shuoshuo);
					SaysUser user=new SaysUser();
					user.setUserid(shuoshuo.getUserid().getUserid());
					user.setUsername(shuoshuo.getUserid().getUsername());
					user.setUserimg(shuoshuo.getUserid().getUserimg());
					shuoshuo.setUserid(user);
					msgda.setData(shuoshuo);
					like.getUseridare().setUserid(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(like.getUserid().getUserid());
					msgda.setFromname(like.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent("");
					content.add(msgda);
				}
				//日志被赞
				if(msg.getMctype()==7){
					SaysRizhi rizhi=rizhiDao.getById(like.getLikefor());
					SaysRizhitype rizhitype = new SaysRizhitype();
					rizhitype.setTypeid(rizhi.getRizhitype().getTypeid());
					rizhitype.setTypename(rizhi.getRizhitype().getTypename());
					rizhitype.setUserid(null);
					rizhi.setRizhitype(rizhitype);
					SaysUser user = new SaysUser();
					user.setUserid(rizhi.getRizhiuserid().getUserid());
					user.setUsername(rizhi.getRizhiuserid().getUsername());
					user.setUserimg(rizhi.getRizhiuserid().getUserimg());
					rizhi.setRizhiuserid(user);
					msgda.setData(rizhi);
					like.getUseridare().setUserid(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(like.getUserid().getUserid());
					msgda.setFromname(like.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(((SaysRizhi)msgda.getData()).getRizhititle());
					content.add(msgda);
				}
				//相片被赞
				if(msg.getMctype()==10){
					SaysPhoto photo = photoDao.getById(like.getLikefor());
					SaysAlbum album = new SaysAlbum();
					album.setAlbumid(photo.getAlbumid().getAlbumid());
					album.setAlbumtitle(photo.getAlbumid().getAlbumtitle());
					album.setUserid(null);
					photo.setAlbumid(album);
					SaysUser user = new SaysUser();
					user.setUserid(photo.getUserid().getUserid());
					user.setUsername(photo.getUserid().getUsername());
					user.setUserimg(photo.getUserid().getUserimg());
					photo.setUserid(user);
					msgda.setData(photo);
					like.getUseridare().setUserid(null);
					msgda.setUserid((String)userid);
					msgda.setFromid(like.getUserid().getUserid());
					msgda.setFromname(like.getUserid().getUsernickname());
					msgda.setMctype(msg.getMctype());
					msgda.setMcstatus(msg.getMcstatus());
					msgda.setMsgid(msg.getMcid());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = msg.getMsctime();
					msgda.setMsctime(sdf.format(date));
					msgda.setMsgcontent(((SaysPhoto)msgda.getData()).getPhotoremark());
					content.add(msgda);
				}
			}
			if(msg.getMctype()==11){
				MsgDataVo msgda = new MsgDataVo();
				SaysLeaveword leaveword = leaveDao.getById(msg.getMcfromid());
				SaysUser user = new SaysUser();
				user.setUserid(leaveword.getUserid().getUserid());
				user.setUsername(leaveword.getUserid().getUsername());
				leaveword.setUserid(user);
				SaysUser fromuserid=new SaysUser();
				fromuserid.setUserid(leaveword.getFromuserid().getUserid());
				fromuserid.setUsernickname(leaveword.getFromuserid().getUsernickname());
				leaveword.setFromuserid(fromuserid);
				msgda.setData(leaveword);
				msgda.setFromid(leaveword.getFromuserid().getUserid());
				msgda.setFromname(leaveword.getFromuserid().getUsernickname());
				msgda.setMctype(msg.getMctype());
				msgda.setMcstatus(msg.getMcstatus());
				msgda.setMsgid(msg.getMcid());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = msg.getMsctime();
				msgda.setMsctime(sdf.format(date));
				content.add(msgda);
			}
		}
		msgData.setDataSum(msgcenterDao.CountMsg(userid));
		msgData.setResult(content);
		System.out.println(msgData.getDataSum());
		System.out.println(content.size());
		return msgData;
	}

}
