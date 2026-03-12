package com.qa.projectname.factory;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import com.qa.projectname.exceptions.BrowserException;

public class DriverFactory {

	static WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
    public static String highlight;
    public static ThreadLocal <WebDriver> t1driver = new ThreadLocal <WebDriver>();
    
    
    public Logger log = LogManager.getLogger(DriverFactory.class);
   
    
	
	public WebDriver intiDriver(Properties prop) {
		log.info(prop);
		String broswerName = prop.getProperty("browser");
		log.info(broswerName);
		System.out.println("browser name " + prop);
		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight");
	
	switch (broswerName.toLowerCase().trim()) {  
	case "chrome": 
		t1driver.set (new ChromeDriver(optionsManager.getChromeOptions()));
		break;
	case "edge": 
		t1driver.set (new EdgeDriver(optionsManager.getEdgeOptions()));
		break;
	case "Firefox": 
		driver = new FirefoxDriver();
		break;
	case "safari": 
		driver = new SafariDriver();
	    break;
	default:
		System.out.println("Check your browser " + broswerName) ;  
		log.error("plass the right browser name" + broswerName );
		throw new BrowserException("==browser Name invalid==");
}
	getDriver().get(prop.getProperty("url"));
	getDriver().manage().window().maximize();
	getDriver().manage().deleteAllCookies();
	return driver;
}

	public static WebDriver getDriver() {
		return t1driver.get();
	}
	
	public static File getScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		return srcFile;
	}
	public Properties intiProp() {
		prop = new Properties();
		try {
			log.warn("env is null");
			FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
			prop.load(ip);
		} catch ( FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	}

