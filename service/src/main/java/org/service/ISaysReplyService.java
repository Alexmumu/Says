package org.service;

import java.io.Serializable;

import org.entity.SaysReply;
import org.vo.Page;

public interface ISaysReplyService {

	public Page<SaysReply> FindReplybyCommentid(Serializable commentid,Page<SaysReply> page,int replystatus);
	
	public Page<SaysReply> FindReplybyReplyare(Serializable replyare,Page<SaysReply> page,int replystatus); 
	
	public  Serializable AddReply(SaysReply reply);
	
	public boolean DeleteReply(SaysReply reply);
	
	public SaysReply GetReply(Serializable replyid);
}
