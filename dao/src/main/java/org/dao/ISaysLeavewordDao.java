package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysLeaveword;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;


/**
 * 2015/1/9
 * @author Eyser
 * 留言表的ISaysLeavewordDao接口继承IBaseDao基本方法
 */
public interface ISaysLeavewordDao extends IBaseDao<SaysLeaveword>{
	/**
	 * 按时间倒序分页查看
	 * @param firstResult 第一页
	 * @param maxResults 最大页数
	 * @param orderBy 排序方式
	 * @param isAsc true为正序 false为倒序
	 * @return 留言内容的集合
	 * @throws DataAccessException
	 */
	public List<SaysLeaveword> findSaysLeavewords(int firstResult,int maxResults, Serializable userid, Serializable levewodidstatus)
	throws DataAccessException;
	
	/**
	 * 查询留言板的所有留言总数
	 * @return
	 * @throws DataAccessException
	 */
	 public int countAllSaysLeaveword(Serializable userid,Serializable levewodidstatus)throws DataAccessException;
	 
	/**
	 * 添加一条留言
	 * @param lw 留言的对象
	 * @throws DataAccessException
	 */
	 public void saveSaysLeaveword(SaysLeaveword lw)throws DataAccessException;
	 
	/**
	 * 删除留言信息
	 * @throws DataAccessException
	 */
	public void deleteSaysLeaveword(Serializable leavewordid)throws DataAccessException;
	
	
	public SaysLeaveword findByLeavewordidSaysLeaveword(Serializable leavewordid) throws DataAccessException;
}
