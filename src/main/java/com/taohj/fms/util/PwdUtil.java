package com.taohj.fms.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

public abstract class PwdUtil {

	public static String sha256Hash(String pwd, String salt) {
		return new Sha256Hash(pwd, salt).toBase64();
	}

}
