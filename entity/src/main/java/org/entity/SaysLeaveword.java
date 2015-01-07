package org.entity;import java.sql.Timestamp;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.ManyToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_leaveword --> SaysLeaveword  * <table explanation> * @author 2015-01-07 19:01:40 *  */	@Entity@Table(name="says_leaveword")public class SaysLeaveword implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 留言表id **/	private String leavewordid;	/** 留言内容 **/	private String leavewordcontent;	/** 留言时间 **/	private Timestamp leaveworddate;	/** 所属用户id **/	private SaysUser userid;	/** 留言用户id **/	private SaysUser fromuserid;	/** 留言状态详解：0代表删除，1代表正常。 **/	private int levewodidstatus;	//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getLeavewordid() {		return leavewordid;	}	public void setLeavewordid(String leavewordid) {		this.leavewordid = leavewordid;	}	public String getLeavewordcontent() {		return leavewordcontent;	}	public void setLeavewordcontent(String leavewordcontent) {		this.leavewordcontent = leavewordcontent;	}	public Object getLeaveworddate() {		return leaveworddate;	}	public void setLeaveworddate(Object leaveworddate) {		this.leaveworddate = leaveworddate;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	public SaysUser getFromuserid() {		return fromuserid;	}	public void setFromuserid(SaysUser fromuserid) {		this.fromuserid = fromuserid;	}	public int getLevewodidstatus() {		return levewodidstatus;	}	public void setLevewodidstatus(int levewodidstatus) {		this.levewodidstatus = levewodidstatus;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'leavewordid':'"+this.getLeavewordid()+"',");		sb.append("'leavewordcontent':'"+this.getLeavewordcontent()+"',");		sb.append("'leaveworddate':'"+this.getLeaveworddate()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'fromuserid':'"+this.getFromuserid()+"',");		sb.append("'levewodidstatus':'"+this.getLevewodidstatus()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"leavewordid","leavewordcontent","leaveworddate","userid","fromuserid","levewodidstatus"};	}}