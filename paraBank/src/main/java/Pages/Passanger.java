package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.baseClass;

public class Passanger extends baseClass {
	public WebDriverWait wait;
	
	
	public Passanger(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath="//input[@name=\"passengerFirstName\"]")
	WebElement Name;
	
	@FindBy(xpath="//input[@name=\"passengerLastName\"]")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Move;
	
	
	public void EnterFirstname() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Name)).sendKeys("Vishal");
	}
	
	public void EnterLastname() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Lastname)).sendKeys("Shinde");
	}
	
	public void NextPage() {
		wait.until(ExpectedConditions.elementToBeClickable(Move)).click();
	}
}
