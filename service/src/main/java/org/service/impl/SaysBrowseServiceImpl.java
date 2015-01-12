package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysBrowseDao;
import org.entity.SaysBrowse;
import org.service.ISaysBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SaysBrowseServiceImpl implements ISaysBrowseService{
	@Autowired
	ISaysBrowseDao saysBrowseDao;
	@Override
	public void saveSaysBrowse(SaysBrowse sb) {
		this.saysBrowseDao.save(sb);
		
	}
	@Override
	public void deleteSaysBrowse(Serializable browseid) {
		this.saysBrowseDao.deleteSaysBrowse(browseid);
		
	}
	@Override
	public int countByUseridSaysBrowse(Serializable userid) {
		// TODO Auto-generated method stub
		return this.saysBrowseDao.countByUseridSaysBrowse(userid);
	}
	@Override
	public List<SaysBrowse> findSaysBrowseByitem(Serializable browsefor,
			Serializable useridare) {
		return this.saysBrowseDao.findSaysBrowseByitem(browsefor, useridare);
	}
	@Override
	public void updateSaysBrowse(SaysBrowse sb) {
		this.saysBrowseDao.updateSaysBrowse(sb);
		
	}
	@Override
	public List<SaysBrowse> findSaysBrowse(int firstResult, int maxResults,
			Serializable browsefor, Serializable useridare) {
		return this.saysBrowseDao.findSaysBrowse(firstResult, maxResults, browsefor, useridare);
	}

}
