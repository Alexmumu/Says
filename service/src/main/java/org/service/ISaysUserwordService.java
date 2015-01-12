package org.service;

import java.io.Serializable;

import org.entity.SaysUserword;

public interface ISaysUserwordService {
	void saveSaysUserword(SaysUserword suw);
	void updateSaysUserword(SaysUserword saysUserword);
	SaysUserword findSaysUserwordByUserId(Serializable userid);
}
