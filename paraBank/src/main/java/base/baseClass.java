package base;


import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class baseClass {
	
	public WebDriver driver;

	
	public String tScreenshot(String screenshotname) {

	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String path = "C:\\Users\\visha\\eclipse-workspace\\paraBank\\Screenshot\\"
	                + screenshotname + "_" + System.currentTimeMillis() + ".png";

	        File dest = new File(path);
	        FileHandler.copy(src, dest);

	        return path;

	    } catch (Exception e) {
	        System.out.println("Screenshot failed: " + e.getMessage());
	        return null;
	    }
	}



	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
	
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		
		else {
			System.out.println("Browser not available");
		}

		driver.manage().window().maximize();
		driver.get("https://travel.agileway.net/login");
		
		
		
	}
	
	@AfterClass
	public void close() {
		if (driver != null) {
	        driver.quit();
	    }
		
	
	}}
