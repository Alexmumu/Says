package org.vo;

import java.sql.Timestamp;

public class MsgDataVo {

	private String msgid;
	
	private Object data;
	
	private String userid;
	
	private int mctype;
	
	private int mcstatus;
	
	private String msctime;
	
	private String fromid;
	
	private String fromname;
	
	private String msgcontent;
	
	
	

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getMctype() {
		return mctype;
	}

	public void setMctype(int mctype) {
		this.mctype = mctype;
	}

	public int getMcstatus() {
		return mcstatus;
	}

	public void setMcstatus(int mcstatus) {
		this.mcstatus = mcstatus;
	}
	

	public String getMsctime() {
		return msctime;
	}

	public void setMsctime(String msctime) {
		this.msctime = msctime;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getMsgcontent() {
		return msgcontent;
	}

	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	
	
	
	
	
}
