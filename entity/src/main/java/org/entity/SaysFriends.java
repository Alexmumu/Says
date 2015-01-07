package org.entity;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.ManyToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_friends --> SaysFriends  * <table explanation> * @author 2015-01-07 19:01:40 *  */	@Entity@Table(name="says_friends")public class SaysFriends implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 好友关系记录表id **/	private String friendid;	/** 用户id **/	private SaysUser userid;	/** 好友id **/	private SaysUser userfriendid;	/** 成立时间 **/	private Object friendstime;	//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getFriendid() {		return friendid;	}	public void setFriendid(String friendid) {		this.friendid = friendid;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	public SaysUser getUserfriendid() {		return userfriendid;	}	public void setUserfriendid(SaysUser userfriendid) {		this.userfriendid = userfriendid;	}	public Object getFriendstime() {		return friendstime;	}	public void setFriendstime(Object friendstime) {		this.friendstime = friendstime;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'friendid':'"+this.getFriendid()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'userfriendid':'"+this.getUserfriendid()+"',");		sb.append("'friendstime':'"+this.getFriendstime()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"friendid","userid","userfriendid","friendstime"};	}}