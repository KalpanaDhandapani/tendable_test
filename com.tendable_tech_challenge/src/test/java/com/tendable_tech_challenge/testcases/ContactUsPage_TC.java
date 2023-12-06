package com.tendable_tech_challenge.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tendable_tech_challenge.pageobjects.ContactUsPage;
import com.tendable_tech_challenge.pageobjects.HomePage;
import com.tendable_tech_challenge.testbase.TestBase;

public class ContactUsPage_TC extends TestBase{
	
	HomePage homePage;
	ContactUsPage contact;
	
	@Test
	public void createMarketingForm() {
		homePage = new HomePage(driver);
		contact = homePage.validateContactUs();		
		boolean status = contact.createMarketingForm("Test", "ABC", "9876543210", "abc@gmail.com", "Executive Board Member");
		Assert.assertTrue(status);
	}

}
