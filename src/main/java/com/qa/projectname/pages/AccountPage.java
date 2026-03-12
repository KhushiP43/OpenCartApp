package com.qa.projectname.pages;

import static com.qa.projectname.constants.AppConstant.DEFAULT_TIMEOUT;

import java.util.ArrayList;
import java.util.List;
import static com.qa.projectname.constants.AppConstant.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.projectname.utilities.ElementUtil;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private final By headers = By.cssSelector("div#content>h2");
	private final By search = By.name("search");
	private final By searchButton = By.cssSelector("div#search button");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	     eleUtil = new ElementUtil(driver);
	}

	public String getAcctTitle() {
		String title = eleUtil.WaitTitle(HOME_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("acct page title" + title);
		return title; 
	}
	
	public String getAcctURL() {
		String URL = eleUtil.WaitPractialURL(HOME_PAGE_FRACTION_URL, DEFAULT_TIMEOUT);
		System.out.println("acct page title" + URL);
		return URL; 
	}
	
	public List <String> getAccPageHeaders(){
		List <WebElement> headerList = eleUtil.webGetEelements(headers);
		List <String> headerValueList = new ArrayList <String>();
		for (WebElement e: headerList) {
		String text = e.getText();
		headerValueList.add(text);
		}
		
		return headerValueList;
	}
	
	public SearchPageResults doSearch(String searchkey) {
		eleUtil.doSendKeys(search, searchkey);
		System.out.println("search key is:" + " " + searchkey);
		eleUtil.doclick(searchButton);
		return new SearchPageResults(driver);
		
	}
	
	
}