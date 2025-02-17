package org.automationExercise.pageobjects;

import org.automationExercise.utilities.SeleniumWrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DeleteAccountPage {
    
    private WebDriver driver;

    @FindBy(xpath = "//div/h2/b")
    private WebElement deleteAccountConfirmationText;

    @FindBy(xpath="//*[text()='Continue']")
    private WebElement continueButton;

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void clickToContinue() {

        SeleniumWrappers.clickWrapper(continueButton, driver);
    }

    public boolean isAccountDeleted() {
        if(this.deleteAccountConfirmationText.isDisplayed() &&
        this.deleteAccountConfirmationText.getText().equalsIgnoreCase("Account Deleted!")) {
            return true;
        } else {
            return false;
        }

    }


}
