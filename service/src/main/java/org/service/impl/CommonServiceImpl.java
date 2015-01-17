package org.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.dao.ISaysAlbumDao;
import org.dao.ISaysLeavewordDao;
import org.dao.ISaysNewsDao;
import org.dao.ISaysRizhiDao;
import org.dao.ISaysShouShousDao;
import org.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommonServiceImpl implements ICommonService {
	@Autowired
	private ISaysAlbumDao sadao;
	@Autowired
	private ISaysNewsDao sndao;
	@Autowired
	private ISaysRizhiDao srzdao;
	@Autowired
	private ISaysLeavewordDao sldao;
	@Autowired
	private ISaysShouShousDao ssdao;
	
	@Override
	public Map<String, Object> findMyCountByUserid(Serializable userid) {
		Map<String,Object> map=new HashMap<String,Object>();
		int albumcount=this.sadao.countByUserid(userid, 0);
		int rizhicount=this.srzdao.countByUserid(userid, 0);
		int shuoshuocount=this.ssdao.countShouShouByUserId(userid, 0);
		int liuyancount=this.sldao.countAllSaysLeaveword(userid, 0);
		int newscount=this.sndao.CountNews(userid);
		map.put("albumcount", albumcount);
		map.put("rizhicount",rizhicount);
		map.put("shuoshuocount",shuoshuocount);
		map.put("liuyancount",liuyancount);
		map.put("newscount", newscount);
		return map;
	}

}
