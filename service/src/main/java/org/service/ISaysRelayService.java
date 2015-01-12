package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRelay;

public interface ISaysRelayService {
	void saveSaysRelay(SaysRelay ar);
	void deleteSaysRelay(Serializable relayid);
	int countByUseridSaysRelay(Serializable userid);
	List<SaysRelay> findByUseridSaysRelay(Serializable userid);
	
}
