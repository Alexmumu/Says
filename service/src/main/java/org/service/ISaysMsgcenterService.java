package org.service;

import java.io.Serializable;

import org.entity.SaysMsgcenter;
import org.vo.Page;

public interface ISaysMsgcenterService {

	public Page<SaysMsgcenter> FindMsgByUser(Serializable userid,Page<SaysMsgcenter> page);
	
	public Serializable AddMsg(SaysMsgcenter msg);
	
	public int FindNewMsg(Serializable userid);
	
	public boolean DeleteMsg(Serializable mcid);
}
