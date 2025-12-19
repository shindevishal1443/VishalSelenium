package Pages;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.baseClass;

public class LoginPage extends baseClass {
	
	public WebDriverWait wait;
	
	
public  LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}


@FindBy(xpath="//input[@name='username']")
 WebElement Username;

@FindBy(xpath="//input[@name='password']")
WebElement Passward;

@FindBy(xpath="//input[@type='submit']")
WebElement Button;

@FindBy(xpath="//div[@id='flash_notice']")
WebElement Message;


public void EnterUsername() {
wait.until(ExpectedConditions.elementToBeClickable(Username)).sendKeys("agileway");
}

public void EnterPassward() {
	wait.until(ExpectedConditions.elementToBeClickable(Passward)).sendKeys("test$W1se");
}

public void LoginButton() {
	wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
}


public void VerifyMessage() {
	
	wait.until(ExpectedConditions.visibilityOf(Message));
	
	String actual= Message.getText().trim();
	String expected="Signed in!";
	
	Assert.assertEquals(actual, expected, "Login is failed");
		System.out.println("Login is sucesfully");
	}
	 
}

	
	

