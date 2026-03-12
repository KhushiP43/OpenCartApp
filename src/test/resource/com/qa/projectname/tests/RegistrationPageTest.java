package com.qa.projectname.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.projectname.base.BaseTest;

public class RegistrationPageTest extends BaseTest {
	
	
	@BeforeClass
	public void regsiterSetUp() {
		RegPage = loginpage.navigatetoRegisterPage();
	}
	
	@DataProvider
	public Object[] [] userRegisterData(){
		return new Object[] [] {
			{"Vijay", "Mehta", "153536362261", "Sheetal@12311", "yes"},
			{"Richa", "Shah",  "657577743231", "Ishika@12311","no"}
		};
	}
	
	@Test(dataProvider = "userRegisterData" )
	public void userRegisterTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(RegPage.userRegistration(firstName,lastName,telephone,password, subscribe));
	}
}
