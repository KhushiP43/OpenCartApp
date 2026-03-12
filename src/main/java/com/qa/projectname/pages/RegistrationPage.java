package com.qa.projectname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.qa.projectname.constants.AppConstant.*;    
import com.qa.projectname.utilities.ElementUtil;
import com.qa.projectname.utilities.StringUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By telephone = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");

    private final By subscribeNo = By.xpath("//label[@class = 'radio-inline'][2]/input[@type = 'radio']");
    private final By subscribeYes = By.xpath("//label[@class = 'radio-inline'][1]/input[@type = 'radio']");
    private final By Logout = By.linkText("Logout");
    private final By ReRegister = By.linkText("Register");
    
    private final By agree = By.xpath("//input[@type = 'checkbox']");
    private final By loginButton = By.xpath("//input[@type = 'submit']");
    private final By successMsg = By.xpath("//div[@id = 'content']");
    
    
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	     eleUtil = new ElementUtil(driver);
	}
	
	     public boolean userRegistration(String firstName, String lastName, String telephone, String password, String subscribe) {
	    	 eleUtil.waitVisibleForElement(this.firstName, MEDIUM_TIMEOUT).sendKeys(firstName);
	    	 eleUtil.doSendKeys(this.lastName, lastName);
	    	 eleUtil.doSendKeys(this.email, StringUtil.getRandomEmail());
	    	 eleUtil.doSendKeys(this.telephone, telephone);
	    	 eleUtil.doSendKeys(this.password, password);
	    	 eleUtil.doSendKeys(this.confirmPassword, password);
	    	 if (subscribe.equalsIgnoreCase("yes")) {
	    		 eleUtil.doclick(subscribeYes);
	    	 }else {
	    		 eleUtil.doclick(subscribeNo);
	    		 
	    	 }
	    	 
	    	 eleUtil.doclick(agree);
	    	 eleUtil.doclick(loginButton);
	    	 
	    	 
	    	if ( eleUtil.waitVisibleForElement(successMsg, MEDIUM_TIMEOUT).getText().contains(RESITER_SUCCESS_MSG)) {
	    		eleUtil.doclick(Logout);
	    		eleUtil.doclick(ReRegister);
	    	return true;
	     }
	     return false;
		}
}
