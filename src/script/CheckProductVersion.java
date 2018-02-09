package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTTPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest {
	@Test
	public void testProductVersion() {
		LoginPage l= new LoginPage(driver);
		l.verifyPageIsDisplayed(driver, Excel.getData(XL_PATH, "CheckProductVersion", 1, 0));
		l.setUserName(Excel.getData(XL_PATH, "CheckProductVersion", 1, 1));
		l.setPassword(Excel.getData(XL_PATH, "CheckProductVersion", 1, 2));
		l.clickLogin();
		l.verifyPageIsDisplayed(driver, Excel.getData(XL_PATH, "CheckProductVersion", 1, 3));
		EnterTTPage et = new EnterTTPage(driver);
		et.clickHelp();
		et.clickAboutActiTIME();
		et.verifyVersion(Excel.getData(XL_PATH, "CheckProductVersion", 1, 4));
		et.clickCloseButton();
		et.clickLogout();
		
	}
}
