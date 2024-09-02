package com.tutorialsninja;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Data;

public class EmailAutomation {
	
	@Test

	public void sendEmail() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		

	    // Setting up the browser
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    

	    // Navigate to the registration page
	    driver.get(Data.getData("emailurl"));
	    
	    driver.findElement(By.id("login-username")).sendKeys(Data.getData("username"), Keys.ENTER);
		
	    driver.findElement(By.id("login-passwd")).sendKeys(Data.getData("password"),Keys.ENTER);
	    
	    driver.navigate().refresh();
	    
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Compose")));
	   
	   
       driver.findElement(By.xpath("//a[.=\"Compose\"]")).click();
	
	    
	    driver.findElement(By.xpath("//input[@id='message-to-field']")).sendKeys(Data.getData("CompanyMailID"));
	 
	    driver.findElement(By.xpath("//input[@id='compose-subject-input']")).sendKeys(Data.getData("subject"));
	    
	    driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys(Data.getData("emailbody"));
	    
	    driver.findElement(By.xpath("//button[@title='Attach files']")).click();
	    
	  WebElement attfile= driver.findElement(By.xpath("//li[@title='Attach files from computer']//button[@type='button']"));
	  attfile.click();
	  
	  Thread.sleep(3000);
	  
	  String filePath = "Darshan_Sonawane_SDET.pdf";
      uploadFileWithRobot(filePath);

      // Wait for the attachment to be uploaded 
      Thread.sleep(5000);

	
	 driver.findElement(By.xpath("//button[@title=\"Send this email\"]")).click();
  
	}
	
	
	 public static void uploadFileWithRobot(String filePath) throws Exception {
		 
		
	        // Create an instance of the Robot class
	        Robot robot = new Robot();

	        // Copy the file path to the clipboard
	        StringSelection selection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        // Press Ctrl + V to paste the file path
	        robot.delay(500); // Small delay to ensure the file dialog is in focus
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        // Press Enter to confirm the file upload
	        robot.delay(500); // Small delay to ensure the file path is pasted
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	}
	
