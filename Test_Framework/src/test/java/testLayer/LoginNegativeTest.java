package testLayer;

import org.testng.annotations.Test;

import testBase.TestBase;

public class LoginNegativeTest extends TestBase {

	@Test(priority = 1)
	public void MendetoryFiledValid() {
		login.loginMendetoryFieldsValidation();
	}

	@Test(priority = 2)
	public void LoginNegativeScenarios() {

		login.loginWithWrongUserName("yogesh", "admin123");
		login.loginWithWrongPassword("Admin", "123456");
	}
}
