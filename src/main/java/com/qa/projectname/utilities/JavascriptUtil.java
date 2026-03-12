package com.qa.projectname.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {

	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavascriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)this.driver;
		
	}	
		public String getJSTitle () {
			return js.executeScript("return document.title;").toString();
		}
		
		public String getJSURL () {
			return js.executeScript("return document.URL;").toString();
		}
		
		public void refreshBrowser() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		}
		public void JSBackPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(-1)");
		}
		public void JSForwardPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(1)");
	}
		
		public void flash(WebElement element) {
			String bgcolor = element.getCssValue("backgroundColor");//blue
			for (int i = 0; i < 7; i++) {
				changeColor("rgb(0,200,0)", element);// green
				changeColor(bgcolor, element);// blue
			}
		}
		private void changeColor(String color, WebElement element) {
			js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);//GBGBGBGBGBGB

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
			
		public void generateAlert(String message) {
		js.executeScript("alert('"+ message + "')");
			}
		public String getPageinfo() {
		 return js.executeScript("return document.documentElement.innerText;").toString();
		}
}

