package org.service;

import java.io.Serializable;
import java.util.List;

import org.entity.City;
import org.entity.SaysLeaveword;
import org.vo.Page;

public interface ISaysLeavewordService {
	public Page<SaysLeaveword> findAllSaysLeaveword(Page<SaysLeaveword> page,SaysLeaveword sysleaveword)  ;
	Serializable saveSaysLeaveword(SaysLeaveword sl);
	void deleteSaysLeaveword(Serializable leavewordid);
	int countAllSaysLeaveword(Serializable userid,Serializable levewodidstatus);
}
