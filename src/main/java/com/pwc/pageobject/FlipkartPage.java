package com.pwc.pageobject;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.pwc.util.BrowserSetup;
import com.pwc.util.ReusableMethods;

public class FlipkartPage {

	public WebDriver driver;
	ReusableMethods reusableMethods;
	public FlipkartPage() {
		this.driver = BrowserSetup.driver;
		PageFactory.initElements(driver, this);
		reusableMethods =new ReusableMethods();
	}
	
	public By flipkartLoginClose = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	public By searchbox = By.xpath("//input[@class='_3704LK']");
	public By SearchIcon =By.xpath("//button[@class='L0Z3Pu']");
	public By MobileElementIcon = By.xpath("//div[@class='_1AtVbE col-12-12']//a[@class='_1fQZEK']/div[1]");
	public By addCart = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	public By myCart = By.xpath("//div[@class='_3g_HeN']");
	public By saller = By.xpath("//div[@class='go_DOp']//a[contains(@href,'seller')]");
	//GetText
	public By relevent = By.xpath("//div[@class='_10UF8M _3LsR0e']");
	
	public By elementNameINCart = By.xpath("//div[@class='_1AtVbE col-12-12']//a[@class='_2Kn22P gBNbID']");
	public By searchPageElementName = By.xpath("//div[@class='_1AtVbE col-12-12']//a[@class='_1fQZEK']//div[@class='_4rR01T']");
	
	@FindBy(xpath = "//div[@class='_1AtVbE col-12-12']//a[@class='_1fQZEK']/div[1]")
	List<WebElement> mobileList;
	
	
	public void clickCloseIcon() {
		if(reusableMethods.click(flipkartLoginClose) ==true) {
			System.out.println("success close cross icon");
		}else {
			System.out.println("Failed to click close icon");
		}
	}
	public void entervalueInsearchBox(String key) {
		reusableMethods.type(searchbox, key);
	}
	
	public void clickSearchicon() {
		reusableMethods.click(SearchIcon);
	}
	
	public void clickMobilefromlist(int no) {
		reusableMethods.clickElementFromList(mobileList, no);
	}
	
	public boolean waittillReleventPresent() {
		return reusableMethods.waitTillObjectPresent(relevent);
	}
	public void clickAddToCart() {
		reusableMethods.click(addCart);
	}
	
	public boolean VerifyElementPresent(int no) {
		return reusableMethods.waitForElementPresentWithPulling(mobileList);
	}
	
	public void verifyElementAddedToCart() {
		String cartName = reusableMethods.getText(myCart);
		if(cartName.contains("My Cart")) {
			System.out.println("element added to cart");
		}else {
			System.out.println("element not added to cart");
		}
	}
	
	public String cartAddedElementName() {
		return reusableMethods.getText(elementNameINCart);
	}
	
	public String GetSearchPageElementName() {
		return reusableMethods.getText(searchPageElementName);
	}
	
	public boolean clickbecomeasaler() {
		return reusableMethods.click(saller);
	}
	
	public void verifycartElement() {
		reusableMethods.verifyElementBySmallsize(myCart);
	}
	
	
	
	
	
	
	
	
	
	

}
