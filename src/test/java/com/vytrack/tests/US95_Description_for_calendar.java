package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US95_Description_for_calendar {
    @DataProvider(name="UserCredentials")
    public Object[][]credentials(){
        return new Object[][]{
                {ConfigurationReader.getProperty("sales_manager_username"),ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("store_manager_username"),ConfigurationReader.getProperty("password")}

        };
    }

    @Test(dataProvider = "UserCredentials")
    public void message_description_field_TC(String username,String password)  {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUtils.login(username, password);

        BrowserUtils.sleep(1);
        //hover over  the Activities button
        WebElement activitiesButt= Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Activities' and contains(@class, 'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activitiesButt).perform();

        //locate the  Calendar Events
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Calendar Events' and contains(@class, 'title title-level-2')]")).click();

        //locate and click on the Create Calendar Event
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        //switch driver focus to iframe
        BrowserUtils.sleep(1);
        WebElement iframe=Driver.getDriver().findElement(By.xpath("//iframe"));
        Driver.getDriver().switchTo().frame(iframe);

        //find the body of Description box and write the description
        Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Retro meeting");

        //verify the message is displayed in the Description  box
        WebElement messageInInputbox =Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']/p"));
        Assert.assertTrue(messageInInputbox.isDisplayed());


        Driver.closeDriver();

    }

    @Test
    public void message_description_field_as_truckDriver(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VytrackUtils.loginAsDriver();

        BrowserUtils.sleep(1);
        //hover over  the Activities button
        WebElement activitiesButt= Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/a/span"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(activitiesButt).perform();

        //locate the  Calendar Events
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/div//li[3]")).click();

        //locate and click on the Create Calendar Event
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        //switch driver focus to iframe
        BrowserUtils.sleep(1);
        WebElement iframe= Driver.getDriver().findElement(By.xpath("//iframe"));
        Driver.getDriver().switchTo().frame(iframe);

        //find the body of Description box and write the description
        Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Retro meeting");

        //verify the message is displayed in the Description  box
        WebElement messageInInputbox =Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']/p"));
        Assert.assertTrue(messageInInputbox.isDisplayed());


        Driver.closeDriver();
    }
}
