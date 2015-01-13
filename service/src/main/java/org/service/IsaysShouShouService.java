package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysAlbum;
import org.entity.SaysShuoshuo;
import org.vo.Page;

public interface IsaysShouShouService {
    Page<SaysShuoshuo> findAllShuoShuo(SaysShuoshuo ss,Page<SaysShuoshuo> page,int shuostatus);
	Serializable addShouShou(SaysShuoshuo ss);
	void updateShouShou(SaysShuoshuo ss);
	int countShouShouByUserId(Serializable userid,int shuostatus);
}
