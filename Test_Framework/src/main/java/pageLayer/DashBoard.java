package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBase;

public class DashBoard extends TestBase {

	public DashBoard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	private WebElement DashboardButton;

	@FindBy(xpath = "")
	private WebElement TopDashboardText;

	public void NevigateToDashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(DashboardButton)).click();
		wait.until(ExpectedConditions.visibilityOf(TopDashboardText));
		String actualTopDashboardText = TopDashboardText.getText();
		soft.assertEquals(actualTopDashboardText, "Dashboard", "Dashboard page verification failed!");

	}
}
