package org.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysMsgcenterDao;
import org.entity.SaysMsgcenter;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class SaysMsgcenterDaoImpl extends AbstractBaseDao<SaysMsgcenter>
		implements ISaysMsgcenterDao {

	private static final String FIND_MSGBYUSER = "from SaysMsgcenter as msg where msg.userid.userid = ? order by msg.msctime desc";
	private static final String FIND_NEWMSG = "select count(*) from SaysMsgcenter as msg where msg.userid.userid = ? and msg.mcstatus = 1";
	private static final String FIND_MSG = "select count(*) from SaysMsgcenter as msg where msg.mcid = ?";
	private static final String COUNT_MSG = "select count(*) from SaysMsgcenter as msg where msg.userid.userid = ?";
	
	@SuppressWarnings("unchecked")
	public List<SaysMsgcenter> FindMsgByUser(Serializable userid,
			int firstResult, int maxResults) throws DataAccessException {
		
		return this.findByHql(FIND_MSGBYUSER,firstResult,maxResults,new Object[]{userid});
		
	}

	public int FindNewMsg(Serializable userid) throws DataAccessException {

		return this.countByHql(FIND_NEWMSG,new Object[]{userid});
		
	}

	public Serializable AddMsg(SaysMsgcenter msg) throws DataAccessException {

		return this.save(msg);
	}

	public boolean hasMsg(Serializable mcid) throws DataAccessException {
		
		if(this.countByHql(FIND_MSG,new Object[]{mcid})!=0){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public int CountMsg(Serializable userid) throws DataAccessException {

		return this.countByHql(COUNT_MSG,new Object[]{userid});
		
	}

	

}
