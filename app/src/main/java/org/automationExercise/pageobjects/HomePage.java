package org.automationExercise.pageobjects;

import org.automationExercise.utilities.SeleniumWrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(id="slider-carousel")
    private WebElement homePageSlider;

    @FindBy(xpath = "//*[@href='/login']")
    private WebElement Signuplink;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public boolean isHomePageDisplayed() {
        if(homePageSlider.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void homePageOperation() {

        SeleniumWrappers.clickWrapper(Signuplink, driver);
    }




    
}
