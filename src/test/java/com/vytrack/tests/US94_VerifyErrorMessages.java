package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Calendar;

//   US 9: As a user, I should see error messages when I enter an invalid integer into the calendar repeat day input box.

public class US94_VerifyErrorMessages {


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("driver_username"));

        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));

        Driver.getDriver().findElement(By.tagName("button")).click();

        BrowserUtils.sleep(2);


    }

    @Test
    public void view_two_errorMessages() throws InterruptedException {

//     #1 Testcase  "  Verify “Calendar Events” under the Activities Module    "


//      Locating the “Activities"
        WebElement activitiesBtn = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]//span[1]"));
//      Click the “Activities"
        activitiesBtn.click();

        BrowserUtils.sleep(2);

//      Locating "Calendar Events" Button
        WebElement calendarEventsBtn = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']"));


//      Verify "Calendar Events" displayed
        Assert.assertTrue(calendarEventsBtn.isDisplayed(), "Verification CalendarEvents Displayed is failed");

//      Click the “Calendar Events"
        calendarEventsBtn.click();


        BrowserUtils.sleep(2);


//     Locating "Create Calendar Event" Button
        WebElement createCalendarEvenBtn = Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));

//     Locating "Create Calendar Event" Button
        createCalendarEvenBtn.click();

        BrowserUtils.sleep(2);

//     Locating "Repeat" checkbox
        WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'recurrence-repeat-view')]"));
        repeatCheckbox.click();

//     Verify repeat checkbox is selected
        Assert.assertTrue(repeatCheckbox.isSelected(), "Repeat checkbox verification is failed");






        //      #2  Testcase   "  Verify 2 error messges Displayed  x<1 || x>99 "



//     Locating Input Box
        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));
        inputBox.clear();

        /* solution 2
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(inputBox).perform();
        inputBox.sendKeys("-2");
*/

//      User enter an INVALID integer (   x<1  )
        inputBox.sendKeys("-2" + Keys.ENTER);

        BrowserUtils.sleep(2);



        WebElement firstErrorMessage =Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be less than 1.']"));

//     Verify first Error Message "The value have not to be less than 1."
        Assert.assertTrue(firstErrorMessage.isDisplayed());







 //     Verify Second Error Message " The value have not to be more than 99."



//    Locating Input Box
        inputBox = Driver.getDriver().findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));
        inputBox.clear();


//      User enter an INVALID integer ( x>99 )
        inputBox.sendKeys("100" + Keys.ENTER);


        BrowserUtils.sleep(2);



        WebElement secondErrorMessage =Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be more than 99.']"));

        //     Verify Second Error Message "The value have not to be more than 99."
        Assert.assertTrue(secondErrorMessage.isDisplayed());








    }

    @AfterMethod
    public void tearDown() {
          //     Driver.closeDriver();
    }

}
