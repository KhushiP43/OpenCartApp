package com.qa.projectname.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.projectname.factory.DriverFactory;
import com.qa.projectname.pages.AccountPage;
import com.qa.projectname.pages.LoginPage;
import com.qa.projectname.pages.ProductInfoPage;
import com.qa.projectname.pages.RegistrationPage;
import com.qa.projectname.pages.SearchPageResults;
import com.qa.projectname.utilities.Log4JUtil;
@Listeners(ChainTestListener.class)

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected LoginPage loginpage;
	protected AccountPage acctpage;
	protected SearchPageResults SearchPage;
	protected ProductInfoPage InfoPage;
	protected RegistrationPage RegPage;
	
	
	@Parameters ({"browser"})
	@BeforeTest
	
	public void setup(String browserName ) {
		df = new DriverFactory();
		prop = df.intiProp();
		
		if (browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		
		driver = df.intiDriver(prop);
		loginpage = new LoginPage(driver);
	}
	
	
	@BeforeMethod
	
	public void beforeMethod(ITestContext result) {
		Log4JUtil.info("start the test case" + result.getName());
	}
	
	
	@AfterMethod
	public void afterScreenshot(ITestResult result) {
//		if (!result.isSuccess()) {
//		  ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");                   //only for fail test case
//		}
		 ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");                //after every test case ss
		 Log4JUtil.info("end the test case" + result.getMethod().getMethodName() );
	}
	
	@AfterTest
	public void teardown() {
	driver.quit();
	
	}
}
