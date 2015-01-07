package org.entity;import java.sql.Timestamp;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.JoinColumn;import javax.persistence.ManyToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_reply --> SaysReply  * <table explanation> * @author 2015-01-07 19:01:41 *  */	@Entity@Table(name="says_reply")public class SaysReply implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 回复表id **/	private String replyid;	/** 回复内容 **/	private String replycontent;	/** 回复时间 **/	private Timestamp replydate;	/** 回复者用户id **/	private SaysUser userid;	/** 回复的评论id **/	private String commentid;	/** 被回复的id **/	private String replyare;	/** 回复的状态详解： 0代表删除，1代表存在，2代表这是个回复别人的回复。 **/	private int replystatus;	/** 被回复的用户id **/	private SaysUser useridare;	//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getReplyid() {		return replyid;	}	public void setReplyid(String replyid) {		this.replyid = replyid;	}	public String getReplycontent() {		return replycontent;	}	public void setReplycontent(String replycontent) {		this.replycontent = replycontent;	}	public Timestamp getReplydate() {		return replydate;	}	public void setReplydate(Timestamp replydate) {		this.replydate = replydate;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	@JoinColumn(name="userid")	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	public String getCommentid() {		return commentid;	}	public void setCommentid(String commentid) {		this.commentid = commentid;	}	public String getReplyare() {		return replyare;	}	public void setReplyare(String replyare) {		this.replyare = replyare;	}	public int getReplystatus() {		return replystatus;	}	public void setReplystatus(int replystatus) {		this.replystatus = replystatus;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	@JoinColumn(name="userid")	public SaysUser getUseridare() {		return useridare;	}	public void setUseridare(SaysUser useridare) {		this.useridare = useridare;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'replyid':'"+this.getReplyid()+"',");		sb.append("'replycontent':'"+this.getReplycontent()+"',");		sb.append("'replydate':'"+this.getReplydate()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'commentid':'"+this.getCommentid()+"',");		sb.append("'replyare':'"+this.getReplyare()+"',");		sb.append("'replystatus':'"+this.getReplystatus()+"',");		sb.append("'useridare':'"+this.getUseridare()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"replyid","replycontent","replydate","userid","commentid","replyare","replystatus","useridare"};	}}