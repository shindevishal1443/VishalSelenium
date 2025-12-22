package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.SignUp;

public class Register extends BaseClass {

	
	
	@Test
	
	public void Register() {
		
		SignUp Sign=new SignUp(driver);
		
		Sign.Open();
		Sign.name();
		Sign.email();
		Sign.button();
		Sign.title();
		Sign.passward();
		Sign.day();
		Sign.month();
		Sign.year();
		Sign.checkbox();
		Sign.firstname();
		Sign.lastname();
		Sign.company();
		Sign.address();
		Sign.address2();
		Sign.country();
		Sign.state();
		Sign.city();
		Sign.zipcode();
		Sign.mobile();
		Sign.createaccount();
		
	}
}
