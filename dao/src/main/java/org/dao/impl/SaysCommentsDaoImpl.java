package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysCommentsDao;
import org.entity.SaysComments;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysCommentsDaoImpl extends AbstractBaseDao<SaysComments>
		implements ISaysCommentsDao {
	
	private static final String FIND_COMMENTS = "from SaysComments as comm where comm.commentsforid = ? and comm.commentstatus = ? order by comm.commentdate desc";
	private static final String FIND_COMMENT = "select count(*) from SaysComments as comm where comm.commentid = ?";
	private static final String COUNT_COMMENTS = "select count(*) from SaysComments as comm where comm.commentsforid = ? and comm.commentstatus = ?";
	private static final String FIND_COMMENTSNopage = "select  comm from SaysComments as comm where comm.commentsforid = ? and comm.userid.userid = ? and comm.useridare.userid=? order by comm.commentdate asc";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaysComments> FindComments(Serializable commentsforid,
			int firstResult, int maxResults,String commentstatus) throws DataAccessException {

		return this.findByHql(FIND_COMMENTS, firstResult, maxResults,new Object[]{ commentsforid,commentstatus});
		
	}

	@Override
	public Serializable AddComments(SaysComments comment)
			throws DataAccessException {

		return this.save(comment);
		
	}

	@Override
	public boolean HasComment(Serializable commentid)
			throws DataAccessException {

		if(this.countByHql(FIND_COMMENT,new Object[]{commentid})!=0){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public int CountComments(Serializable commentsforid,String commentstatus)
			throws DataAccessException {

		return this.countByHql(COUNT_COMMENTS, new Object[]{commentsforid,commentstatus});
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaysComments> FindCommentsNopage(Serializable commentsforid,
			Serializable userid, Serializable useridare)
			throws DataAccessException {
		return this.findByHql(FIND_COMMENTSNopage,new Object[]{commentsforid,userid,useridare});
		
	}

}
