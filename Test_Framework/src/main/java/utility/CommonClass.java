package utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import testBase.TestBase;

public class CommonClass extends TestBase {
	
	public static void waitForElementVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void Wait_ClickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void wait_ClearField(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
	}

	public static void ClearUsingCntrolA(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
	}

	public static void wait_SendText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}

	public static void wait_SendText_PressEnter(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text + Keys.ENTER);
	}
	
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	public static void selectDropdownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}

	public static void scroll_top() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");

	}
	
	public static void scroll_bottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public static void scrollBy200() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	public static void scrollup200() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)");
	}

	public static void randomBirthdateGen(WebElement element) {
		// Generate random birthdate
		LocalDate today = LocalDate.now();
		LocalDate maxDate = today.minusYears(18); // youngest
		LocalDate minDate = today.minusYears(60); // oldest

		long minDay = minDate.toEpochDay();
		long maxDay = maxDate.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay + 1);

		LocalDate randomBirthdate = LocalDate.ofEpochDay(randomDay);

		// Format as dd/MM/yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dobString = randomBirthdate.format(formatter);

		// Set value in input field
		element.sendKeys(dobString);
	}
//	public static String RandomEmailGenerator() {
//		Faker faker = new Faker();
//		String random_email = faker.internet().emailAddress();
//		return random_email;
//	}
//
//	public static String RandomNameGenerator() {
//		Faker faker = new Faker();
//		String random_name = faker.name().fullName();
//		return random_name;
//	}
//
//	public static String RandomWebsiteGenerator() {
//		Faker faker = new Faker();
//		String random_website = "https://www." + faker.internet().domainName();
//		return random_website;
//	}
//
//	public static String RandomMobileNumberGenerator() {
//		Faker faker = new Faker();
//		String random_number = faker.phoneNumber().cellPhone();
//		return random_number;
//	}

	public static String generateRandomName() {
		Random random = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// Generate the 5-character random name with at least one lowercase and one
		// uppercase letter
		StringBuilder name = new StringBuilder();
		name.append("abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26))); // Lowercase
		name.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(26))); // Uppercase
		for (int i = 2; i < 5; i++) {
			name.append(characters.charAt(random.nextInt(characters.length()))); // Random char
		}

		// Shuffle the name to randomize character positions
		return shuffleString(name.toString());
	}
	private static String shuffleString(String str) {
		Random random = new Random();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int j = random.nextInt(chars.length);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}
	public static String fillCurrentDateTime(WebDriver driver, String formate, WebElement Element) {
		// Get current date and time and format it in the required format
		String currentDateTime = new SimpleDateFormat(formate).format(new Date()); // Format: "DD/MM/YYYY hh:mm aa"

		// Locate the input field by its placeholder
		WebElement inputField = Element;

		// Clear any existing value in the input field (if necessary)
		inputField.clear();

		// Enter the current date and time into the input field
		inputField.sendKeys(currentDateTime);
		return currentDateTime;
	}
	
	
}