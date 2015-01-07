package org.entity;import java.sql.Timestamp;import java.util.HashSet;import java.util.Set;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.JoinColumn;import javax.persistence.ManyToOne;import javax.persistence.OneToMany;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_comments --> SaysComments  * <table explanation> * @author 2015-01-07 19:01:40 *  */	@Entity@Table(name="says_comments")public class SaysComments implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 评论表id **/	private String commentid;	/** 评论内容 **/	private String commentcontent;	/** 评论用户id **/	private SaysUser userid;	/** 评论时间 **/	private Timestamp commentdate;	/** 指的是 说说或日志或相片。 **/	private String commentsforid;	/** 评论的状态 0代表已删除，1代表正常。 **/	private String commentstatus;	/** 被评论用户id **/	private String useridare;		private Set<SaysReply> saysreply = new HashSet<SaysReply>();		//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getCommentid() {		return commentid;	}	public void setCommentid(String commentid) {		this.commentid = commentid;	}	public String getCommentcontent() {		return commentcontent;	}	public void setCommentcontent(String commentcontent) {		this.commentcontent = commentcontent;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	@JoinColumn(name="userid")	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	public Timestamp getCommentdate() {		return commentdate;	}	public void setCommentdate(Timestamp commentdate) {		this.commentdate = commentdate;	}	public String getCommentsforid() {		return commentsforid;	}	public void setCommentsforid(String commentsforid) {		this.commentsforid = commentsforid;	}	public String getCommentstatus() {		return commentstatus;	}	public void setCommentstatus(String commentstatus) {		this.commentstatus = commentstatus;	}	public String getUseridare() {		return useridare;	}	public void setUseridare(String useridare) {		this.useridare = useridare;	}	@OneToMany(mappedBy="sayscomments",targetEntity=SaysReply.class,cascade={CascadeType.PERSIST,CascadeType.MERGE})	public Set<SaysReply> getSaysreply() {		return saysreply;	}	public void setSaysreply(Set<SaysReply> saysreply) {		this.saysreply = saysreply;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'commentid':'"+this.getCommentid()+"',");		sb.append("'commentcontent':'"+this.getCommentcontent()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'commentdate':'"+this.getCommentdate()+"',");		sb.append("'commentsforid':'"+this.getCommentsforid()+"',");		sb.append("'commentstatus':'"+this.getCommentstatus()+"',");		sb.append("'useridare':'"+this.getUseridare()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"commentid","commentcontent","userid","commentdate","commentsforid","commentstatus","useridare"};	}}