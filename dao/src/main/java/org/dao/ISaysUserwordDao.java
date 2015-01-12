package org.dao;

import java.io.Serializable;

import org.entity.SaysUserword;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;


/**
 * 2015/1/8
 * @author Eyser
 * 留言主人寄语表的ISaysUserwordDao接口继承IBaseDao基本方法
 */
public interface ISaysUserwordDao extends IBaseDao<SaysUserword>{
	
	/**
	 * 保存留言板主人寄语
	 * @throws DataAccessException
	 */
	public void saveSaysUserword(SaysUserword suw) throws DataAccessException;
	/**
	 * 按userwordid修改留言板主人寄语
	 * @throws DataAccessException
	 */
	public void updateSaysUserword(SaysUserword saysUserword) throws DataAccessException;
	
	/**
	 * 按userid查询留言板寄语
	 * @param userid 所属用户Id
	 * @return SaysUserword
	 * @throws DataAccessException
	 */
	public SaysUserword findSaysUserwordByUserId(Serializable userid) throws DataAccessException;
	public int findSaysUserwordByUserId1(Serializable userid) throws DataAccessException;
}
