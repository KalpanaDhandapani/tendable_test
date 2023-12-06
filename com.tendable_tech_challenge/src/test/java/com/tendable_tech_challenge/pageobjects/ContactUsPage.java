package com.tendable_tech_challenge.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Object repository
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/button")
	WebElement marketingContactBtn;

	@FindBy(name = "fullName")
	WebElement txtFullName;

	@FindBy(name = "organisationName")
	WebElement txtOrganisationName;

	@FindBy(name = "cellPhone")
	WebElement txtCellPhone;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "jobRole")
	WebElement ddJobRole;

	@FindBy(name = "consentAgreed")
	WebElement rbtnConsentAgreedRadio;
	
	@FindBy(xpath = "//*[@id=\"contactMarketingPipedrive-163701\"]/div[10]/div/button")
	WebElement submitBtn;
	
	@FindBy(xpath ="//p[text()='Sorry, there was an error submitting the form. Please try again.']")
	WebElement errorMsg;

	public boolean createMarketingForm(String fName, String orgName, String cellPhone, String email, String jobRole) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		marketingContactBtn.click();
		txtFullName.sendKeys(fName);
		txtOrganisationName.sendKeys(orgName);
		txtCellPhone.sendKeys(cellPhone);
		txtEmail.sendKeys(email);
		new Select(ddJobRole).selectByVisibleText(jobRole);
		rbtnConsentAgreedRadio.click();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		//js.executeScript("arguments[0].scrollIntoView(true);",submitBtn);
		//submitBtn.click();
		new Actions(driver).moveToElement(submitBtn).click().build().perform();
		return errorMsg.isDisplayed();
	}
}
