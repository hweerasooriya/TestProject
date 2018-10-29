package test;

import com.projecttest.base.TestBase;
import com.projecttest.pages.HomePage;
import com.projecttest.pages.LoginPage;
import com.projecttest.pages.SubTabwomenDressPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutProcessTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SubTabwomenDressPage subTabwomenDressPage;

    public CheckOutProcessTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("emailAddress"), prop.getProperty("password"));

    }

    @Test(priority = 1,description = "Verify the CheckOut Process")
    public void verifyCheckOutPopupWindow() {
        subTabwomenDressPage = new SubTabwomenDressPage();
        subTabwomenDressPage.isDisplayedCheckoutWindow();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
