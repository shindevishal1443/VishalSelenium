package Utils;


import org.testng.ITestListener;
import org.testng.ITestResult;

import base.baseClass;

public class Listerner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("🔥 Listener Triggered: Test Failed");

        try {
            baseClass bc = (baseClass) result.getInstance();

            String screenshotPath = bc.tScreenshot(result.getName());

            System.out.println("❌ Test Failed: " + result.getName());
            System.out.println("📸 Screenshot saved at: " + screenshotPath);

        } catch (Exception e) {
            System.out.println("Screenshot not taken: " + e.getMessage());
        }
    }
}
