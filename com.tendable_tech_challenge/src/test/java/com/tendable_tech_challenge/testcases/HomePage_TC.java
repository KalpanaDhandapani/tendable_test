package com.tendable_tech_challenge.testcases;


import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tendable_tech_challenge.pageobjects.HomePage;
import com.tendable_tech_challenge.testbase.TestBase;



public class HomePage_TC extends TestBase {

	HomePage homePage;

	@Test(priority = 1)
	public void tendableLink() {
		homePage = new HomePage(driver);
		homePage.validateTendableLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertTrue(driver.getTitle().contains("Quality Improvement App | Health and Social Care | Tendable"));
		Assert.assertTrue(homePage.validateRequestDemo());
	}
	
	@Test(priority = 2)
	public void ourStory() {
		homePage.validateOurStory();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.tendable.com/our-story"));
		Assert.assertTrue(homePage.validateRequestDemo());
	}
	
	@Test(priority = 3)
	public void ourSolution() {
		homePage.validateOurSolution();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.tendable.com/our-solution"));
		Assert.assertTrue(homePage.validateRequestDemo());
	}
	
	@Test(priority = 4)
	public void whyTendable() {
		homePage.validateTendableLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("URL "+driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.tendable.com/"));
		Assert.assertTrue(homePage.validateRequestDemo());
	}
	
}
