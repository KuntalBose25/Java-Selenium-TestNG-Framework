package org.automationExercise.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonDriver {
    
        private static WebDriver driver;
    
        private SingletonDriver() {
        }
    
        public static WebDriver getDriver() {
            if (driver == null) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            return driver;
        }
    
    
}
