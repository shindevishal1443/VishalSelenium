package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import pageLayer.AdminBoard;
import pageLayer.DashBoard;
import pageLayer.LoginPage;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	public SoftAssert soft = new SoftAssert();

	// Object of pageLayer classes
	public LoginPage login;
	public DashBoard dashBoard;
	public AdminBoard admin;

	@BeforeClass
	public void setup() {

		if (driver == null) {
			try {
				fr = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\utility\\Config.Property");
				prop.load(fr);
			} catch (IOException e) {
			}
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));

//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get(prop.getProperty("testurl"));
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
		}
		
		
		login = new LoginPage(driver);
		dashBoard = new DashBoard(driver);
		admin = new AdminBoard(driver);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}