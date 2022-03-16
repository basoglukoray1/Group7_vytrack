package com.vytrack.tests;


import com.vytrack.pages.CalendarPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.loginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US93_RecurringCalendarEvent {

    loginPage loginPage;
    DashboardPage dashboardPage;
    CalendarPage calendarPage;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
       loginPage =new loginPage();
      loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
      loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
       loginPage.loginButton.click();

//Click the  "Calendar Events" under the Activities
        dashboardPage =new DashboardPage();
        dashboardPage.activitiesButton.click();
        BrowserUtils.sleep(1);
        dashboardPage.calendarButton.click();
        BrowserUtils.sleep(1);


//3
//Click the "Create Calendar Event" button.
        dashboardPage.createEventButton.click();
        BrowserUtils.sleep(1);


//4
//Check the "Repeat" checkbox.
        calendarPage =new CalendarPage();
        calendarPage.repeatCheckBox.click();

    }

    @Test
    public void verify_repeat_default_test() {


//5
//Verify Repeat Every number is 1 as a default

        String actualNumber= calendarPage.checkRepeatEvery.getAttribute("value");
        String expectedNumber="1";

        Assert.assertEquals(actualNumber,expectedNumber);
        Driver.closeDriver();


    }

    @Test
    public void verify_error_message_repeat_every_option(){


        //Verify the error message after deleting number "1"
        calendarPage.checkRepeatBox.click();

        calendarPage.checkRepeatBox.sendKeys(Keys.BACK_SPACE);

        BrowserUtils.sleep(2);

        calendarPage.checkRepeatBox.sendKeys(Keys.ENTER);

        //verify the error message

        String actualErrorMessage= calendarPage.errorMessage.getText();
        String expectedErrorMessage="This value should not be blank.";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        Driver.closeDriver();











    }




}
