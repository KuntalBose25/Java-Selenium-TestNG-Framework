package org.automationExercise.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {

    public static WebDriver driver;

    @BeforeSuite(alwaysRun=true)
    public static void getDriver() {
        driver = SingletonDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        System.out.println("Creating Driver......");
        
    }

    @AfterSuite
    public static void quitDriver()
    {
        System.out.println("Driver quit.......");
        driver.quit();
        
    }
    
}
