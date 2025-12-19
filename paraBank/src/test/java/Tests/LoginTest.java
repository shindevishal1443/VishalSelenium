package Tests;

import org.testng.annotations.Test;

import Pages.BankDetails;
import Pages.Flightselection;
import Pages.LoginPage;
import Pages.Passanger;
import base.baseClass;

public class LoginTest extends baseClass{
	
	
				
	@Test
	public void TestCases() {
		LoginPage login= new LoginPage(driver);

	login.EnterUsername();
	login.EnterPassward();
	login.LoginButton();
	login.VerifyMessage();
	
	
	Flightselection Flight=new Flightselection(driver);
	
	
	Flight.Orgin("Sydney");
	Flight.Destination("New York");
	Flight.Depart("2");
	Flight.Return("June 2026");
	Flight.flightTime();
	Flight.Next();
	
	
	
	Passanger P= new Passanger(driver);
	P.EnterFirstname();
	P.EnterLastname();
	P.NextPage();
	
	
	BankDetails D= new BankDetails(driver);
	D.Card();
	D.Cnumber();
	D.month("11");
	D.Year("2028");
	D.Pay();
	D.Confirm();
	D.Bnumber();
	D.Logoff();
	D.Sign();
	
	}
	
	
	
	
	
	
	
		
	}


