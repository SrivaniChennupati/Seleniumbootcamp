package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.MyAccountPage;

public class AccountsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accountpageSetUp() {
		
		ap = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void accountsPageTest() {
		
		
		
	}

}
