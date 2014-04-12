package com.readread.inviteKey.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class InviteKeyVO implements Serializable{
	String inviteKey;
	
	Timestamp createTime;
	
	int isUsed;

	public String getInviteKey() {
		return inviteKey;
	}

	public void setInviteKey(String inviteKey) {
		this.inviteKey = inviteKey;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	
}
