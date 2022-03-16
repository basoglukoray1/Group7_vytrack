package com.vytrack.tests;

import com.vytrack.pages.loginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Calendar;

public class US94_VerifyErrorMessages {
    //   US 9: As a user, I should see error messages when I enter an invalid integer into the calendar repeat day input box.


    @Test
    public void view_two_errorMessages() throws InterruptedException {
//     #1 Testcase  "  Verify “Calendar Events” under the Activities Module    "

        loginPage loginAsDriver = new loginPage();
        loginAsDriver.loginAsDriver();

        BrowserUtils.sleep(2);
//      Locating the “Activities"
        WebElement activitiesBtn = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[3]"));




//    #1 “Activities" hover over it
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(activities).perform();
//        Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']")).click();


//      #2 click  “Activities" hover over it
        activitiesBtn.click();

        BrowserUtils.sleep(2);
        //      Locating "Calendar Events" Button and click
        WebElement calendarEventsBtn = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"));
        calendarEventsBtn.click();



        BrowserUtils.sleep(2);
//      Verify "Calendar Events" displayed
//      Assert.assertTrue(calendarEventsBtn.isDisplayed(), "Verification CalendarEvents Displayed is failed");


//     Locating "Create Calendar Event" Button
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        BrowserUtils.sleep(2);

//     Locating "Repeat" checkbox
        WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat-view')]"));
        repeatCheckbox.click();
        BrowserUtils.sleep(2);

//     Verify repeat checkbox is selected
        Assert.assertTrue(repeatCheckbox.isSelected(), "Repeat checkbox verification is failed");


        //      #2  Testcase   "  Verify 2 error messages Displayed  x<1 || x>99 "


//     Locating Input Box
        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//div[@data-name='recurrence-daily']//input[@type='text']"));
        inputBox.clear();


//      User enter an INVALID integer (   x<1  )
        inputBox.sendKeys("-2" + Keys.ENTER);



        WebElement firstErrorMessage = Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be less than 1.']"));


//     Verify first Error Message "The value have not to be less than 1."
        Assert.assertTrue(firstErrorMessage.isDisplayed());


        //     Verify Second Error Message " The value have not to be more than 99."


//    Locating Input Box
        inputBox = Driver.getDriver().findElement(By.xpath("//div[@data-name='recurrence-daily']//input[@type='text']"));
        inputBox.clear();


//      User enter an INVALID integer ( x>99 )
        inputBox.sendKeys("100" + Keys.ENTER);


        WebElement secondErrorMessage = Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be more than 99.']"));

        //     Verify Second Error Message "The value have not to be more than 99."
        Assert.assertTrue(secondErrorMessage.isDisplayed());


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();

    }

}
