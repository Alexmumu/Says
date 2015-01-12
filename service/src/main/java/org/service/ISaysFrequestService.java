package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysFrequest;
import org.entity.SaysFriends;
import org.hibernateUtil.IBaseDao;
import org.springframework.dao.DataAccessException;
import org.vo.Page;

public interface ISaysFrequestService {
	
	/**
	 * 添加一条好友申请记录到好友申请表
	 * @param saysfrequest
	 * @throws DataAccessException
	 */
	public Serializable addnewSaysFrequest(SaysFrequest saysfrequest)throws DataAccessException;
	
	/**
	 * 删除好友申请记录
	 * @param frid
	 * @return
	 * @throws DataAccessException
	 */
	public boolean deletedSaysFrequestbyfrid(String frid)throws DataAccessException;
	
	/**
	 * 根据申请人id查询所有申请记录并分页
	 * @param fruser 申请人id
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws DataAccessException
	 */
	public Page<SaysFrequest> selectSaysFrequestall(Serializable data,Page<SaysFrequest> page)throws DataAccessException;
	

	/**
	 * 根据申请表id，查询出该记录详细信息
	 * @param frid
	 * @throws DataAccessException
	 */
	public List selectSaysFrequestbyid(String frid)throws DataAccessException;
	
	/**
	 * 修改申请记录状态
	 * @param saysfrequest
	 * @throws DataAccessException
	 */
	public void updateSaysFrequestbyfrstatus(SaysFrequest saysfrequest)throws DataAccessException;

	
	/**
	 * 根据申请人id查询出所有申请记录的数量
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
	public List selectbyfruerandfruserare2(String fruser,String fruserare)throws DataAccessException;

}
