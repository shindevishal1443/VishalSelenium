package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class SignUp extends BaseClass {
	public WebDriverWait wait;
	
	public SignUp(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement Signup;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement Name;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement Email;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement Button;
	
    @FindBy(xpath="//input[@id='id_gender1']")
    WebElement Title;
   
    @FindBy(xpath="//input[@id='password']")
    WebElement Passward;
   
    @FindBy(xpath="//select[@id='days']")
    WebElement Day;
    
    @FindBy(xpath="//select[@id='months']")
    WebElement Month;
    
    @FindBy(xpath="//select[@id='years']")
    WebElement Year;
    
    @FindBy(xpath="//input[@id='optin']")
    WebElement Checkbox;
    
    @FindBy(xpath="//input[@id='first_name']")
    WebElement FirstName;
    
    @FindBy(xpath="//input[@id='last_name']")
    WebElement Lastname;
    
    @FindBy(xpath="//input[@id='company']")
    WebElement Company;
    
    @FindBy(xpath="//input[@id='address1']")
    WebElement Address;
    
    @FindBy(xpath="//input[@id='address2']")
    WebElement Address2;
    
    @FindBy(xpath="//select[@id='country']")
    WebElement Country;
    
    @FindBy(xpath="//input[@id='state']")
    WebElement State;
    
    @FindBy(xpath="//input[@id='city']")
    WebElement City;
    
    @FindBy(xpath="//input[@id='zipcode']")
    WebElement Zipcode;
    
    @FindBy(xpath="//input[@id='mobile_number']")
    WebElement Mobile;
    
    @FindBy(xpath="//button[normalize-space()='Create Account']")
    WebElement Createaccount;
    
    
    
    	
    
    public void Open() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(Signup)).click();
    
    }
    
    public void name() {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(Name)).sendKeys("Rahil PAtil");
    }
   
   public void email() {
	   
	   wait.until(ExpectedConditions.elementToBeClickable(Email)).sendKeys("Rahul.patil@tntra.io");
   }
   
   public void button() {
	   
	   wait.until(ExpectedConditions.elementToBeClickable(Button)).click();
   }
   
   public void title() {
	   
	   wait.until(ExpectedConditions.elementToBeClickable(Title)).click();
   }
   
   public void passward() {
	   
	   wait.until(ExpectedConditions.elementToBeClickable(Passward)).sendKeys("Vishal@1995");
   }
   
   public void day() {
	   wait.until(ExpectedConditions.elementToBeClickable(Day));
	   
	   Select D=new Select(Day);
	   D.selectByValue("5");
   }
   
   public void month() {
	   wait.until(ExpectedConditions.elementToBeClickable(Month));
	   
	  Select M=new Select(Month);
	  M.selectByVisibleText("June");
   }
   
   public void year() {
	   wait.until(ExpectedConditions.elementToBeClickable(Year));
	   
	   Select Y=new Select(Year);
	   Y.selectByValue("1995");
   }
   
   public void checkbox() {
	   wait.until(ExpectedConditions.elementToBeClickable(Checkbox)).click();
   }
   
   public void firstname() {
	   wait.until(ExpectedConditions.elementToBeClickable(FirstName)).sendKeys("Vishal");
   }
   
   public void lastname() {
	   wait.until(ExpectedConditions.elementToBeClickable(Lastname)).sendKeys("Shinde");
   }
   
   public void company() {
	   wait.until(ExpectedConditions.elementToBeClickable(Company)).sendKeys("Cognizant");
   }
   
   public void address() {
	   wait.until(ExpectedConditions.elementToBeClickable(Address)).sendKeys("Vadodara");
   }
   
   public void address2() {
	   wait.until(ExpectedConditions.elementToBeClickable(Address2)).sendKeys("Nashik");
   }
   
   public void country() {
	   wait.until(ExpectedConditions.elementToBeClickable(Country));
	   
	   Select C=new Select(Country);
	   C.selectByVisibleText("Canada");
   }
   
   public void state() {
	   wait.until(ExpectedConditions.elementToBeClickable(State)).sendKeys("Gujrat");
   }
   
   public void city() {
	   wait.until(ExpectedConditions.elementToBeClickable(City)).sendKeys("Vadodara");
   }
   
   public void zipcode() {
	   wait.until(ExpectedConditions.elementToBeClickable(Zipcode)).sendKeys("390021");
   }
   
   public void mobile() {
	   wait.until(ExpectedConditions.elementToBeClickable(Mobile)).sendKeys("9552601442");
   }
   
   public void createaccount() {
	   wait.until(ExpectedConditions.elementToBeClickable(Createaccount)).click();
   }
}
