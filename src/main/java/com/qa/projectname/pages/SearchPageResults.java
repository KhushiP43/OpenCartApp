package com.qa.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.projectname.constants.AppConstant;
import com.qa.projectname.utilities.ElementUtil;

public class SearchPageResults {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private final By searchCount = By.cssSelector("div.product-thumb");

	public SearchPageResults(WebDriver driver) {
		this.driver = driver;
	     eleUtil = new ElementUtil(driver);
	}
	
	public int getResultsProductCount() {
		int searchCountResults = eleUtil.waitVisibilityForAllElement(searchCount, AppConstant.DEFAULT_TIMEOUT).size();
		System.out.println("Product Count"+ " " +searchCountResults);
		return searchCountResults;
	}
	
	
	
	public ProductInfoPage selectProduct(String productName) {
		System.out.println("Product Name"+ productName);
		eleUtil.doclick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
	 
	}
