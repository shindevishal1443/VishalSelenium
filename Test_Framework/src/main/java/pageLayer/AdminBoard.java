package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBase;

public class AdminBoard extends TestBase {

	public AdminBoard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	private WebElement AdminButton;

	@FindBy(xpath = "")
	private WebElement TopAdminText;

	public void NevigateToAdminPage() {
		wait.until(ExpectedConditions.elementToBeClickable(AdminButton)).click();
		wait.until(ExpectedConditions.visibilityOf(TopAdminText));
		String actualTopAdminText = TopAdminText.getText();
		soft.assertEquals(actualTopAdminText, "Admin", "Admin page verification failed!");
		
	}
}
