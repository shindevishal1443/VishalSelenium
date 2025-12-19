package tests;

import base.BaseTest;
import factory.DriverFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtil;

import java.util.List;

public class DataDrivenLoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        String file = System.getProperty("user.dir") + "/test-data/login.xlsx";
        List<String[]> rows = ExcelUtil.readSheet(file, "Sheet1");
        Object[][] data = new Object[rows.size()][2];
        for (int i = 0; i < rows.size(); i++) {
            data[i][0] = rows.get(i)[0];
            data[i][1] = rows.get(i)[1];
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void loginFromExcel(String user, String pass) {
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.open("https://example.com/login");
        login.enterUsername(user);
        login.enterPassword(pass);
        login.clickLogin();
    }
}
