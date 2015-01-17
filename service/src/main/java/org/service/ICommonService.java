package org.service;

import java.io.Serializable;
import java.util.Map;

/**
 * 封装一些常用的方法
 * @author ipengyo
 *
 */
public interface ICommonService {
	
	/**
	 * 获取传入的用户id 的各种数据的数量 如日志的 相片 说说 留言板
	 */
	public Map<String,Object> findMyCountByUserid(Serializable userid);
}
