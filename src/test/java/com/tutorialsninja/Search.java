package com.tutorialsninja;
import org.testng.annotations.Test;

import Utilities.Data;

import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search {
	
	@Test(priority = 1)
	
	public void verifySearchWithValidProduct() throws IOException {
		
		 WebDriver driver = new FirefoxDriver();
		 
		 driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	      // Navigate to the login page
	      driver.get(Data.getData("url"));
	      
		 // Perform login actions
	      driver.findElement(By.linkText("My Account")).click();
	      driver.findElement(By.linkText("Login")).click();
	      driver.findElement(By.id("input-email")).sendKeys("darsh.sonawane@yahoo.com");
	      driver.findElement(By.id("input-password")).sendKeys("Darshan@123");
	      driver.findElement(By.xpath("//input[@value='Login']")).click();

		
		driver.findElement(By.xpath("//input[contains(@class,'input-lg')]")).sendKeys("HP", Keys.ENTER);

		driver.findElement(By.linkText("HP LP3065")).isDisplayed();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		driver.quit();
	}
	
	@Test(priority = -1)
	public void verifySearchWithInvalidProduct() throws IOException {

		 WebDriver driver = new FirefoxDriver();
		 
		 driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	      // Navigate to the login page
	      driver.get(Data.getData("url"));
	      
		 // Perform login actions
	      driver.findElement(By.linkText("My Account")).click();
	      driver.findElement(By.linkText("Login")).click();
	      driver.findElement(By.id("input-email")).sendKeys("darsh.sonawane@yahoo.com");
	      driver.findElement(By.id("input-password")).sendKeys("Darshan@123");
	      driver.findElement(By.xpath("//input[@value='Login']")).click();

		
		driver.findElement(By.xpath("//input[contains(@class,'input-lg')]")).sendKeys("bcjf", Keys.ENTER);

		String actual = driver.findElement(By.xpath("//div[@id=\"content\"]/h2/following-sibling::p")).getText();
		
		AssertJUnit.assertEquals(actual, "There is no product that matches the search criteria.");
		
		driver.quit();
	}
	
	
	@Test(priority = -1)
	
	public void verifySearchWithoutAnyProduct() throws IOException {
		
		
		 WebDriver driver = new FirefoxDriver();
		 
		 driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	      // Navigate to the login page
	      driver.get(Data.getData("url"));
	      
		 // Perform login actions
	      driver.findElement(By.linkText("My Account")).click();
	      driver.findElement(By.linkText("Login")).click();
	      driver.findElement(By.id("input-email")).sendKeys("darsh.sonawane@yahoo.com");
	      driver.findElement(By.id("input-password")).sendKeys("Darshan@123");
	      driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]"));
		boolean actual = driver.findElement(By.xpath("//div[@id=\"content\"]/h2/following-sibling::p")).isDisplayed();
		Assert.assertTrue(actual,"Ohh there is a product for this");
		driver.quit();
	}

}
