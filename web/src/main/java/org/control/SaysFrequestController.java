package org.control;

import org.entity.SaysFrequest;
import org.service.ISaysFrequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户申请表
 * @author ipengyo
 *
 */
@Controller
@RequestMapping("Frequest")
public class SaysFrequestController {
	@Autowired
	private ISaysFrequestService sfservice;
	/**
	 * 根据传入的用户id和状态修改相对应的数据
	 * @param frid
	 * @param frstatus
	 * @return
	 */
	@RequestMapping("update")
	public String update(String frid,int frstatus){
		SaysFrequest sf= (SaysFrequest) sfservice.selectSaysFrequestbyid(frid).get(0);
		sf.setFrstatus(frstatus);
		sfservice.updateSaysFrequestbyfrstatus(sf);
		return null;
	}
}
