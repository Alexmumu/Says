package org.service;

import java.io.Serializable;

import org.entity.SaysComments;
import org.vo.Page;

public interface ISaysCommentsService {

	public SaysComments GetComment(Serializable commentid);
	
	public Page<SaysComments> FindComments(Serializable commentsforid,Page<SaysComments> page,String commentstatus);
	
	public Serializable AddComments(SaysComments comm);
	
	public boolean DeleteComments(SaysComments comm);
	
	
	
}
