package org.service;

import java.io.Serializable;

import org.entity.SaysMsgcenter;
import org.vo.ContentData;
import org.vo.MsgDataVo;
import org.vo.Page;

public interface ISaysMsgcenterService {

	public Page<MsgDataVo> findMsgByUser(Serializable userid,Page<SaysMsgcenter> page);
	
	public Serializable addMsg(SaysMsgcenter msg);
	
	public int findNewMsg(Serializable userid);
	
	public boolean deleteMsg(Serializable mcid);
}
