package com.tutorialsninja;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Data;
import Utilities.rdg;

public class registration {
	
	@Test(priority =1 )
	public void verifyRegistration() throws IOException {
	  	
	    WebDriver driver = new FirefoxDriver();

	    // Setting up the browser
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	    // Navigate to the registration page
	    driver.get(Data.getData("url"));

	    // Perform registration actions
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.linkText("Register")).click();

	    driver.findElement(By.id("input-firstname")).sendKeys("Darshan");
	    driver.findElement(By.id("input-lastname")).sendKeys("Sonawane");
	    driver.findElement(By.id("input-email")).sendKeys(rdg.getUniqueEmail());
	    driver.findElement(By.id("input-telephone")).sendKeys("8329216725");
	    driver.findElement(By.id("input-password")).sendKeys("D12345");
	    driver.findElement(By.id("input-confirm")).sendKeys("D12345");
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	   String actual = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
	   
	  String  Expected = "Your Account Has Been Created!";
	  
	  AssertJUnit.assertEquals(actual, Expected);
	  
	  driver.quit();

	}
	
	@Test(priority =2 )
	
	public void verifyRegistrationWithAllreadyUsedEmailID() throws IOException {
		
		WebDriver driver = new FirefoxDriver();

	    // Setting up the browser
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	    // Navigate to the registration page
	    driver.get(Data.getData("url"));

	    // Perform registration actions
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.linkText("Register")).click();

	    driver.findElement(By.id("input-firstname")).sendKeys("Darshan");
	    driver.findElement(By.id("input-lastname")).sendKeys("Sonawane");
	    driver.findElement(By.id("input-email")).sendKeys("darsh.sonawane@yahoo.com");
	    driver.findElement(By.id("input-telephone")).sendKeys("8329216725");
	    driver.findElement(By.id("input-password")).sendKeys("D12345");
	    driver.findElement(By.id("input-confirm")).sendKeys("D12345");
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
 
	    String  Expected = "Warning: E-Mail Address is already registered!";
	    
	    AssertJUnit.assertEquals(actual, Expected);
	    
	    driver.quit();
	
		
	}
	
	@Test(priority =3 )
	public void withoutAnyDetails() throws IOException {
		
		WebDriver driver = new FirefoxDriver();

	    // Setting up the browser
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	    // Navigate to the registration page
	    driver.get(Data.getData("url"));

	    // Perform registration actions
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.linkText("Register")).click();
	    
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    
	    String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	    
	    String  Expected = "Warning: You must agree to the Privacy Policy!";
	    
	    AssertJUnit.assertEquals(actual, Expected);
	    
	    driver.quit();
	}
}
