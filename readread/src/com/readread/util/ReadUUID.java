package com.readread.util;

import java.util.UUID;

public final class ReadUUID {
	public static String getReadUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
