package org.service;

import java.io.Serializable;

import org.entity.SaysShuoshuo;
import org.vo.ContentData;
import org.vo.Page;

public interface IsaysShouShouService {

	Page<ContentData<Object>> findAllShuoShuo(Serializable userid,Page<SaysShuoshuo> page,int shuostatus);

	Serializable addShouShou(SaysShuoshuo ss);
	void updateShouShou(SaysShuoshuo ss);
	int countShouShouByUserId(Serializable userid,int shuostatus);
	public boolean deleteShuoShuo(Serializable shuoid);
	public ContentData<SaysShuoshuo> getshuoshuobyid(Serializable shuoid); 
}
