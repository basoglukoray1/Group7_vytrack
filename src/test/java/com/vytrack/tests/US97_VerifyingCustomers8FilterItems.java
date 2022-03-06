package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US97_VerifyingCustomers8FilterItems {

    //There is a bug. I created a bug report. I don't have to go on automation ;)

    //testing modules for sales manager
    @Test
    public void verifying_modules_as_sales_manager() {

        VytrackUtils.loginAsSalesManager();
        WebElement customersElement = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 active']"));
        customersElement.click();

        WebElement accountsElement = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__scrollable hidden']"));
        accountsElement.click();


        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//a[@class='grid-header-cell__link']"));
        List<String> actualmoduleTexts = new ArrayList<>();

        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualmoduleTexts.add(moduleElementText);
        }


        List<String> expectedmoduleTexts = new ArrayList<>(Arrays.asList(
                "Account Name",
                "Contact Name",
                "Contact Email",
                "Contact Phone",
                "Owner",
                "Business Unit",
                "Created At",
                "Updated At"));

        Assert.assertEquals(actualmoduleTexts, expectedmoduleTexts);

    }

    //testing modules for store manager
    @Test
    public void verifying_modules_as_store_manger() {
        VytrackUtils.loginAsStoreManger();
        WebElement customersElement = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 active']"));
        customersElement.click();

        WebElement accountsElement = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown-menu-wrapper dropdown-menu-wrapper__scrollable hidden']"));
        accountsElement.click();


        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//a[@class='grid-header-cell__link']"));
        List<String> actualmoduleTexts = new ArrayList<>();

        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualmoduleTexts.add(moduleElementText);
        }


        List<String> expectedmoduleTexts = new ArrayList<>(Arrays.asList(
                "Account Name",
                "Contact Name",
                "Contact Email",
                "Contact Phone",
                "Owner",
                "Business Unit",
                "Created At",
                "Updated At"));

        Assert.assertEquals(actualmoduleTexts, expectedmoduleTexts);
    }


}
