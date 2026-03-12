package com.qa.projectname.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.projectname.base.BaseTest;
import com.qa.projectname.utilities.CSVUtil;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetup() {
	  	  acctpage = loginpage.doLogin(prop.getProperty("username"), "password");
	    }
	
	@DataProvider
	public Object[] [] getProductDataProvider() {
		return new Object[] [] {
			{"macbook", "MacBook Pro"},
			{"macbook" , "MacBook Air"},
			{"samsung", "Samsung Galaxy Tab 10.1r"}

		};
	}
	
	
	@Test(dataProvider = "getProductDataProvider")
	public void productInfoTest(String search, String productValue) {
		SearchPage = acctpage.doSearch(search);
		InfoPage = SearchPage.selectProduct(productValue);
		String actHeader = InfoPage.productHeader();
		Assert.assertEquals(actHeader, productValue);
	}
	
	
	@DataProvider
	public Object[] [] getImageCountDataProvider() {
		return new Object[] [] {
			{"macbook", "MacBook Pro", 4},
			{"macbook" , "MacBook Air", 4},
			{"samsung", "Samsung Galaxy Tab 10.1r", 7}

		};
	}
	
	@Test (dataProvider = "getImageCountDataProvider")
	public void productImageCountTest(String searchkey, String productValue, int expimageCount) {
		SearchPage = acctpage.doSearch(searchkey);
		InfoPage = SearchPage.selectProduct(productValue);
		int actImageCount = InfoPage.getImageCount();
		Assert.assertEquals(actImageCount, expimageCount);
	}
	
	
	@DataProvider
	public Object[][] getProductCSVData() {
		return CSVUtil.csvData("product");
	
	}

@Test(dataProvider = "getProductCSVData")
public void productImageCountTest(String searchKey, String productName, String expectedImageCount) {
	SearchPage =  acctpage.doSearch(searchKey);
	InfoPage = SearchPage.selectProduct(productName);
	int actImageCount =InfoPage.getImageCount();
	Assert.assertEquals(String.valueOf(actImageCount), expectedImageCount);
}
	
	public void productDetailsTest() {
		SearchPage = acctpage.doSearch("MacBook");
		InfoPage = SearchPage.selectProduct("MacBook Pro");
		Map<String, String> actualMap= InfoPage.getProductMap();
		
		SoftAssert softAsst = new SoftAssert();
		softAsst.assertEquals(actualMap.get("productHeader"), "MacBook Pro");
		softAsst.assertEquals(actualMap.get("imageCount"), "4");
		softAsst.assertEquals(actualMap.get("Brand"), "Apple");
		softAsst.assertEquals(actualMap.get("Product Code"), "Product 18");
		softAsst.assertEquals(actualMap.get("Availability"), "Out of Stock");
		softAsst.assertEquals(actualMap.get("productPrice"), "$2,000.00");
		softAsst.assertEquals(actualMap.get("TextSplit"), "$2,000.00");
		
		softAsst.assertAll();
	}
}
