package com.tendable_tech_challenge.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Object repository
	@FindBy(xpath="//img[@alt='Tendable Logo']")
	WebElement tendable;
	
	@FindBy(linkText="Our Story")
	WebElement ourStory;
	
	@FindBy(linkText="Our Solution")
	WebElement ourSolution;
	
	@FindBy(linkText="Why Tendable?")
	WebElement whyTendable;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	WebElement contactUs;
	
	@FindBy(linkText="Request a Demo")
	WebElement requestDemo;
	
	public void validateTendableLink() {
		tendable.click();
	}
	
	public void validateOurStory() {
		ourStory.click();
	}
	
	public void validateOurSolution() {
		ourSolution.click();
	}
	
	public boolean validateRequestDemo() {
		return requestDemo.isDisplayed();
	}
		
	public ContactUsPage validateContactUs() {
		//System.out.println("1111111111111");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		contactUs.click();
		//new Actions(driver).moveToElement(contactUs).doubleClick().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//System.out.println("222222222222222");
		return new ContactUsPage(driver);
	}
	
	
}
