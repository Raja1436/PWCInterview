package com.pwc.util;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pwc.pageobject.FlipkartPage;

public class RunnerClass {
	
	@BeforeClass
	public void BrowserSetup() {
		BrowserSetup.browserSetup();
		BrowserSetup browserSetup = new BrowserSetup();
		PropertyFileReader prop = new PropertyFileReader();
		PropertyFileReader.getInputValue("url");
	}
	
	@Test
	public void AddCartSuccess() {
		FlipkartPage flipkartPage = new FlipkartPage();
		PropertyFileReader prop = new PropertyFileReader();
		ReusableMethods reusableMethods = new ReusableMethods();
		flipkartPage.clickCloseIcon();
		flipkartPage.entervalueInsearchBox(prop.getInputValue("searchValue"));
		flipkartPage.clickSearchicon();
		flipkartPage.waittillReleventPresent();
		flipkartPage.clickMobilefromlist(1);
		reusableMethods.SwitchToTab(1);
		flipkartPage.clickAddToCart();
		flipkartPage.verifyElementAddedToCart();
		BrowserSetup.driver.close();
		reusableMethods.SwitchToTab(0);
	}
	
	@Test
	public void AddcartFailure() throws Exception {
		FlipkartPage flipkartPage = new FlipkartPage();
		PropertyFileReader prop = new PropertyFileReader();
		ReusableMethods reusableMethods = new ReusableMethods();
		flipkartPage.clickMobilefromlist(2);
		reusableMethods.SwitchToTab(1);
		flipkartPage.clickbecomeasaler();
		flipkartPage.verifycartElement();
		reusableMethods.takeScreenshot();
		
	}
	
	
	@AfterClass
	public void quitDriver() {
		BrowserSetup.driver.quit();
	}
	

}
