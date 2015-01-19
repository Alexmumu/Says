package org.service;

import java.io.Serializable;

import org.entity.SaysComments;
import org.vo.Page;

public interface ISaysCommentsService {

	public SaysComments getComment(Serializable commentid);
	
	public Page<SaysComments> findComments(Serializable commentsforid,Page<SaysComments> page,String commentstatus);
	
	public Serializable addComments(SaysComments comm);
	
	public boolean deleteComments(SaysComments comm);
	
	
	
}
