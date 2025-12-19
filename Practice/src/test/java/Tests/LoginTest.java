package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Utils.ConfigClass;
import Utils.ExcelUtils;

public class LoginTest extends BaseClass {
	
	@Test
	public void TestCase1() {

	    //ExcelUtils excel = new ExcelUtils("C:\\Users\\visha\\eclipse-workspace\\Practice\\Login Data.xlsx");

	    //String username = excel.getCellData(6, 2);   // C7
	    //String password = excel.getCellData(6, 3);   // D7
	    //System.out.println("Username from Excel: " + username);
	    //System.out.println("Password from Excel: " + password);
		ConfigClass config = new ConfigClass();

	    String username = ConfigClass.get("username");
	    String password = ConfigClass.get("password");

	    System.out.println("Username: " + username);
	    System.out.println("Password: " + password);
	    pg.Login(username, password);
	}

	}
