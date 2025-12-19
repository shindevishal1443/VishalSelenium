package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.baseClass;

public class BankDetails extends baseClass{
	
	public WebDriverWait wait;
	
	public BankDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	
	@FindBy(xpath="//input[@value='visa']")
	WebElement Cardtype;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement Cardnumber;
	
	@FindBy(xpath="//select[@name='expiry_month']")
	WebElement Expirymonth;
	
	@FindBy(xpath="//select[@name='expiry_year']")
	WebElement ExpiryYear;
	
	@FindBy(xpath="//input[@value='Pay now']")
	WebElement Paynow;
	
	@FindBy(xpath="//h2[normalize-space()='Confirmation']")
	WebElement Confirm;
	
	@FindBy(css = "div#confirmation p:nth-of-type(1)")
	WebElement Bookingnumber;

	
	@FindBy(xpath="//a[normalize-space()='Sign off (agileway)']")
	WebElement Signoff;
	
	@FindBy(xpath="//div[@id='flash_notice']")
	WebElement signout;
	
	
	public void Card() {
		wait.until(ExpectedConditions.elementToBeClickable(Cardtype)).click();;

	}
	
	public void Cnumber() {
		wait.until(ExpectedConditions.elementToBeClickable(Cardnumber)).sendKeys("1234567891011");

	}
	
	public void month(String Month) {
		wait.until(ExpectedConditions.elementToBeClickable(Expirymonth));
		Select B1=new Select(Expirymonth);
		B1.selectByContainsVisibleText(Month);

	}
	
	public void Year(String Year) {
		wait.until(ExpectedConditions.elementToBeClickable(ExpiryYear));
		Select C1=new Select(ExpiryYear);
		C1.selectByContainsVisibleText(Year);
	}
	
	public void Pay() {
		wait.until(ExpectedConditions.elementToBeClickable(Paynow)).click();
	}
	
	public void Confirm() {
	    wait.until(ExpectedConditions.visibilityOf(Confirm));
	    
	    String actual = Confirm.getText().trim();
	    Assert.assertEquals(actual, "Confirmation", "Confirmation text mismatch!");
	}

	
	public void Bnumber() {
		wait.until(ExpectedConditions.elementToBeClickable(Bookingnumber));
		System.out.println(Bookingnumber.getText().trim());
	}
	
	public void Logoff() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Signoff)).click();
	}
	
	public void Sign() {
		wait.until(ExpectedConditions.elementToBeClickable(signout));
		
		String s=signout.getText().trim();
		Assert.assertEquals(s, "Signed out!");
		System.out.println("Logout is sucessfully");
	}
}
