package com.projecttest.pages;

import com.projecttest.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

    //Page Factory
    //Capture the Sign In Link
    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    //Capture the Email Text Field
    @FindBy(id = "email")
    WebElement emailTxtFld;

    //Capture Page Logo
    @FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
    WebElement loginPgLogo;

    //Capture the Password Text Field
    @FindBy(id = "passwd")
    WebElement paswordTxtFld;

    @FindBy(id="SubmitLogin")
    WebElement logInBtn;

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean validateWeblogoLoginmage(){
        return loginPgLogo.isDisplayed();
    }

    public HomePage login(String email, String pwd) {
        signInLink.click();
        emailTxtFld.sendKeys(email);
        paswordTxtFld.sendKeys(pwd);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", logInBtn);
        return new HomePage();
    }
}
