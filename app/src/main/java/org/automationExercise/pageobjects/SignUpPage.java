package org.automationExercise.pageobjects;

import org.automationExercise.utilities.SeleniumWrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignUpPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[text()='New User Signup!']")
    public static WebElement loginPageText;

    @FindBy(name = "name")
    private WebElement userName;

    @FindBy(xpath="//div[@class='signup-form']//input[@name='email']")
    private WebElement userEmail;

    @FindBy(xpath = "//*[text()='Signup']")
    private WebElement signupButton;

    

    ////*[text()='Enter Account Information']

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public boolean isSignUpPageDisplayed() {
        if(loginPageText.isDisplayed() 
        && loginPageText.getText().equals("New User Signup!")) {
            return true;
        } else {
            return false;
        }
    }

    

    public void signUpPageOperation(String inputUserName,String inputEmail)
    {
        
        SeleniumWrappers.sendKeysWrapper(userName, inputUserName, driver);
        SeleniumWrappers.sendKeysWrapper(userEmail, inputEmail, driver);
        SeleniumWrappers.clickWrapper(signupButton, driver);
        
    }




    
}
