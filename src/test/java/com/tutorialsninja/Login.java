package com.tutorialsninja;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.BaseClass;
import Utilities.Data;
import Utilities.rdg;

public class Login extends BaseClass {

	
  @Test(priority = 1)
  public void verifyLoginWithValidCredentials() throws IOException {
	  
	  WebDriver driver = new FirefoxDriver();
	   // Setting up the browser
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

      SoftAssert Assert = new SoftAssert();
 
      AssertJUnit.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

      }
  
  
  @Test(priority = 2)
  
  public void verifyLoginWithInvalidCredentials() throws IOException {
	  
	  WebDriver driver = new FirefoxDriver();
	   // Setting up the browser
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

     // Navigate to the login page
     driver.get(Data.getData("url"));

      // Perform login actions
      driver.findElement(By.linkText("My Account")).click();
      driver.findElement(By.linkText("Login")).click();
      driver.findElement(By.id("input-email")).sendKeys(rdg.getUniqueEmail());
      driver.findElement(By.id("input-password")).sendKeys("Darsschan@123");
      driver.findElement(By.xpath("//input[@value='Login']")).click();

      SoftAssert Assert = new SoftAssert();
 
      String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
      
      String Expected = "Warning: No match for E-Mail Address and/or Password.";
      
      System.out.println(actual);
      
      AssertJUnit.assertEquals(actual, Expected);
      
      driver.quit();
       	
  }  
  
  @Test(priority = 3)
  public void verifyLoginWithValidEmailAdressAndInvalidPassword() throws IOException {
	
	  WebDriver driver = new FirefoxDriver();
	   // Setting up the browser
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

     // Navigate to the login page
     driver.get(Data.getData("url"));

      // Perform login actions
      driver.findElement(By.linkText("My Account")).click();
      driver.findElement(By.linkText("Login")).click();
      driver.findElement(By.id("input-email")).sendKeys("darsh.sonawane@yahoo.com");
      driver.findElement(By.id("input-password")).sendKeys("Darshan@123890");
      driver.findElement(By.xpath("//input[@value='Login']")).click();
      
      String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

       String Expected = "Warning: No match for E-Mail Address and/or Password.";
      
      System.out.println(actual);
      
      AssertJUnit.assertEquals(actual, Expected);
      driver.quit();
      }

  
  @Test(priority = 4)
  
  public void verifyWithoutCredentials() throws IOException {
	  
	  WebDriver driver = new FirefoxDriver();
	   // Setting up the browser
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

     // Navigate to the login page
     driver.get(Data.getData("url"));
      // Perform login actions
      driver.findElement(By.linkText("My Account")).click();
      driver.findElement(By.linkText("Login")).click();
      driver.findElement(By.id("input-email")).sendKeys("");
      driver.findElement(By.id("input-password")).sendKeys("");
      driver.findElement(By.xpath("//input[@value='Login']")).click();

      String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

      String Expected = "Warning: No match for E-Mail Address and/or Password.";
     
     System.out.println(actual);
     
     Assert.assertEquals(actual, Expected);
     driver.quit();
     
      }
 }
  
  


