package org.dao;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysFrequest;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;

public interface ISaysFrequestDao extends IBaseDao<SaysFrequest> {

	/**
	 * 1.方法：添加一条好友申请记录到好友申请表
	 * @param saysfrequest
	 * @throws DataAccessException
	 */
	public Serializable addSaysFrequest(SaysFrequest saysfrequest)throws DataAccessException;

	
	/**
	 * 2.方法：根据申请表id删除一条好友申请记录
	 * @param fruser 申请id
	 * @throws DataAccessException
	 */
	public boolean deletedSaysFrequest(String frid)throws DataAccessException;

	
	/**
	 * 3.方法：修改申请记录状态
	 * @param saysfrequest
	 * @throws DataAccessException
	 */
	public void updateSaysFrequest(SaysFrequest saysfrequest)throws DataAccessException;


	/**
	 * 4.方法：根据申请人id查询出其所有申请记录信息并分页
	 * @param fruser 申请人id
	 * @param firstResult 第一页
	 * @param maxResults 最后页
	 * @return
	 * @throws DataAccessException
	 */
	public List<SaysFrequest> selectSaysFrequest(Serializable fruser, int firstResult,int maxResults)throws DataAccessException;

	/**
	 * 5.方法：根据申请表id，查询出该记录详细信息
	 * @param frid 申请表id
	 * @throws DataAccessException
	 */
	public List selectSaysFrequest2(String frid)throws DataAccessException;

	
	/**
	 * 6.根据申请人id，查询出该用户好友的数量
	 * @param fruser 申请人id
	 * @return
	 * @throws DataAccessException
	 */
	public int countSaysFrequest(Serializable fruser)throws DataAccessException;
	
	/**
	 * 7.根据申请人的id和被申请人的id，查出该条记录的信息
	 * @param fruser
	 * @param fruserare
	 * @return
	 * @throws DataAccessException
	 */
	public List selectbyfruerandfruserare(String fruser,String fruserare)throws DataAccessException;

}
