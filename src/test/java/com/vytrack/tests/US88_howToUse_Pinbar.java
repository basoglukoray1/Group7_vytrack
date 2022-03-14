package com.vytrack.tests;

import com.vytrack.pages.PinbarPage;
import com.vytrack.pages.loginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US88_howToUse_Pinbar {
    loginPage loginPage;
    PinbarPage pinbarPage;

    @DataProvider(name = "usernames")
    public Object[][] usernameData(){
        return new Object[][]{
                {ConfigurationReader.getProperty("driver_username")},
                {ConfigurationReader.getProperty("sales_manager_username")},
                {ConfigurationReader.getProperty("store_manager_username")}

        };
    }



    @Test(dataProvider = "usernames")
    public void howToUse_Pinbar_text_test(String username){
        loginPage = new loginPage();
        pinbarPage = new PinbarPage();
        loginPage.login(username,ConfigurationReader.getProperty("password"));
        pinbarPage.pinbarLink.click();
        Assert.assertTrue(pinbarPage.howToUsePinbarText.isDisplayed());
        Assert.assertTrue(pinbarPage.fastAccessLongText.isDisplayed());
        Driver.closeDriver();
    }

    @Test(dataProvider = "usernames")
    public void pinbar_image_test(String username){
        loginPage = new loginPage();
        pinbarPage = new PinbarPage();

        loginPage.login(username,ConfigurationReader.getProperty("password"));
        pinbarPage.pinbarLink.click();

        Assert.assertTrue(pinbarPage.pinBarImage.isDisplayed());

        Driver.closeDriver();
    }
}
