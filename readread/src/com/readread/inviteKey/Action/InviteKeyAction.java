package com.readread.inviteKey.Action;

import com.readread.inviteKey.delegate.InviteKeyMan;
import com.readread.inviteKey.model.InviteKeyVO;
import com.readread.inviteKey.util.BuiltInviteKey;

public final class InviteKeyAction {
	public static void insertInviteKeyVO(){
		InviteKeyMan objInviteKeyMan = new InviteKeyMan();
		InviteKeyVO objInviteKeyVO = new InviteKeyVO();
		objInviteKeyVO.setInviteKey(BuiltInviteKey.builtRanUUID());
		objInviteKeyVO.setIsUsed(0);
		objInviteKeyMan.insertInvite(objInviteKeyVO);
	}
	
	public static void main(String[] args){
		insertInviteKeyVO();
	}
}
