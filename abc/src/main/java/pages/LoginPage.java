package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login")
    private WebElement btnLogin;

    public void open(String url) {
        driver.get(url);
    }

    public void enterUsername(String user) {
        txtUsername.clear();
        txtUsername.sendKeys(user);
    }

    public void enterPassword(String pass) {
        txtPassword.clear();
        txtPassword.sendKeys(pass);
    }

    public void clickLogin() {
        btnLogin.click();
    }
}
