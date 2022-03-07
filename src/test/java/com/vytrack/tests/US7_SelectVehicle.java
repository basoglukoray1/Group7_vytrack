package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US7_SelectVehicle {


    @Test
    public void TC1DriverViewUncheckedChkboxes(){
        // cant login
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.cssSelector("#prependedInput")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id=\"_submit\"]")).click();

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();

        WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));


        Assert.assertFalse(firstCheckBox.isSelected());
        System.out.println("firstCheckBox.isSelected() = " + firstCheckBox.isSelected());


    }
    @Test
    public void TC1SalesmanagerViewUncheckedChkboxes(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.cssSelector("#prependedInput")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id=\"_submit\"]")).click();

        // Locate Fleet and click
        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();

        // locate first check box
        WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));

        // check if first checkbox is selected
        Assert.assertFalse(firstCheckBox.isSelected());
        System.out.println("firstCheckBox.isSelected() = " + firstCheckBox.isSelected());




    }
    @Test
    public void TC1StoreManagerViewUncheckedChkboxes(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.cssSelector("#prependedInput")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        //pass password
        Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id=\"_submit\"]")).click();

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();

        // locate first checkbox
        WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));


        Assert.assertFalse(firstCheckBox.isSelected());
        System.out.println("firstCheckBox.isSelected() = " + firstCheckBox.isSelected());


    }
}
