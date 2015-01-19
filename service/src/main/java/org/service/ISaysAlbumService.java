package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysAlbum;
import org.vo.Page;

public interface ISaysAlbumService {
   public Page<SaysAlbum> findByUserId(SaysAlbum al,Page<SaysAlbum> page);
	Serializable addAlbum(SaysAlbum al);
	void updateAlbum(SaysAlbum al);
	int countByUserid(Serializable userid);
	void delectAlbum(Serializable albumid,String userid);
	SaysAlbum findAlbumByalbumid(Serializable albumid);
}
