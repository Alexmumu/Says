package org.entity;import java.sql.Timestamp;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.FetchType;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.JoinColumn;import javax.persistence.ManyToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_visit --> SaysVisit  * <table explanation> * @author 2015-01-07 19:01:41 *  */	@Entity@Table(name="says_visit")public class SaysVisit implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 访问表id **/	private String visitid;	/** 被访问者id **/	private SaysUser userid;	/** 访问者id **/	private SaysUser fromuserid;	/** 访问时间 **/	private Timestamp visittime;			//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getVisitid() {		return visitid;	}	public void setVisitid(String visitid) {		this.visitid = visitid;	}	@ManyToOne()	@JoinColumn(name="userid")	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	@ManyToOne()	@JoinColumn(name="fromuserid")	public SaysUser getFromuserid() {		return fromuserid;	}	public void setFromuserid(SaysUser fromuserid) {		this.fromuserid = fromuserid;	}	public Timestamp getVisittime() {		return visittime;	}	public void setVisittime(Timestamp visittime) {		this.visittime = visittime;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'visitid':'"+this.getVisitid()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'fromuserid':'"+this.getFromuserid()+"',");		sb.append("'visittime':'"+this.getVisittime()+"',");		sb.append("}");		return sb.toString();	}//	//return String[] filed; //	public String[] getField() {//		return new String[]{"visitid","userid","fromuserid","visittime"};//	}}