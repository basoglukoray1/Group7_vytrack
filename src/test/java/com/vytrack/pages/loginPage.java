package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public loginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidUsernameOrPasswordText;

    @FindBy(xpath = "//span[text()='Remember me on this computer']")
    public WebElement rememberMeCheckBox;


    public void loginAsDriver(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void loginAsSalesManager(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void loginAsStoreManager(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

    public void login(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }



}
