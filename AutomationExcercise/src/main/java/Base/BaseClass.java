package Base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pages.LoginPage;
import Pages.ProductsPage;

public class BaseClass {
	
	public WebDriver driver;
    public	LoginPage LP;
   public  ProductsPage Pg;
	
	public String tScreenshot(String screenshotname) {

	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String path = "C:\\Users\\visha\\eclipse-workspace\\Practice\\Screenshots"
	                + screenshotname + "_" + System.currentTimeMillis() + ".png";

	        File dest = new File(path);
	        FileHandler.copy(src, dest);

	        return path;

	    } catch (Exception e) {
	        System.out.println("Screenshot failed: " + e.getMessage());
	        return null;
	    }
	}

  
	

	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional("chrome")String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		    
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			
			driver=new EdgeDriver();
		}
		
		else {
			
			System.out.println("Browser not Avaialble");
		}
		
		driver.get("https://automationexercise.com");
		driver.manage().window().maximize();
		
		LP=new LoginPage(driver);
		Pg=new ProductsPage(driver);
	}
	
	
// @AfterTest
//	public void Close() {
//		
//	driver.quit();
//	}

}
