package org.automationExercise.pageobjects;

import org.automationExercise.utilities.SeleniumWrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class AutomationExercisePage {

    private WebDriver driver;

    @FindBy(xpath="//*[contains(@class,'fa-user')]/../b")
    private WebElement loggedUser;

    @FindBy(xpath="//a[@href='/delete_account']")
    private WebElement deleteAccountTab;

    
    public AutomationExercisePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void automationExerciseLandingPage() {

        SeleniumWrappers.clickWrapper(deleteAccountTab, driver);

    }


    public boolean isLoggedInAsUserNameVisible(String loggedUserName) {
        if(this.loggedUser.isDisplayed() &&
        this.loggedUser.getText().equalsIgnoreCase(loggedUserName)) {
            return true;
        } else {
            return false;
        }

         

    }
    



}
