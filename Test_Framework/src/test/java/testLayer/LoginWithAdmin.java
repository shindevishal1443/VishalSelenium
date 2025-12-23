package testLayer;

import org.testng.annotations.Test;
import testBase.TestBase;

public class LoginWithAdmin extends TestBase {

	@Test
	public void AdminLogin() {
		login.LoginWithAdmin();
	}
}
