package com.projecttest.pages;

import com.projecttest.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SubTabwomenDressPage extends TestBase {
    //Page Factory
    //Capture women SubTab
    @FindBy(linkText = "Women")
    WebElement womenSubTab;

    //Capture the ListView
    @FindBy(id = "list")
    WebElement listviewIcon;

    //Capture the AddtoCart Button
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[2]/a[1]")
    WebElement addToCartBtn;

    //Capture the CheckOutProcess Button
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement checkOutBtn;

    //Capture the CheckOutProcess Button Cart Process
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement checkOutContinueBtn;

    //Capture Sign In Tab Drop down
    @FindBy(id = "id_address_delivery")
    WebElement deliveryDropDown;

    //Capture Proceed Button in the AddressField
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement checkOutBtnAdress;

    ////*[@id="form"]/p/button
    //Capture the terms check box
    @FindBy(id = "uniform-cgv")
    WebElement termsCheckBox;

    //Capture the check out button shipping
    @FindBy(name="processCarrier")
    WebElement check1outBtnShipping;

    //Capture the Bank Card Payment Button
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement bankCardSelctBtn;

    //Capture Order Confirm Button
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement bankConfirmOrder;

    //Capture Order Confirmation
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    WebElement orderconfirmationCompleteTitile;

    // Initializing the Page Objects:
    public SubTabwomenDressPage(){
        PageFactory.initElements(driver, this);
    }

    //    //Actions
//    public void validateCheckOutProcess() {
//        womenSubTab.click();
//        listviewIcon.click();
//        driver.manage().timeouts().implicitlyWait(100L, TimeUnit.MILLISECONDS);
//        addToCartBtn.click();
//    }
    public void isDisplayedCheckoutWindow() {
        womenSubTab.click();
        listviewIcon.click();
        driver.manage().timeouts().implicitlyWait(100L, TimeUnit.MILLISECONDS);
        addToCartBtn.click();
        womenSubTab.click();
        listviewIcon.click();
        driver.manage().timeouts().implicitlyWait(100L, TimeUnit.MILLISECONDS);
        addToCartBtn.click();

        // Store the current window handle
        //String winHandleBefore = driver.getWindowHandle();

        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().timeouts().implicitlyWait(100L, TimeUnit.MILLISECONDS);

        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutBtn);

        //Store the current window handle
        //String winHandleBefore = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutContinueBtn);

        //Address DropDwon
        Select select = new Select(deliveryDropDown);
        select.selectByVisibleText("weerasooriya12@yopmail.com");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutBtnAdress);

        //verify the Terms and condition check box;
        termsCheckBox.isDisplayed();
        termsCheckBox.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", check1outBtnShipping);

        //Verify the bank details Button
        bankCardSelctBtn.isDisplayed();
        bankCardSelctBtn.click();

        //Verify the Confirm Order button
        bankConfirmOrder.isDisplayed();
        bankConfirmOrder.click();
    }
}
