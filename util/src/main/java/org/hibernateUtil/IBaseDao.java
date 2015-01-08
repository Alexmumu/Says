package org.hibernateUtil;


import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * 一般Dao所需要继承的接口，定义了一般常用的方法
 * 
 * @author ipengyo QQ:4636648 2014年12月17日
 * 
 * @param <T>
 */
public interface IBaseDao<T> {
	// -------------------------------------------------------------------------
	// 增删改，根据ID获取 立即加载
	// -------------------------------------------------------------------------

	public Serializable save(T entity) throws DataAccessException;
	
	/**
	 * 批量删除
	 * @param entitys
	 * @return
	 * @throws DataAccessException
	 */
	public List<Serializable> save(T...entitys)throws DataAccessException;

	void delete(T entity) throws DataAccessException;

	void deleteById(Serializable id) throws DataAccessException;
	
	void deleteById(Serializable...ids)throws DataAccessException;
	
	public void update(T entity) throws DataAccessException;//

	public void saveOrUpdate(T entity) throws DataAccessException;

	public T getById(Serializable id) throws DataAccessException;
	
	public T loadByID(Serializable id)throws DataAccessException;
	
	public void initialize(Object entity)throws DataAccessException;
	

	// -------------------------------------------------------------------------
	// 查询所有的各种重载（分页，排序[升序,降序]） 获取总数
	// -------------------------------------------------------------------------

	public List<T> findAll() throws DataAccessException;

	public List<T> findAll(int firstResult, int maxResults) throws DataAccessException;

	public List<T> findAll(String orderBy, Boolean isAsc)
			throws DataAccessException;

	public List<T> findAll(int pageNo, int firstResult, String maxResults,
			Boolean isAsc) throws DataAccessException;

	public int countAll() throws DataAccessException;

	// -------------------------------------------------------------------------
	// 根据Example查询各种重载（分页，排序[升序,降序]）获取总数
	// -------------------------------------------------------------------------

	public List<T> findByExample(T exampleEntity) throws DataAccessException;

	public List<T> findByExample(T exampleEntity, int firstResult, int maxResults)
			throws DataAccessException;

	public List<T> findByExample(T exampleEntity, String orderBy, Boolean isAsc)
			throws DataAccessException;

	public List<T> findByExample(T exampleEntity, int firstResult, int maxResults,
			String orderBy, Boolean isAsc) throws DataAccessException;

	public int countByExample(T exampleEntity) throws DataAccessException;

}
