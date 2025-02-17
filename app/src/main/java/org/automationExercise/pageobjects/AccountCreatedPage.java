package org.automationExercise.pageobjects;

import org.automationExercise.utilities.SeleniumWrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class AccountCreatedPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[contains(@class,'text-center')]")
    private WebElement accountCreationPageTitle;

    @FindBy(xpath = "//*[text()='Continue']")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public boolean isAccountCreationMsgDisplayed() {
        if(this.accountCreationPageTitle.isDisplayed() &&
        this.accountCreationPageTitle.getText().equalsIgnoreCase("Account Created!")) {
            return true;
        } else {
            return false;
        }

    }

    
    
    public void accountCreateConfirmationPage() {

        SeleniumWrappers.clickWrapper(continueButton, driver);
        
    }


}
