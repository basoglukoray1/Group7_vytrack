package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US_87_AccesstoOronicDocPage {

    @Test
    public void accessOroincPage() {
        //Driver.getDriver() --> driver

        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));

        usernameInput.sendKeys("Salesmanager125");
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123" + Keys.ENTER);


        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//i[@title='Get help']"));
        BrowserUtils.sleep(2);
        questionIcon.click();


        BrowserUtils.switchWindowAndVerify(Driver.getDriver(),"https://doc.oroinc.com/","Welcome to Oro Documentation");



    }
}
