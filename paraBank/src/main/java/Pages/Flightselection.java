 package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.baseClass;

public class Flightselection extends baseClass {
	public WebDriverWait wait;
	
	   
	public Flightselection(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath="//select[@name='fromPort']")
	WebElement Origin;
	
	@FindBy(xpath="//select[@name='toPort']")
	WebElement Destination;
	
	@FindBy(xpath="//select[@name='departDay']")
	WebElement Departday;
	
	@FindBy(xpath="//select[@name='returnMonth']")
	WebElement Returning;
	
	@FindBy(xpath="//tbody/tr[2]/th[1]/input[1]")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement submit;
	
	public void Orgin(String Name) {
		wait.until(ExpectedConditions.elementToBeClickable(Origin));
		Select sel=new Select(Origin);
		sel.selectByContainsVisibleText(Name);;
	}
	
	public void Destination(String Name) {
		wait.until(ExpectedConditions.elementToBeClickable(Destination));
		Select sel=new Select(Destination);
		sel.selectByContainsVisibleText(Name);;
	}
	
	public void Depart(String day) {
		wait.until(ExpectedConditions.elementToBeClickable(Departday));
		Select A1= new Select(Departday);
		A1.selectByContainsVisibleText(day);
		
	}
	
	public void Return(String MonthYear) {
		wait.until(ExpectedConditions.elementToBeClickable(Returning));
		Select A2= new Select(Returning);
		A2.selectByVisibleText(MonthYear);
		
		
	}
	public void flightTime() {
		
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	}
	
	public void Next() {
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	}
		
	}

