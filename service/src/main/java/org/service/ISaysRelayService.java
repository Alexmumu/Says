package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.SaysRelay;

public interface ISaysRelayService {
	void saveSaysRelay(SaysRelay ar);
	void deleteSaysRelay(Serializable relayid);
	int countByUseridSaysRelay(Serializable userid);
	List<SaysRelay> findByUseridSaysRelay(Serializable userid);
	int countByRelayfromSaysRelay(Serializable relayfrom);
	int countByRelayafterSaysRelay(Serializable relayafter);
	List<SaysRelay> findByUseridAndRelayafterSaysRelay(Serializable userid,Serializable relayafter);
	int countByRelayFromAndUseridAndUseridareSaysRelay(Serializable relayfrom,Serializable userid,Serializable useridare);
	int countByRelayFromAndUseridareSaysRelay(Serializable relayfrom,Serializable useridare) ;
}
