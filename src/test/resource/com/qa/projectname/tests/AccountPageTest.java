package com.qa.projectname.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.qa.projectname.constants.AppConstant.*;

import java.util.List;

import com.qa.projectname.base.BaseTest;

public class AccountPageTest extends BaseTest{

	
		@BeforeClass
		public void actPageSetup() {
			acctpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test
		public void acctPageTitleTest() {
			Assert.assertEquals(acctpage.getAcctTitle(), HOME_PAGE_TITLE);
		}
		@Test
		public void acctPageURLTest() {
			Assert.assertTrue(acctpage.getAcctURL().contains(HOME_PAGE_FRACTION_URL));
		}
		
		@Test
		public void acctPageHeaderList() {
		List<String> actualPageHeaderList = acctpage.getAccPageHeaders();
		Assert.assertEquals(actualPageHeaderList, expectedHeadersList);
	
		}
	}



