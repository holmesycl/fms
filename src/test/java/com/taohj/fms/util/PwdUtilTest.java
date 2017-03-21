package com.taohj.fms.util;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PwdUtilTest {

	private static final Logger log = LoggerFactory.getLogger(SaltUtilTest.class);

	@Test
	public void testSha256Hash() {
		String salt = SaltUtil.sysdateSalt();
		log.debug(salt);
		String password = PwdUtil.sha256Hash("123456", salt);
		log.debug(password);
		Assert.assertNotNull(password);
		log.debug("len:" + password.length());

		String pwd = PwdUtil.sha256Hash("yecl", salt);
		log.debug(pwd);
		log.debug("len:" + password.length());

		Assert.assertTrue(password.length() == pwd.length());
	}

}
