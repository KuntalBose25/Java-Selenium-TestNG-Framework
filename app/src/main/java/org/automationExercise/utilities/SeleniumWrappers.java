package org.automationExercise.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWrappers {

    public static boolean clickWrapper(WebElement elementToBeClicked, WebDriver driver) {

        try {
            if (elementToBeClicked.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToBeClicked);
                elementToBeClicked.click();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean sendKeysWrapper(WebElement inputTextBox, String input, WebDriver driver) {

        try {
           
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputTextBox);
            inputTextBox.clear();
            inputTextBox.sendKeys(input);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



}
