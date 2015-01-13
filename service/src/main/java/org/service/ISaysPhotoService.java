package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysPhoto;
import org.vo.Page;

public interface ISaysPhotoService {
    Page<SaysPhoto> findPhotoByAlbumId(SaysPhoto ph,Page<SaysPhoto> page,String photostatus);
	Serializable addPhotoIntoAlbum(SaysPhoto ph);
	void updatePhoto(SaysPhoto ph);
	int countPhotoByAlbum(Serializable albumid,String photostatus);
}
