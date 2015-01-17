package org.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Page<T> implements Serializable {
	private Integer pageNo;     
	private Integer pageSize;
	private Integer dataSum;
	private Integer pageSum;

	private Integer firstResult;  
	private Integer maxResults;

	private List<T> result;

	public Page() {
		super();
		pageSize = Constant.DEFAULT_PAGE;
		firstResult = 0;
		
	}

	/**
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the dataSum
	 */
	public Integer getDataSum() {
		return dataSum;
	}

	/**
	 * @param dataSum
	 *            the dataSum to set
	 */
	public void setDataSum(Integer dataSum) {
		this.dataSum = dataSum;
	}

	/**
	 * @return the pageSum
	 */
	public Integer getPageSum() {
		int sum= this.getDataSum() % this.getPageSize() == 0 ? this.getDataSum()
					/ this.getPageSize() : (this.getDataSum() / this.getPageSize()
					+ 1);
		if(sum==0){
			return 1;
		}
		return sum;
	}

	/**
	 * @param pageSum
	 *            the pageSum to set
	 */
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

	/**
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * @return the firstResult
	 */
	public Integer getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * @return the maxResults
	 */
	public Integer getMaxResults() {
		return this.getPageSize();
	}

}
