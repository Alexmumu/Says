package org.entity;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.ManyToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * says_userword --> SaysUserword  * <table explanation> * @author 2015-01-07 19:01:41 *  */	@Entity@Table(name="says_userword")public class SaysUserword implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 留言板寄语表id **/	private String userwordid;	/** 寄语内容 **/	private String userwordcontent;	/** 所属用户id **/	private SaysUser userid;	//method	@Id	@GenericGenerator(name="systemUUID",strategy="uuid")	@GeneratedValue(generator="systemUUID")	public String getUserwordid() {		return userwordid;	}	public void setUserwordid(String userwordid) {		this.userwordid = userwordid;	}	public String getUserwordcontent() {		return userwordcontent;	}	public void setUserwordcontent(String userwordcontent) {		this.userwordcontent = userwordcontent;	}	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)	public SaysUser getUserid() {		return userid;	}	public void setUserid(SaysUser userid) {		this.userid = userid;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'userwordid':'"+this.getUserwordid()+"',");		sb.append("'userwordcontent':'"+this.getUserwordcontent()+"',");		sb.append("'userid':'"+this.getUserid()+"',");		sb.append("}");		return sb.toString();	}	//return String[] filed; 	public String[] getField() {		return new String[]{"userwordid","userwordcontent","userid"};	}}