package Generic;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.Data;

public class BaseClass {

    WebDriver driver;

    
    public void initializeDriver() throws IOException {
    	
        switch (Data.getData("browser").toLowerCase()) {
        
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Browser not supported");
                break;
        }
        
        // Now that driver is initialized, you can safely set timeouts and maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url = Data.getData("url");

        // Navigate to the specified URL
        driver.get(url);
  
    }



public void toCloseBrowser() {
	 WebDriver driver = new FirefoxDriver();
    if (driver != null) {
        driver.quit();
    }
}
}
