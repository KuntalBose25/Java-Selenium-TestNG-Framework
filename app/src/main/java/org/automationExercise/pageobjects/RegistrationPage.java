package org.automationExercise.pageobjects;

import org.automationExercise.utilities.SeleniumWrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    // TestNG listener & extent report
    // adding notes
    private WebDriver driver;


    //@FindBy(xpath = "//input[@name='title'][@value='Mr']")
    //public WebElement titleRadioButton;

    @FindBy(id = "password")
    private WebElement setPassword;

    @FindBy(xpath = "//*[@id='days']")
    private WebElement birthDate;

    @FindBy(xpath = "//*[@id='months']")
    private WebElement birthMonth;

    @FindBy(xpath = "//*[@id='years']")
    private WebElement birthYear;

    @FindBy(id = "newsletter")
    private WebElement checkBox1;

    @FindBy(id = "optin")
    private WebElement checkBox2;

    @FindBy(id = "first_name")
    private WebElement firstNameTextBox;

    @FindBy(id = "last_name")
    private WebElement lastNameTextBox;

    @FindBy(id = "company")
    private WebElement companyTextBox;

    @FindBy(id = "address1")
    private WebElement addressline1;

    @FindBy(id = "address2")
    private WebElement addressline2;

    @FindBy(xpath = "//*[@id='country']")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateTextbox;

    @FindBy(id = "city")
    private WebElement cityTextbox;

    @FindBy(id = "zipcode")
    private WebElement ZipTextbox;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumbertextbox;

    @FindBy(xpath = "//*[text()='Create Account']")
    private WebElement CreateAcccountButton;

    @FindBy(xpath = "//div/h2/b")
    private WebElement registrationPageTitle;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void titleSelection(String inputtitle) {

        String xpth = "//input[@name='title'][@value='" + inputtitle + "']";

        WebElement titleRadioSelect = driver.findElement(By.xpath(xpth));
        titleRadioSelect.click();

    }

    public void selectDobFromDropdown(String day, String month, String Year) {

        Select date = new Select(birthDate);
        date.selectByValue(day);

        Select bmonth = new Select(birthMonth);
        bmonth.selectByValue(month);

        Select year = new Select(birthYear);
        year.selectByValue(Year);

    }

    public void selectCountryFromDropdown(String Country) {
        Select cntry = new Select(countryDropdown);
        cntry.selectByValue(Country);

    }

    public boolean isRegistrationPageDisplayed() {
        if (registrationPageTitle.isDisplayed()
                && registrationPageTitle.getText().equalsIgnoreCase("Enter Account Information")) {

            return true;
        } else {
            System.out.println(registrationPageTitle.getText());
            return false;
        }

    }

    public void registerNewUser(String inputtitle, String password,
            String Birthdate, String Birthmonth, String BirthYear,String cbox1,String cbox2,
            String firstname, String lastname, String Company, String address1, String address2,
            String country, String State, String City,
            String Zip, String mobilenumber) {

        this.titleSelection(inputtitle);
        SeleniumWrappers.sendKeysWrapper(setPassword, password, driver);
        this.selectDobFromDropdown(Birthdate, Birthmonth, BirthYear);
        if ( cbox1.equals("Yes")) {

            SeleniumWrappers.clickWrapper(checkBox1, driver);
        } else {
            // No specific action needed
        }

        if ( cbox2.equals("Yes")) {

            SeleniumWrappers.clickWrapper(checkBox2, driver);
        } else {
            // No specific action needed
        }
        
        

        SeleniumWrappers.sendKeysWrapper(firstNameTextBox, firstname, driver);
        SeleniumWrappers.sendKeysWrapper(lastNameTextBox, lastname, driver);
        SeleniumWrappers.sendKeysWrapper(companyTextBox, Company, driver);
        SeleniumWrappers.sendKeysWrapper(addressline1, address1, driver);
        SeleniumWrappers.sendKeysWrapper(addressline2, address2, driver);

        this.selectCountryFromDropdown(country);
        SeleniumWrappers.sendKeysWrapper(stateTextbox, State, driver);
        SeleniumWrappers.sendKeysWrapper(cityTextbox, City, driver);
        SeleniumWrappers.sendKeysWrapper(ZipTextbox, Zip, driver);
        SeleniumWrappers.sendKeysWrapper(mobileNumbertextbox, mobilenumber, driver);
        SeleniumWrappers.clickWrapper(CreateAcccountButton, driver);

    }

}
