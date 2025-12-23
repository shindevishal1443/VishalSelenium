package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import testBase.TestBase;


public class TestUtils extends TestBase {

	public static void takeSS(String name) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshots\\";
		File destination = new File(path + name + "_" + System.currentTimeMillis() + ".png");
		try {
			FileHandler.copy(src, destination);
		} catch (IOException e) {
			System.out.println("Please provide correct Path to save screenshot");
		}
	}

}
