package com.qa.projectname.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {

	private Properties prop;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
		co.addArguments("--incognito");
	}
		
		return co;
	}

	public EdgeOptions getEdgeOptions() {
		EdgeOptions eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("---Running in headless mode----");
			eo.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println("---Running in incognito mode----");
			eo.addArguments("--inprivate");
		}
		return eo;
	}

}