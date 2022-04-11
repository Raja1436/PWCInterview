package com.pwc.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
	public WebDriver driver;
	WebDriverWait wait;

	public ReusableMethods() {
		this.driver=BrowserSetup.driver;
	}
	
	
	public boolean click(By oby) {
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(oby));
			driver.findElement(oby).click();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean type(By oby, String str) {
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfAllElementsLocatedBy(oby));
			driver.findElement(oby).clear();
			driver.findElement(oby).sendKeys(str);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkPresenceBySize(By oby) {
		if(driver.findElements(oby).size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean clickElementFromList(List<WebElement> elementlist, int no) {
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(elementlist.get(1)));
			elementlist.get(no).click();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String getText(By oby) {
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfAllElementsLocatedBy(oby));
			return driver.findElement(oby).getText();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	public boolean SwitchToTab(int no) {
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    if(tabs.size()>0) {
	    	driver.switchTo().window(tabs.get(no));
	    	return true;
	    }else {
			return false;
		}
	}
	public boolean waitTillObjectPresent(By oby) {
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfAllElementsLocatedBy(oby));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public void takeScreenshot() throws Exception {
		
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir")+"//lib//screenshot.png");
		FileUtils.copyFile(SrcFile, DestFile);
		
	}	
	public boolean waitForElementPresentWithPulling(List<WebElement> element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.of(10, (TemporalUnit) TimeUnit.SECONDS))
			       .pollingEvery(Duration.of(2, (TemporalUnit) TimeUnit.SECONDS))
			       .ignoring(NoSuchElementException.class);
			 
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			return true;
	}
	public boolean verifyElementBySmallsize(By oby) {
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(oby));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
		

}
