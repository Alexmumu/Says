package org.entity;import java.sql.Timestamp;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.FetchType;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.JoinColumn;import javax.persistence.ManyToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_rizhitype --> SaysRizhitype  * <table explanation> * @author 2015-01-07 19:01:41 *  */	@Entity@Table(name="says_rizhitype")public class SaysRizhitype implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 日志类型表id **/	private String typeid;	/** 所属用户id **/	private SaysUser userid;	/** 日志类型名称 **/	private String typename;	/** 创建时间 **/	private Timestamp timedate;	/** 日志类型状态详解：0代表删除，1代表正常，2代表不可删除。 **/	private int typestatus;	//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getTypeid() {		return typeid;	}	public void setTypeid(String typeid) {		this.typeid = typeid;	}	@ManyToOne(fetch=FetchType.LAZY)	@JoinColumn(name="userid")	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	public String getTypename() {		return typename;	}	public void setTypename(String typename) {		this.typename = typename;	}	public Timestamp getTimedate() {		return timedate;	}	public void setTimedate(Timestamp timedate) {		this.timedate = timedate;	}	public int getTypestatus() {		return typestatus;	}	public void setTypestatus(int typestatus) {		this.typestatus = typestatus;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'typeid':'"+this.getTypeid()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("'typename':'"+this.getTypename()+"',");		sb.append("'timedate':'"+this.getTimedate()+"',");		sb.append("'typestatus':'"+this.getTypestatus()+"',");		sb.append("}");		return sb.toString();	}//	//return String[] filed; //	public String[] getField() {//		return new String[]{"typeid","userid","typename","timedate","typestatus"};//	}}