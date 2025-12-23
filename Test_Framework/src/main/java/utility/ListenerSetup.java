package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.TestBase;



public class ListenerSetup extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test execution satrted");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test execution completed and test cases Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test execution stopped and test case failed");
		TestUtils.takeSS(result.getName());
		System.out.println("Screenshot Captured and saved in screenshot folder");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test execution Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("");
	}

}

