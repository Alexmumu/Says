package org.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.dao.ISaysLikeDao;
import org.entity.SaysLike;
import org.hibernateUtil.AbstractBaseDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


/**
 * 2015/1/9
 * @author Eyser
 * 点赞表的SaysLikeImpl实现类继承AbstractBaseDao类的方法
 * 并实现ISaysLikeDao接口
 */
@Repository
public class SaysLikeDaoImpl extends AbstractBaseDao<SaysLike> implements
ISaysLikeDao {
	private static final String FINDBYLikefor_HQL="select sl from SaysLike sl where sl.likefor=?  order by sl.liketime desc";
	private static final String FINDBYUseridare_HQL="select sl from SaysLike sl where sl.useridare.userid=?  order by sl.liketime desc";
	
	private static final String FINDBYUSERID_HQL="select sl from SaysLike sl where sl.userid.userid=?  order by sl.liketime desc";
	private static final String FINDBYUSERIDToUseridareForLikeforSaysLike_HQL="select sl from SaysLike sl where sl.likefor=? and sl.userid.userid=? and sl.useridare.userid=? ";
	@Override
	public boolean saveSaysLike(SaysLike sl) throws DataAccessException {
		this.save(sl);
		return true;	
		
	}
	@Override
	public void deleteSaysLike(Serializable likeid) throws DataAccessException {
		this.deleteById(likeid);	
	}
	@Override
	public int countByUseridSaysLike(Serializable userid)
			throws DataAccessException {
			return this.countByHql(FINDBYUseridare_HQL,new Object[]{userid});
	}
	@Override
	public List<SaysLike> findByUseridareSaysLike(Serializable useridare)
			throws DataAccessException {
			@SuppressWarnings("unchecked")
			List<SaysLike> list=this.findByHql(FINDBYUseridare_HQL,new Object[]{useridare});
			return list;
	}
	@Override
	public int findByUseridToUseridareForLikeforSaysLike(
			Serializable likefor, Serializable userid, Serializable useridare)
			throws DataAccessException {
			return this.countByHql(FINDBYUSERIDToUseridareForLikeforSaysLike_HQL,new Object[]{likefor,userid,useridare});	
	}
	@Override
	public List<SaysLike> findByUseridSaysLike(Serializable userid)
			throws DataAccessException {
			@SuppressWarnings("unchecked")
			List<SaysLike> list=this.findByHql(FINDBYUSERID_HQL,new Object[]{userid});
			return list;
	}
	@Override
	public SaysLike findByUseridToUseridareForLikeforSaysLike1(
			Serializable likefor, Serializable userid, Serializable useridare)
			throws DataAccessException {
			return (SaysLike) this.findByHql(FINDBYUSERIDToUseridareForLikeforSaysLike_HQL,new Object[]{likefor,userid,useridare}).get(0);
	}
	@Override
	public int countByLikeforSaysLike(Serializable likefor)
			throws DataAccessException {
		return this.countByHql(FINDBYLikefor_HQL,new Object[]{likefor});
	
	}
	
	
	

	
	



	
	
}
