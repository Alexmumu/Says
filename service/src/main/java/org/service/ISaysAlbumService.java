package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysAlbum;
import org.vo.Page;

public interface ISaysAlbumService {
   public Page<SaysAlbum> findByUserId(SaysAlbum al,Page<SaysAlbum> page,int albumstatus);
	Serializable addAlbum(SaysAlbum al);
	void updateAlbum(SaysAlbum al);
	int countByUserid(Serializable userid ,int albumstatus );
	void delectAlbum(Serializable albumid,String Ralbumid);
	SaysAlbum findAlbumByalbumid(Serializable albumid);
}
