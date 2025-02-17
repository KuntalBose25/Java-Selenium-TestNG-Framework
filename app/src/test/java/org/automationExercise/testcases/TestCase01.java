package org.automationExercise.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

import org.automationExercise.pageobjects.AccountCreatedPage;
import org.automationExercise.pageobjects.AutomationExercisePage;
import org.automationExercise.pageobjects.DeleteAccountPage;
import org.automationExercise.pageobjects.HomePage;
import org.automationExercise.pageobjects.SignUpPage;
import org.automationExercise.pageobjects.RegistrationPage;
import org.automationExercise.utilities.Base;
import org.automationExercise.utilities.Data;
import org.automationExercise.utilities.SingletonDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestCase01 extends Base {

    public static WebDriver driver;

    public TestCase01() {
        driver = SingletonDriver.getDriver();
    }

    @Test(dataProvider = "excelData", dataProviderClass = Data.class)
    public void testRegistrationPage(String username,String title,String pwd,String Bdate,
        String Bmnth,String BYear,String cbox1,String cbox2,String first_name,String last_name,
        String company,String add1,String add2,String cntry,String state,
        String city,String zip,String ph) throws InterruptedException {

        HomePage homepage = new HomePage(driver);
        SignUpPage signuppage = new SignUpPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        AccountCreatedPage accountpage = new AccountCreatedPage(driver);
        AutomationExercisePage automationexercisepage = new AutomationExercisePage(driver);
        DeleteAccountPage deleteaccountpage=new DeleteAccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String uuid = UUID.randomUUID().toString();
        String email = username+uuid+"@test.com";
        System.out.println(email);
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com/");

        
        //3. Verify that home page is visible successfully
        Assert.assertTrue(homepage.isHomePageDisplayed());
        //4. Click on 'Signup / Login' button
        homepage.homePageOperation();
        wait.until(ExpectedConditions.visibilityOf(SignUpPage.loginPageText));
        Thread.sleep(2000);

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(signuppage.isSignUpPageDisplayed());

        //6. Enter name and email address
        //7. Click 'Signup' button
        signuppage.signUpPageOperation(username, email);
        Thread.sleep(5000);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(registrationPage.isRegistrationPageDisplayed());
        registrationPage.isRegistrationPageDisplayed();
        
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        registrationPage.registerNewUser(title,pwd,Bdate,Bmnth,BYear,cbox1,cbox2,
        first_name,last_name,company,add1,add2,cntry,state,city,zip,ph);
        Thread.sleep(5000);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        Assert.assertTrue(accountpage.isAccountCreationMsgDisplayed());
        accountpage.accountCreateConfirmationPage();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(automationexercisepage.isLoggedInAsUserNameVisible(username));

        //17. Click 'Delete Account' button
        automationexercisepage.automationExerciseLandingPage();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        Assert.assertTrue(deleteaccountpage.isAccountDeleted());
        deleteaccountpage.clickToContinue();

        

    }




    
    
}
