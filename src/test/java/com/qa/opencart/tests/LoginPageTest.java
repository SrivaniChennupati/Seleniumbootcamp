package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;

public class LoginPageTest extends BaseTest {
	
	
	@Test
 
	public void LoginPageTest() {
		lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}

}
