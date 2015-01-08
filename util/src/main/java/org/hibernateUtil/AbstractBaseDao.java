package org.hibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;

public abstract class AbstractBaseDao<T> extends MyHibernateDaoSupport implements
		IBaseDao<T> {
	// 子类的泛型class
	private Class<?> myClass;

	/**
	 * 获取子类继承超类所实现的泛型T
	 * 
	 * @return 泛型
	 */
	public Class<?> getTClass() {
		if (myClass != null) {
			return myClass;
		}
		// 获取超类的type
		Type type = this.getClass().getGenericSuperclass();
		// 判断此type 类型是否属于ParameterizedType 如果不是 就返回object的class
		// ParameterizedType 表示参数化类型，如 Collection<String>。 带泛型的type
		if ((type instanceof ParameterizedType) == false) {
			return Object.class;
		}
		// type强行向下转型为ParameterizedType 然后 返回表示此类型实际类型参数的 Type 对象的数组。
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();

		if (types.length == 0) {
			throw new RuntimeException("动态获取当前类泛型错误");
		}
		return (Class<?>) types[0];
	}

	public AbstractBaseDao() {
		super();
		myClass = getTClass();
	}

	// -------------------------------------------------------------------------
	// 查询所有的各种重载（分页，排序[升序,降序]） 获取总数
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#findAll()
	 */
	public List<T> findAll() throws DataAccessException {
		return this.findAll(-1, -1, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#findAll(java.lang.String,
	 * java.lang.Boolean)
	 */
	public List<T> findAll(String orderBy, Boolean isAsc)
			throws DataAccessException {
		return this.findAll(-1, -1, orderBy, isAsc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#findAll(int, int)
	 */
	public List<T> findAll(int firstResult, int maxResults)
			throws DataAccessException {
		return this.findAll(firstResult, maxResults, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#findAllByPage(int, int)
	 */
	public List<T> findAll(final int firstResult, final int maxResults,
			final String orderBy, final Boolean isAsc)
			throws DataAccessException {
		return this
				.findByExample(null, firstResult, maxResults, orderBy, isAsc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#countAll()
	 */
	public int countAll() throws DataAccessException {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Object i = (Object) session.createCriteria(myClass)
						.setProjection(
								Projections.projectionList().add(
										Projections.rowCount())).uniqueResult();
				return Integer.valueOf(i.toString());
			}
		});
	}

	// -------------------------------------------------------------------------
	// 根据Example查询各种重载（分页，排序[升序,降序]） 获取总数
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#findByExample(java.lang.Object)
	 */
	public List<T> findByExample(T exampleEntity) throws DataAccessException {
		return this.findByExample(exampleEntity, -1, -1, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#findByExample(java.lang.Object,
	 * java.lang.String, java.lang.Boolean)
	 */
	public List<T> findByExample(T exampleEntity, String orderBy, Boolean isAsc)
			throws DataAccessException {
		return findByExample(exampleEntity, -1, -1, orderBy, isAsc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#findByExampleAndPage(java.lang
	 * .Object, int, int)
	 */
	public List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) throws DataAccessException {
		return findByExample(exampleEntity, firstResult, maxResults, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#findByExample(java.lang.Object,
	 * int, int, java.lang.String, java.lang.Boolean)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(final T exampleEntity, final int firstResult,
			final int maxResults, final String orderBy, final Boolean isAsc)
			throws DataAccessException {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<T>>() {
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(myClass);

						if (exampleEntity != null) {
							criteria.add(Example.create(exampleEntity));
						}

						if (isAsc != null && null != orderBy
								&& orderBy.length() > 0) {
							if (isAsc) {
								criteria.addOrder(Order.asc(orderBy));
							} else {
								criteria.addOrder(Order.desc(orderBy));
							}
						}
						if (firstResult >= 0) {
							criteria.setFirstResult(firstResult);
						}
						if (maxResults > 0) {
							criteria.setMaxResults(maxResults);
						}

						return criteria.list();

					}
				});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#countByExample()
	 */
	public int countByExample(final T exampleEntity) throws DataAccessException {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(myClass)
						.setProjection(
								Projections.projectionList().add(
										Projections.rowCount())).add(
								Example.create(exampleEntity));
				return Integer.valueOf(criteria.uniqueResult().toString());
			}
		});
	}

	// -------------------------------------------------------------------------
	// 增删改，根据ID获取
	// -------------------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#getById(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T getById(Serializable id) throws DataAccessException {
		return (T) getHibernateTemplate().get(myClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#save(java.lang.Object)
	 */
	public Serializable save(T entity) throws DataAccessException {
		// TODO Auto-generated method stub
		return getHibernateTemplate().save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T entity) throws DataAccessException {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#update(java.lang.Object)
	 */
	public void update(T entity) throws DataAccessException {
		getHibernateTemplate().update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#delete(java.lang.Object)
	 */
	public void delete(T entity) throws DataAccessException {
		getHibernateTemplate().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#deleteById(java.io.Serializable
	 * )
	 */
	public void deleteById(Serializable id) throws DataAccessException {
		this.delete(this.getById(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#loadByID(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T loadByID(Serializable id) throws DataAccessException {
		return (T) getHibernateTemplate().load(myClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hyp.common.hibernate.suppory.IBaseDao#initialize(java.lang.Object)
	 */
	public void initialize(Object entity) throws DataAccessException {
		getHibernateTemplate().initialize(entity);
	}

	/**
	 * 批量删除
	 * 
	 * @see com.hyp.common.hibernate.suppory.IBaseDao#deleteById(java.io.Serializable[])
	 */
	public void deleteById(Serializable... ids) throws DataAccessException {
		for (int i = 0; i < ids.length; i++) {
			getHibernateTemplate().delete(this.getById(ids[i]));
			if (i % 20 == 0) {
				getHibernateTemplate().flush();
			}
		}
	}

	@SuppressWarnings("all")
	protected List findByHql(String hql)throws DataAccessException {
		return this.findByHql(hql, -1, -1, null);
	}
	protected List findByHql(String hql,Object...values)throws DataAccessException {
		return this.findByHql(hql, -1, -1, values);
	}

	@SuppressWarnings("all")
	protected List findByHql(String hql, int firstResult, int maxResults)throws DataAccessException {
		return this.findByHql(hql, firstResult, maxResults, null);
	}

	@SuppressWarnings("unchecked")
	protected List findByHql(final String hql, final int firstResult,
			final int maxResults, final Object... values)throws DataAccessException {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List>() {

					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								query.setParameter(i, values[i]);
							}
						}
						if (firstResult >= 0) {
							query.setFirstResult(firstResult);
						}
						if (maxResults > 0) {
							query.setMaxResults(maxResults);
						}
						return query.list();
					}
				});
	}

	@SuppressWarnings("all")
	protected int countByHql(final String hql)throws DataAccessException {
		return this.countByHql(hql, null);
	}

	protected int countByHql(final String hql, final Object... values)throws DataAccessException {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hqlCount = getCountSql(hql);
				List list=getHibernateTemplate().find(hqlCount, values);
				if(list==null||list.size()==0){
					return 0;
				}
				return Integer.valueOf(list.get(0).toString());
			}
		});
	}

	protected static String getCountSql(String hql) {
		String countsql = "";
		if (hql != null) {
			countsql = "select count(*) "
					+ hql.substring(hql.toLowerCase().indexOf("from"));
		}
		return countsql;
	}
}
