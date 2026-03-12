package com.qa.projectname.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.projectname.constants.AppConstant;
import com.qa.projectname.utilities.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private final By HeaderName = By.tagName("h4");
	private final By Image = By.cssSelector("ul.thumbnails img");
	private By metaData = By.xpath("(//div[@id= 'content']//ul[@class = 'list-unstyled'])[1]/li");
	private By metaPrice = By.xpath("(//div[@id= 'content']//ul[@class = 'list-unstyled'])[2]/li");
	private Map <String, String>  productMap;
	

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	     eleUtil = new ElementUtil(driver);
	}
	public String productHeader () {
	String header = eleUtil.waitVisibleForElement(HeaderName, AppConstant.DEFAULT_TIMEOUT).getText();
    System.out.println(header);
    return header;
}
	public int getImageCount () {
		int imageCount = eleUtil.waitVisibilityForAllElement(Image, AppConstant.DEFAULT_TIMEOUT).size();
		System.out.println("Image count is: " + imageCount);
		return imageCount;
	}
	
	public Map <String, String> getProductMap() {
		productMap = new HashMap <String, String>();
		productMap.put("productheader", productHeader());
		productMap.put("productheader", String.valueOf(getImageCount()));
		getProductDetails();
		getMetaPrice();
		System.out.println("Map Deatils" + productMap);
		return productMap;
	}
	
	public void getProductDetails() {
		List<WebElement> MetaDataList = eleUtil.waitVisibilityForAllElement(metaData, AppConstant.DEFAULT_TIMEOUT);
		for (WebElement e: MetaDataList) {
			String metaData = e.getText();
			String meta[] = metaData.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productMap.put(metaKey, metaValue);	
		}
	}
	
	public void getMetaPrice() {
		List <WebElement> priceList = eleUtil.waitVisibilityForAllElement(metaPrice, AppConstant.DEFAULT_TIMEOUT);
		String productPrice = priceList.get(0).getText();
		String TextSplit = priceList.get(1).getText().split(":")[1].trim();	
		productMap.put("productPrice", productPrice);
		productMap.put("productPrice", TextSplit);
	}
}