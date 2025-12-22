package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class ProductsPage extends BaseClass {

    WebDriverWait wait;
    JavascriptExecutor js;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement Product;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement Enterproduct;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement SearchClick;

    @FindBy(xpath = "//div[5]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement ViewProduct;

    @FindBy(xpath = "//button[@type='button']")
    WebElement AddToCart;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    WebElement ContinueShopping;

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    WebElement LogoClick;

    @FindBy(xpath = "//div[3]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement ViewProduct1;

    @FindBy(xpath = "//div[13]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement ViewProduct2;
    
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try {
            Thread.sleep(500); // to allow ads overlay to move
        } catch (InterruptedException e) {}
    }

    public void clickSafe(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void Product() {

        wait.until(ExpectedConditions.elementToBeClickable(Product)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Enterproduct)).sendKeys("Tops");
        wait.until(ExpectedConditions.elementToBeClickable(SearchClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ViewProduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AddToCart)).click();
        wait.until(ExpectedConditions.visibilityOf(ContinueShopping)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LogoClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ViewProduct1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AddToCart)).click();
        wait.until(ExpectedConditions.visibilityOf(ContinueShopping)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LogoClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ViewProduct2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AddToCart)).click();
        wait.until(ExpectedConditions.visibilityOf(ContinueShopping)).click();
    }
}
