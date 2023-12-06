package com.tendable_tech_challenge.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static String applicationURL = "https://www.tendable.com";

	public static String chromeDriverPath = "C:\\Users\\dskal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new FirefoxDriver();

		driver.get(applicationURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();		
	}
	
}
