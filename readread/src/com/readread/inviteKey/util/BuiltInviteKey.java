package com.readread.inviteKey.util;

import java.util.UUID;

public final class BuiltInviteKey {

	public static String builtRanUUID(){
		UUID objUUID = UUID.randomUUID();
		return objUUID.toString().replaceAll("-", "");
	}
}
