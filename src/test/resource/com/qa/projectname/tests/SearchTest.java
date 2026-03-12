package com.qa.projectname.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.projectname.base.BaseTest;
import com.qa.projectname.pages.LoginPage;

public class SearchTest extends BaseTest {
	
  @BeforeClass
            public void Setup() {
	  acctpage = loginpage.doLogin(prop.getProperty("username"), "password");
  }
	@Test
	public void SearchPageTest() {
		SearchPage = acctpage.doSearch("macbook");
		int actualSearchCount = SearchPage.getResultsProductCount();
		Assert.assertEquals(actualSearchCount, 3);
	}

}
