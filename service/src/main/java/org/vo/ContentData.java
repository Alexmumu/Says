package org.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;

import org.entity.SaysUser;

/**
 * 展现动态的时候 可以直接用这个 用于封装 带内容的数据 如 说说 日志 相片 加上 阅读数 转发转载数 评论数 点赞数
 * 
 * @author ipengyo
 *
 * @param <T>
 *            说说 日志 相片 这种数据对象
 */
public class ContentData<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 核心数据 如 说说 相片 日志
	 */
	private T data;
	/**
	 * 浏览的数目
	 */
	private int yuedunum;
	/**
	 * 评论的数目
	 */
	private int pinglunnum;
	/**
	 * 转发数
	 */
	private int zhuanfanum;
	/**
	 * 点赞数
	 */
	private int dianzannum;
	/**
	 * 表示这个对象的类型 如 1是说说 2日志 3相册
	 */
	private int datatype;
	/**
	 * 对象创建时间
	 */
	private String datadate;
	/**
	 * 转发内容
	 */
	private String ralaycontent;
	/**
	 * 源ID
	 */
	private String contentfromid;
	
	/**
	 * 转发时间
	 * @return
	 */
	private Timestamp ralaydate;
	
	/**
	 * 来源用户ID
	 * @return
	 */
	
	private String fromid;
	
	/**
	 * 来源用户
	 * @return
	 */
	private String fromname;
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getYuedunum() {
		return yuedunum;
	}

	public void setYuedunum(int yuedunum) {
		this.yuedunum = yuedunum;
	}

	public int getZhuanfanum() {
		return zhuanfanum;
	}

	public void setZhuanfanum(int zhuanfanum) {
		this.zhuanfanum = zhuanfanum;
	}

	public int getDianzannum() {
		return dianzannum;
	}

	public void setDianzannum(int dianzannum) {
		this.dianzannum = dianzannum;
	}

	public int getDatatype() {
		return datatype;
	}

	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}

	public int getPinglunnum() {
		return pinglunnum;
	}

	public void setPinglunnum(int pinglunnum) {
		this.pinglunnum = pinglunnum;
	}

	public String getDatadate() {
		return datadate;
	}

	public void setDatadate(String datadate) {
		this.datadate = datadate;
	}
	public Timestamp getRalaydate() {
		return ralaydate;
	}
	public void setRalaydate(Timestamp ralaydate) {
		this.ralaydate = ralaydate;
	}

	public String getRalaycontent() {
		return ralaycontent;
	}

	public void setRalaycontent(String ralaycontent) {
		this.ralaycontent = ralaycontent;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}

	public String getContentfromid() {
		return contentfromid;
	}

	public void setContentfromid(String contentfromid) {
		this.contentfromid = contentfromid;
	}
	
	

}
