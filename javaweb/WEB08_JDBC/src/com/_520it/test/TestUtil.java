package com._520it.test;

import org.junit.Test;

/**
 * ≤‚ ‘∑Ω∑®
 * @author Administrator
 *
 */
public class TestUtil {

	@Test
	public void testQuery() {
		TestLogin testLogin=new TestLogin();
		try {
			testLogin.login("Œ‚Ωı∑Ê ' or '1=1", "1234");
			testLogin.login1("zs", "zs");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
