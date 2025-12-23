package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testBase.TestBase;

public class LoginPage extends TestBase {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "")
	private WebElement Usernamebox;

	@FindBy(xpath = "")
	private WebElement passwordbox;

	@FindBy(xpath = "")
	private WebElement loginButton;

	@FindBy(xpath = "")
	private WebElement ForgotPassword;

	@FindBy(xpath = "")
	private WebElement UserNameValidationMsg;

	@FindBy(xpath = "")
	private WebElement PasswordValidationMsg;

	@FindBy(xpath = "")
	private WebElement InvalidCredentials;

	public void LoginWithAdmin() {
		wait.until(ExpectedConditions.elementToBeClickable(Usernamebox)).click();
		wait.until(ExpectedConditions.visibilityOf(Usernamebox)).sendKeys(prop.getProperty("adminusername"));
		wait.until(ExpectedConditions.visibilityOf(passwordbox)).sendKeys(prop.getProperty("adminpassword"));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	public void LoginWithUser1() {
		wait.until(ExpectedConditions.visibilityOf(Usernamebox)).sendKeys(prop.getProperty("user1Username"));
		wait.until(ExpectedConditions.visibilityOf(passwordbox)).sendKeys(prop.getProperty("user1Password"));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	public void loginWithCredentials(String username, String passward) {
		wait.until(ExpectedConditions.visibilityOf(Usernamebox)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordbox)).sendKeys(passward);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	public void loginMendetoryFieldsValidation() {

		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		wait.until(ExpectedConditions.visibilityOf(UserNameValidationMsg));
		wait.until(ExpectedConditions.visibilityOf(PasswordValidationMsg));

		soft.assertTrue(UserNameValidationMsg.isDisplayed(), "error not displayed");
		soft.assertTrue(PasswordValidationMsg.isDisplayed(), "error not displayed");

		String actualUserNameText = UserNameValidationMsg.getText().trim();
		soft.assertEquals(actualUserNameText, "Required", "Username validation mismatch");

		String actualPasswordText = PasswordValidationMsg.getText().trim();
		soft.assertEquals(actualPasswordText, "Required", "Password validation mismatch");

		soft.assertAll();
	}

	public void loginWithWrongUserName(String username, String password) {
		wait.until(ExpectedConditions.visibilityOf(Usernamebox)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordbox)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		wait.until(ExpectedConditions.visibilityOf(InvalidCredentials));
		soft.assertTrue(InvalidCredentials.isDisplayed(), "Invalid credentials message not displayed");

		String actualText = InvalidCredentials.getText().trim();
		String expectedText = "Invalid credentials";
		soft.assertEquals(actualText, expectedText, "Invalid credentials text mismatch");

		soft.assertAll();
	}

	public void loginWithWrongPassword(String username, String passward) {
		wait.until(ExpectedConditions.visibilityOf(Usernamebox)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordbox)).sendKeys(passward);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		wait.until(ExpectedConditions.visibilityOf(InvalidCredentials));
		soft.assertTrue(InvalidCredentials.isDisplayed(), "Invalid credentials message not displayed");

		String actualText = InvalidCredentials.getText().trim();
		String expectedText = "Invalid credentials";
		soft.assertEquals(actualText, expectedText, "Invalid credentials text mismatch");

		soft.assertAll();
	}

	public void ForgotPassword() {
		wait.until(ExpectedConditions.elementToBeClickable(ForgotPassword)).click();

	}

}