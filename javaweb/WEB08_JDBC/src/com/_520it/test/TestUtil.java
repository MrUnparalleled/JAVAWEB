package com._520it.test;

import org.junit.Test;

/**
 * ���Է���
 * @author Administrator
 *
 */
public class TestUtil {

	@Test
	public void testQuery() {
		TestLogin testLogin=new TestLogin();
		try {
			testLogin.login("����� ' or '1=1", "1234");
			testLogin.login1("zs", "zs");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
