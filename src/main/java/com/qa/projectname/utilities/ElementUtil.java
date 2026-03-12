package com.qa.projectname.utilities;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.projectname.factory.DriverFactory;

import io.qameta.allure.Step;

public class ElementUtil {

	
		private WebDriver driver;
		private Actions act;
		private JavascriptUtil jsUtil;
		
		public ElementUtil(WebDriver driver) {
			this.driver = driver;
			act = new Actions(driver);
			jsUtil = new JavascriptUtil(driver);
		}
		 public void doclick(By locator) {
	        	getElement(locator).click();
	        }
		 public void dosendKeys(By locator, String value) {
			 nullCheck(value);
	        	getElement(locator).sendKeys(value);
	        }


		 private void nullCheck(CharSequence... value) {
				if (value == null) {
					throw new RuntimeException("===Value can not be null===");
				}
			}

			public void doClick(By locator, String value) {
				getElement(locator).click();
			}
			
            public void clickElements (By locator, String value) {
           List<WebElement> elelist = webGetEelements(locator);
           for (WebElement e: elelist) {
           	String text = e.getText();
           	System.out.println(text);
           	if (text.contains(value)) {
           	   e.click();
           	   break;
}
    }
       }

		public void doSendKeys(By locator, String value) {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
			}
		
		public void doSendKeys(By locator, CharSequence... value) {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
			}
		
		public String getElementDomAttributeValue(By locator, String attrName) {
			return getElement(locator).getDomAttribute(attrName);
		}

		public String getElementDomPropertyValue(By locator, String propName) {
			return getElement(locator).getDomProperty(propName);
		}

		public List<WebElement> webGetEelements(By locator){
			return driver.findElements(locator);
			
		}
	       public List <String> tabledetails(String userName) {
	    	   List <WebElement> NextColumn = driver.findElements(By.xpath("//a[text() = '"+userName+"']/parent::td/following-sibling::td"));
	           System.out.println(NextColumn.size()); 
	           
	           List <String> emptylist = new ArrayList<String>();
	           for (WebElement e :NextColumn ) {
	        	   String Text = e.getText();
	        	   System.out.println(Text);
	        	   emptylist.add(userName);
	    
	    	   
	       }
	        return emptylist;
	        		
		}
	       
	       public String doElementGetText(By locator) {
	    	   String eleText = getElement(locator).getText();
	    	   System.out.println("The element is:" + eleText );
	    	   return eleText;
	       }
	       public  void dropDownIndexEle(By locator, int Index) {                         //dropdown
	   		Select select = new Select(getElement(locator));
	   		select.selectByIndex(Index);
	   	}
	   		public  void dropDownVisibleEle (By locator, String value) {                 //dropdown
	   			Select select = new Select(getElement(locator));
	   			select.selectByVisibleText(value);
	   		}
	   		public void dropDownValueEle (By locator, String value1) {                   //dropdown
	   			Select select = new Select(getElement(locator));
	   			select.selectByVisibleText(value1);
	   		}
	   		
	   	  public void ComboEle (By choice, By choicelist, String... value) {	                 // ... for multi selection
         	 
	   		  driver.findElement(choice).click();
      		List <WebElement> Combo = driver.findElements(choicelist);
      				System.out.println(Combo.size());
      				
      				if (value[0].equalsIgnoreCase("all")) {
      					for (WebElement e: Combo){
      						e.click();
      					}
      					} else {
                   for (WebElement e : Combo ) {
                  	 String text = e.getText();
                  	 System.out.println(text);
                    
                  	 for (String options : value) {
                  		 if(text.trim().equals(options)) {
                  			 e.click();
                  			 break;
   	 }
     }    
	}        					
}
 }	  
	   	  
	   	  public void clickWhenReady(By locator, int timeout) {
	   		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   		  wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	   	  }
	   	  
	   	  
	   	  public void ActionsEle(By locator) throws InterruptedException{
	   		Actions act = new Actions(driver);
	   		act.moveToElement(getElement(locator)).build().perform();
	   		Thread.sleep(2000);
	   		  
	   	  }
	   	public void MenuElement (By Parent, By Submenu) throws InterruptedException {                               // Actions Util
			 Actions act = new Actions(driver);
		        act.moveToElement(getElement(Parent)).build().perform();
		        Thread.sleep(3000);
		        getElement(Submenu).click();   
		        
		}
         public void Basket1 (By shopCategory1, By categories1, By submenu1, By finalmenu1 ) throws InterruptedException {       //Actionele and do click complete optimize
	   		doclick(shopCategory1);
	   		ActionsEle(categories1);
	   	   	ActionsEle(submenu1);
	   	    doclick(finalmenu1);
         }
	   	
	   	public void Basket(By shopCategory, By categories, By submenu, By finalmenu ) throws InterruptedException {         // Actions Move with 4 levels
	   		
	   		Actions act = new Actions(driver);
	   		getElement(shopCategory).click();
	   	    Thread.sleep(3000);
	   	    act.moveToElement(getElement(categories)).build().perform();
	   	    Thread.sleep(3000);
	   	    act.moveToElement(getElement(submenu)).build().perform();
	   	    Thread.sleep(3000);
	   	    getElement(finalmenu).click();	
	   	}
	   	
		
	   	public  List <WebElement> waitPresenceForAllElement (By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			
		}
	   	public List <WebElement> waitVisibilityForAllElement (By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			
		}
	   	
	   	@Step ("waiting for element using: {0} and timeout: {1}")
	   	public  WebElement waitPresenceForElement (By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		}
	   	
	   	public  WebElement waitVisibleForElement (By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			highlight (element);
			return element;
//			return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	   	}
	   	
	   	public void  ClickWait (By locator, int timeout) {
			 waitVisibleForElement(locator, timeout).click();;
	   	}
	   	
	   	public void sendKeystWait (By locator, int timeout) {
			 waitVisibleForElement(locator, timeout).sendKeys();
	   	}
	   	public WebElement getElementWait (By locator, int timeout) {
			return waitVisibleForElement(locator, timeout);
	   	}
	   	
	   	public Alert alertWait (int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public void acceptAlert(int timeout) {
			alertWait(timeout).accept();
		}
		public  String WaitPractialTitle(String partialtitle, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.titleContains(partialtitle));
			return driver.getTitle();
		}
			
			public  String WaitTitle (String title, int timeout) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
				wait.until(ExpectedConditions.titleIs(title));
				return driver.getTitle();
			}
			public  String WaitPractialURL (String partialUrl, int timeout) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
				wait.until(ExpectedConditions.titleContains(partialUrl));
				return driver.getCurrentUrl();
			}
				
				public  String WaitURL (String URL, int timeout) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
					wait.until(ExpectedConditions.titleIs(URL));
					return driver.getCurrentUrl();
				}
				
				public WebElement FluentWebDriverWait (By locator, int timeout, int pollingtime) {
					Wait <WebDriver> wait = new FluentWait <WebDriver> (driver)
			                .withTimeout(Duration.ofSeconds(timeout))
			                .pollingEvery(Duration.ofSeconds(pollingtime))
			                .ignoring(NoSuchElementException.class)
			                .ignoring(StaleElementReferenceException.class)
			                .withMessage("Element not found");
				
			            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
				
				public  WebElement FluentWebDriverWaitPresence  (By locator, int timeout, int pollingtime) {
					Wait <WebDriver> wait = new FluentWait <WebDriver> (driver)
			                .withTimeout(Duration.ofSeconds(timeout))
			                .pollingEvery(Duration.ofSeconds(pollingtime))
			                .ignoring(NoSuchElementException.class)
			                .ignoring(StaleElementReferenceException.class)
			                .withMessage("Element not found");
				
			            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}
			
		public WebElement getElement(By locator) {
			WebElement element = driver.findElement(locator);
			highlight(element);
			return element;
//			return driver.findElement(locator);
		}
		
		private void highlight(WebElement element) {
			if (Boolean.parseBoolean(DriverFactory.highlight)) {
				 jsUtil.flash(element);
		}
		}
		public boolean isElementDisplayed(By locator) {
			getElement(locator).isDisplayed();
			return false;
		}

	}


