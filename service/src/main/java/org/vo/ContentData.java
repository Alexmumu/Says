package org.vo;

import java.util.List;

import org.entity.SaysComments;

/**
 * 展现动态的时候 可以直接用这个
 * 用于封装 
 * 带内容的数据 如 说说 日志  相片   
 * 加上  阅读数 转发转载数  评论数  点赞数
 * @author ipengyo
 *
 * @param <T> 说说 日志 相片 这种数据对象
 */
public class ContentData<T> {
	/**
	 * 核心数据  如 说说 相片 日志
	 */
	private T data ;
	/**
	 * 浏览的数目
	 */
	private int yuedunum;
	/**
	 * 转发数
	 */
	private int zhuanfanum;
	/**
	 * 点赞数
	 */
	private int dianzannum;
	/**
	 * 表示这个对象的类型  如 1是说说 2日志 3相册
	 */
	private int datatype;
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
	
	
}
