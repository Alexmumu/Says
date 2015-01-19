package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysAlbum;
import org.entity.SaysShuoshuo;
import org.vo.ContentData;
import org.vo.Page;

public interface IsaysShouShouService {
    Page<ContentData<Object>> findAllShuoShuo(String userid,Page<SaysShuoshuo> page);
	Serializable addShouShou(SaysShuoshuo ss);
	void updateShouShou(SaysShuoshuo ss);
	int countShouShouByUserId(Serializable userid,int shuostatus);
	public boolean deleteShuoShuo(Serializable shuoid);
}
