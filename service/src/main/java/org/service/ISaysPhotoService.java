package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysPhoto;
import org.vo.ContentData;
import org.vo.Page;

public interface ISaysPhotoService {
	Page<ContentData<Object>> findPhotoByAlbumId(String albumid,Page<SaysPhoto> page);
	Serializable addPhotoIntoAlbum(SaysPhoto ph);
	void updatePhoto(SaysPhoto ph);
	int countPhotoByAlbum(Serializable albumid,String photostatus);
	void delect(Serializable photoid); 
 
}
