package com.taohj.fms.util;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaltUtilTest {
	
	private static final Logger log = LoggerFactory.getLogger(SaltUtilTest.class);

	@Test
	public void testSysdateSalt() {
		String salt = SaltUtil.sysdateSalt();
		log.debug(salt);
		Assert.assertNotNull(salt);
	}

}
