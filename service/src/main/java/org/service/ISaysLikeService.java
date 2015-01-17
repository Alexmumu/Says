package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysLike;
import org.springframework.dao.DataAccessException;

public interface ISaysLikeService {
	boolean saveSaysLike(SaysLike sl);
	void deleteSaysLike(Serializable likeid);
	int countByUseridSaysLike(Serializable userid);
	List<SaysLike> findByUseridareSaysLike(Serializable useridare);
	int findByUseridToUseridareForLikeforSaysLike(Serializable likefor,Serializable userid,Serializable useridare);
	List<SaysLike> findByUseridSaysLike(Serializable userid);
	int countByLikeforSaysLike(Serializable likefor);
	 List<SaysLike> findByLikeforAndUseridSaysLike(Serializable likefor,Serializable userid);
	int countByLikeforAndUseridSaysLike(Serializable likefor,Serializable userid);
}
