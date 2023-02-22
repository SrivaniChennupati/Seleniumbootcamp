package com.qa.opencart.tests;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	
	@BeforeClass
	
	public void regpageSetup() {
		  
		
		rap = lp.clickOnRegisterPage();
		
	}
	
	public static  String generateRandom() {
		
		Random random = new Random();
		
		String email = "testautomation"+random.nextInt(1000)+"@gmail.com" ;
		
		return email;
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = ExcelUtil.getTestData("register");
		
		return data;
		
	}
	
	
	
	@Test(dataProvider = "getData")
	
	public void registrationtest(String firstname,String lastname,String password) {
		rap.doRegistration(firstname, lastname, generateRandom(), password);
		
		
	}
	
	

}
