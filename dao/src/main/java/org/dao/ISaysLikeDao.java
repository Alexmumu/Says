package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysLike;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;


/**
 * 2015/1/8
 * @author Eyser 
 * 点赞表的ISaysLikeDao接口继承IBaseDao基本方法
 */
public interface ISaysLikeDao extends IBaseDao<SaysLike> {
	/**
	 * 给好友点赞
	 * @return 
	 * @throws DataAccessException
	 */
	 public boolean saveSaysLike(SaysLike sl)throws DataAccessException;
	/**
	 * 取消好友点赞
	 * @throws DataAccessException
	 */
	 public void deleteSaysLike(Serializable likeid)throws DataAccessException;
	
	 /**
	  * 查询被点赞数量
	  * @return
	  * @throws DataAccessException
	  */
	 public int countByUseridSaysLike(Serializable userid)throws DataAccessException;
	 /**
	  * 通过所属用户id查看点赞用户
	  * @param userid
	  * @return
	  * @throws DataAccessException
	  */
	 public List<SaysLike> findByUseridareSaysLike(Serializable useridare)throws DataAccessException;
	 
	 public int findByUseridToUseridareForLikeforSaysLike(Serializable likefor,Serializable userid,Serializable useridare)throws DataAccessException;
	 public List<SaysLike> findByUseridSaysLike(Serializable userid) throws DataAccessException;
	 /**
	  * 引用 -----根据留言id查询
	  * @param likefor
	  * @param userid
	  * @param useridare
	  * @return
	  * @throws DataAccessException
	  */
	 public SaysLike findByUseridToUseridareForLikeforSaysLike1(Serializable likefor,Serializable userid,Serializable useridare)throws DataAccessException;
}
