package org.entity;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;/******************************************************************************* * javaBeans * province --> Province  * <table explanation> * @author 2015-01-07 19:01:40 *  */	@Entity@Table(name="province")public class Province implements java.io.Serializable {	/**	 * 	 */	private static final long serialVersionUID = 1L;	//field	/** 省id **/	private int pid;	/** 省级名称 **/	private String pname;	//method	@Id	public int getPid() {		return pid;	}	public void setPid(int pid) {		this.pid = pid;	}	public String getPname() {		return pname;	}	public void setPname(String pname) {		this.pname = pname;	}	//override toString Method 	public String toString() {		StringBuffer sb=new StringBuffer();		sb.append("{");		sb.append("'pid':'"+this.getPid()+"',");		sb.append("'pname':'"+this.getPname()+"',");		sb.append("}");		return sb.toString();	}//	//return String[] filed; //	public String[] getField() {//		return new String[]{"pid","pname"};//	}}