package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class US92_SelectVehicle {


    @Test
    public void TC1driverViewUncheckedChkboxes() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();


        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();
        // There is no checkboxes in driver login
        //WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));


        //Assert.assertFalse(firstCheckBox.isSelected());
        //System.out.println("firstCheckBox.isSelected() = " + firstCheckBox.isSelected());


    }

    @Test
    public void TC1salesManagerViewUncheckedChkboxes() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        // There is no checkboxes in driver login
        WebElement headClick = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]"));
        //BrowserUtils.sleep(3);
        //headClick.click();
        //WebElement headClick2 = Driver.getDriver().findElement(By.xpath("/html/body/ul/li[1]/a"));
        //headClick2.click();

        //WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']"));
        //firstCheckBox.click();

        Assert.assertFalse(headClick.isSelected());



    }

    @Test
    public void TC1storeManagerViewUncheckedChkboxes() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        // There is no checkboxes in driver login
        WebElement headClick = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]"));


        Assert.assertFalse(headClick.isSelected());
        System.out.println("firstCheckBox.isSelected() = " + headClick.isSelected());


    }

    @Test
    public void TC2drivercheckAllChkboxes() { //

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("driver_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        BrowserUtils.sleep(4);
        fleetElement.click();

        // locate vehicle under fleet and click
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span"));
        BrowserUtils.sleep(4);
        element.click();
        // There is no checkboxes in driver login



    }

    @Test
    public void TC2salesManagercheckAllChkboxes() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();
        BrowserUtils.sleep(10);
        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        BrowserUtils.sleep(5);
        fleetElement.click();

        // locate vehicle under fleet and click
        WebElement vehicleUnderFleet = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2' and .='Vehicles' ]"));
        BrowserUtils.sleep(4);
        vehicleUnderFleet.click();


        WebElement headClick = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]"));
        BrowserUtils.sleep(3);
        headClick.click();
        WebElement headClick2=Driver.getDriver().findElement(By.xpath("/html/body/ul/li[1]/a"));
        // WebElement headClick2 = Driver.getDriver().findElement(By.xpath("/html/body/ul/li[1]/a"));
        headClick2.click();

        //WebElement element = Driver.getDriver().findElement(By.xpath("/html/body/ul/li[1]/a"));
        //element.click();
        Assert.assertTrue(headClick2.isEnabled());
        System.out.println("firstCheckBox.isSelected() = " + headClick2.isSelected());


    }

    @Test
    public void TC2storeManagerCheckAllChkboxes() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        // There is no checkboxes in driver login
        WebElement headClick = Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-default btn-small dropdown-toggle'])[1]"));
        BrowserUtils.sleep(3);
        headClick.click();
        WebElement headClick2 = Driver.getDriver().findElement(By.xpath("/html/body/ul/li[1]/a"));
        BrowserUtils.sleep(3);
        headClick2.click();

        Assert.assertTrue(headClick2.isEnabled());
        //System.out.println("firstCheckBox.isSelected() = " + headClick2.isSelected());


    }

    @Test
    public void T3driverCheckAnyCar() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("driver_username"));

        //pass password
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));

        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click(); // sign in
        BrowserUtils.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();

        Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2' and .='Vehicles']")).click();
        // There are no checkboxes in driver module when Fleet-> Vehicles


    }

    @Test
    public void TC3salesManagerCheckAnyCar() {

        Driver.getDriver().get("https://qa2.vytrack.com");
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();

        // Fleet
        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        BrowserUtils.sleep(5);
        fleetElement.click();

        // locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        BrowserUtils.sleep(10);
        //Driver.getDriver().findElement(By.xpath("//*[@id=\"grid-custom-entity-grid-1481245719\"]/div[2]/div[2]/div[2]/div/table/thead/tr/th[1]/div/button/input")).click();
        //Until here

        for (int i = 1; i <= 25; i++) {
            WebElement checkBox = (WebElement) Driver.getDriver().findElement(By.xpath("(//input[@tabindex='-1'])[" + i + "]"));
            checkBox.click();
        }


    }

    @Test
    public void TC3storeManagerCheckAnyCar() {

        Driver.getDriver().get("https://qa2.vytrack.com");
        // pass username
        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput\"]")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        //pass password

        Driver.getDriver().findElement(By.xpath("//*[@id=\"prependedInput2\"]")).sendKeys(ConfigurationReader.getProperty("password"));
        // click login
        Driver.getDriver().findElement(By.xpath("//*[@id='_submit']")).click();

        // Fleet

        WebElement fleetElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        BrowserUtils.sleep(5);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(fleetElement).perform();
        //fleetElement.click();

        //locate vehicle under fleet and click
        Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();
        BrowserUtils.sleep(5);
        //Driver.getDriver().findElement(By.xpath("//*[@id=\"grid-custom-entity-grid-1481245719\"]/div[2]/div[2]/div[2]/div/table/thead/tr/th[1]/div/button/input")).click();
        //Until here

        for (int i = 1; i <= 25; i++) {
            WebElement checkBox = Driver.getDriver().findElement(By.xpath("(//input[@tabindex='-1'])[" + i + "]"));
            checkBox.click();
        }
    }
}