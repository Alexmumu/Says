package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysLikeDao;
import org.entity.SaysBrowse;
import org.entity.SaysLike;
import org.service.ISaysBrowseService;
import org.service.ISaysLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SaysLikeServiceImpl implements ISaysLikeService {
	@Autowired
	ISaysLikeDao saysLikeDao;

	@Override
	public boolean saveSaysLike(SaysLike sl) {
		
	if(saysLikeDao.findByUseridToUseridareForLikeforSaysLike(sl.getLikefor(), sl.getUserid().getUserid(), sl.getUseridare().getUserid())!=0)
				{
					SaysLike slk=saysLikeDao.findByUseridToUseridareForLikeforSaysLike1(sl.getLikefor(), sl.getUserid().getUserid(), sl.getUseridare().getUserid());
					saysLikeDao.deleteById(slk.getLikeid());
				
					return false;
				}
				else
				{
					this.saysLikeDao.saveSaysLike(sl);
					return true;
				}	
	}

	@Override
	public void deleteSaysLike(Serializable likeid) {
		this.saysLikeDao.deleteSaysLike(likeid);
	}

	@Override
	public int countByUseridSaysLike(Serializable userid) {
		return this.saysLikeDao.countByUseridSaysLike(userid);
	}
	@Override
	public List<SaysLike> findByUseridareSaysLike(Serializable useridare) {
		
		return this.saysLikeDao.findByUseridareSaysLike(useridare);
	}

	@Override
	public int findByUseridToUseridareForLikeforSaysLike(Serializable likefor,
		Serializable userid, Serializable useridare) {
		return this.saysLikeDao.findByUseridToUseridareForLikeforSaysLike(likefor, userid, useridare);	
	}

	@Override
	public List<SaysLike> findByUseridSaysLike(Serializable userid) {
		return this.saysLikeDao.findByUseridSaysLike(userid);
	}

	@Override
	public int countByLikeforSaysLike(Serializable likefor) {
		return this.saysLikeDao.countByLikeforSaysLike(likefor);
	}

	@Override
	public int countByLikeforAndUseridSaysLike(Serializable likefor,
			Serializable userid) {
		return this.saysLikeDao.countByLikeforAndUseridSaysLike(likefor, userid);
		
	}

	@Override
	public List<SaysLike> findByLikeforAndUseridSaysLike(Serializable likefor,
			Serializable userid) {
		return this.saysLikeDao.findByLikeforAndUseridSaysLike(likefor, userid);
		
	}
	
}
