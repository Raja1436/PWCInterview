package com.pwc.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
	
	public static WebDriver driver;
	ReusableMethods reusableMethods = new ReusableMethods();
	
	public static void browserSetup() {
		String chromePath = System.getProperty("user.dir")+"/lib/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public boolean LoadUrl(String url) {
		driver.get(url);
		String title = reusableMethods.getTitle();
		if(title.contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle")) {
			System.out.println("Browser loaded successfully");
			return true;
		}else {
			System.out.println("Fail to load browser properly");
			return false;
		}
	}
	
	

}
