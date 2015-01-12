package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysBrowse;
import org.springframework.stereotype.Service;

@Service
public interface ISaysBrowseService {
	void saveSaysBrowse(SaysBrowse sb);
	void deleteSaysBrowse(Serializable browseid);
	int countByUseridSaysBrowse(Serializable userid);
	List<SaysBrowse> findSaysBrowseByitem(Serializable browsefor,Serializable useridare);
	void updateSaysBrowse(SaysBrowse sb);
	List<SaysBrowse> findSaysBrowse(int firstResult,int maxResults, Serializable browsefor,Serializable useridare);
	
}
