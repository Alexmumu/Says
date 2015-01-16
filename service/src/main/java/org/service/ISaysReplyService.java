package org.service;

import java.io.Serializable;

import org.entity.SaysReply;
import org.vo.Page;

public interface ISaysReplyService {

	public Page<SaysReply> findReplybyCommentid(Serializable commentid,Page<SaysReply> page,int replystatus);
	
	public Page<SaysReply> findReplybyReplyare(Serializable replyare,Page<SaysReply> page,int replystatus); 
	
	public  Serializable addReply(SaysReply reply);
	
	public boolean deleteReply(SaysReply reply);
	
	public SaysReply getReply(Serializable replyid);
}
