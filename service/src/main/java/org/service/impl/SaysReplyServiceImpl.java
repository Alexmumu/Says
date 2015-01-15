package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysReplyDao;
import org.entity.SaysReply;
import org.service.ISaysReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysReplyServiceImpl implements ISaysReplyService {

	@Autowired
	private ISaysReplyDao replyDao;
	
	public Serializable addReply(SaysReply reply) {
		Serializable i = null;
		if(replyDao.HasReply(reply.getReplyid())){
			i = replyDao.AddReply(reply);
		}
		return i;
	}

	public boolean deleteReply(SaysReply reply) {
		try {
			reply.setReplystatus(0);
			replyDao.update(reply);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<SaysReply> findReplybyCommentid(Serializable commentid,
			Page<SaysReply> page, int replystatus) {
		page.setDataSum(replyDao.CountReplybyCommentid(commentid,replystatus));
		List<SaysReply> list = replyDao.FindReplybyCommentid(commentid, page
				.getFirstResult(), page.getMaxResults(),replystatus);
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
	}

	@Override
	public Page<SaysReply> findReplybyReplyare(Serializable replyare,
			Page<SaysReply> page, int replystatus) {
		page.setDataSum(replyDao.CountReplybyReplyare(replyare,replystatus));
		List<SaysReply> list = replyDao.FindReplybyReplyare(replyare, page
				.getFirstResult(), page.getMaxResults(),replystatus);
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
	}

	@Override
	public SaysReply getReply(Serializable replyid) {

		return replyDao.getById(replyid);
		
	}

}
