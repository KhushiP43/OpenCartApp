package com.qa.projectname.tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import com.qa.projectname.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static com.qa.projectname.constants.AppConstant.*;  

@Feature("Feature 20: design for automation app")
@Epic  ("Epic 100: design for automation app")
@Story("US 101: implement login page for automation")


public class LoginPageTest extends BaseTest{

	@Description("checking login page")
	@Severity(SeverityLevel.MINOR)
	@Owner("Khushi")
	@Test
	public void getLoginTitleTest() {
		String acttitle = loginpage.getLoginTitle();
		Assert.assertEquals(acttitle, LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void getLoginURLTest() {
		String currentURL  = loginpage.getLoginURL();
		Assert.assertTrue(currentURL.contains(LOGIN_PAGE_FRACTION_URL));
	
}
	@Test
	public void forgotPWDTest() {
		Assert.assertTrue(loginpage.getForgotPWD());
		
	}
	@Test (priority = Short.MAX_VALUE)
	public void LoginTest() {
		acctpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
		Assert.assertEquals(acctpage.getAcctTitle(), HOME_PAGE_TITLE);
	}
	
}