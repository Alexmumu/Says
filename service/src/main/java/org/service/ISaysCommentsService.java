package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysComments;
import org.springframework.dao.DataAccessException;
import org.vo.Page;

public interface ISaysCommentsService {

	public SaysComments getComment(Serializable commentid);
	
	public Page<SaysComments> findComments(Serializable commentsforid,Page<SaysComments> page,String commentstatus);
	
	public Serializable addComments(SaysComments comm);
	
	public boolean deleteComments(SaysComments comm);
	List<SaysComments> FindCommentsNopage(Serializable commentsforid,
			Serializable userid, Serializable useridare);
	
	
	
}
