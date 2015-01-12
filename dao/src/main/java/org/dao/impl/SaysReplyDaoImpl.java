package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysReplyDao;
import org.entity.SaysReply;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysReplyDaoImpl extends AbstractBaseDao<SaysReply> implements
		ISaysReplyDao {
	
	private static final String FIND_REPLYBYCOMMENTID = "from SaysReply as reply where reply.commentid.commentid = ? and reply.replystatus = ? order by reply.replydate asc";
	private static final String FINF_REPLYBYREPLYARE = "from SaysReply as reply where reply.replyare = ? and reply.replystatus = ? order by reply.replydate asc";
	private static final String FIND_REPLY = "select count(*) from SaysReply as reply where reply.replyid = ?";
	private static final String COUNT_REPLYBYCOMMENTID = "select count(*) from SaysReply as reply where reply.commentid.commentid = ? and reply.replystatus = ?";
	private static final String COUNT_REPLYBYREPLYARE = "select count(*) from SaysReply as reply where reply.replyid = ? and reply.replystatus = ?";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysReply> FindReplybyCommentid(Serializable commentid, int firstResult,
			int maxResults,int replystatus) throws DataAccessException {

		return this.findByHql(FIND_REPLYBYCOMMENTID, firstResult, maxResults, new Object[]{commentid,replystatus});
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaysReply> FindReplybyReplyare(Serializable replyare,
			int firstResult, int maxResults,int replystatus) throws DataAccessException {

		return this.findByHql(FINF_REPLYBYREPLYARE, firstResult, maxResults, new Object[]{replyare,replystatus});
		
	}

	@Override
	public Serializable AddReply(SaysReply reply) throws DataAccessException {

		return this.save(reply);
		
	}

	@Override
	public boolean HasReply(Serializable replyid) throws DataAccessException {

		if(this.countByHql(FIND_REPLY,new Object[]{replyid})!=0){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public int CountReplybyCommentid(Serializable commentid,int replystatus)
			throws DataAccessException {

		return this.countByHql(COUNT_REPLYBYCOMMENTID, new Object[]{commentid,replystatus});
		
	}

	@Override
	public int CountReplybyReplyare(Serializable replyare,int replystatus)
			throws DataAccessException {

		return this.countByHql(COUNT_REPLYBYREPLYARE, new Object[]{replyare,replystatus});
		
	}

}
