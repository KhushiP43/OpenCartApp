package com.qa.projectname.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import com.qa.projectname.utilities.ElementUtil;

import io.qameta.allure.Step;

import static com.qa.projectname.constants.AppConstant.*;                 //packagename.className.*      // to remove multiple times App ConstantClass Name

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private final By email = By.id("input-email");
	private final By password = By.id("input-password");
	private final By login = By.xpath("//input[@type = 'submit']");
	private final By forpass = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");
	
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
     eleUtil = new ElementUtil(driver);
	}
	
	@Step("getting logi  url: {0}")
	public String getLoginTitle() {
		String title = eleUtil.WaitTitle(LOGIN_PAGE_TITLE, DEFAULT_TIMEOUT);
		System.out.println("page title" + title);
		return title; 
	}
		public String getLoginURL() {
			String URL = eleUtil.WaitPractialURL(LOGIN_PAGE_FRACTION_URL, DEFAULT_TIMEOUT);
			System.out.println("login page URL" + URL);
			return URL; 
	}
		
		public boolean getForgotPWD() {
			return eleUtil.isElementDisplayed(forpass);
	}
		
		public AccountPage doLogin(String username, String pwd) {
			System.out.println("user credentials" +" "+ username + "  " + pwd);
			eleUtil.waitVisibleForElement(email, DEFAULT_TIMEOUT).sendKeys(username);
			eleUtil.doSendKeys(password, pwd);
			eleUtil.doclick(login);
			
			return new AccountPage(driver);
		}
		
		public RegistrationPage navigatetoRegisterPage() {
			eleUtil.clickWhenReady(registerLink, DEFAULT_TIMEOUT);
			return new RegistrationPage(driver);
			
		}
		
}
