package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class LoginPage extends BaseClass{
	
	public WebDriverWait wait;

public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	private WebElement Signup;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	private WebElement Username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement Passward;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement Button;
	
	public void Login(String user, String pass) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Signup)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Username)).sendKeys(user);
		wait.until(ExpectedConditions.elementToBeClickable(Passward)).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
	}
	
	
}
