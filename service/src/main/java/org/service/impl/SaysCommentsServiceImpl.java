package org.service.impl;

import java.io.Serializable;
import java.util.List;

import org.dao.ISaysCommentsDao;
import org.entity.SaysComments;
import org.service.ISaysCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vo.Page;

@Service
public class SaysCommentsServiceImpl implements ISaysCommentsService {

	@Autowired
	private ISaysCommentsDao commentsDao;

	public Serializable addComments(SaysComments comm) {
		Serializable i = null;
		if(commentsDao.HasComment(comm.getCommentid())){
			i = commentsDao.AddComments(comm);
		}
		return i;
	}

	public boolean deleteComments(SaysComments comm) {
		try {
			comm.setCommentstatus("0");
			commentsDao.update(comm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Page<SaysComments> findComments(Serializable commentsforid,
			Page<SaysComments> page,String commentstatus) {
		page.setDataSum(commentsDao.CountComments(commentsforid,commentstatus));
		List<SaysComments> list = commentsDao.FindComments(commentsforid, page
				.getFirstResult(), page.getMaxResults(),commentstatus);
		page.setResult(list);
		System.out.println(page.getDataSum());
		return page;
	}

	@Override
	public SaysComments getComment(Serializable commentid) {

		return commentsDao.getById(commentid);
		
	}

}
