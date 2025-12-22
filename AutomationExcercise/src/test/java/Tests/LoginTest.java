package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void TestCases() {
		
		LP.Login("vishal.shinde@tntra.io", "Vishal@1995");
		
	}

}

