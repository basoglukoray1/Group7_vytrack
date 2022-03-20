package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.*;

public class US91_eDIT_CAR {

   //
   // Ac1 users should see “view, edit, delete” when they hover the mouse to the 3 dots “…”

   @Test
   public void viewIconsAsADriver() {

      VytrackUtils.loginAsDriver();
      BrowserUtils.sleep(3);

      //User hovers over the mouth to the "Fleet"

      WebElement fleet = Driver.getDriver().findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"));

      Actions actions = new Actions(Driver.getDriver());
      actions.moveToElement(fleet).perform();

      WebElement vehicles = Driver.getDriver().findElement(By.linkText("Vehicles"));
      vehicles.click();

      //Verify any car info has 3 dots “...”, and there are “view, edit, delete” icons.

      List<WebElement> threeDotElements = Driver.getDriver().findElements(By.linkText("..."));
      List<WebElement> numberOfCars = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));

      //verify that all cars have ...
      Assert.assertTrue(threeDotElements.size()==numberOfCars.size());

      actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[text()='...']"))).perform();




      List<WebElement> optionsList = Driver.getDriver().findElements(By.xpath("(//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu'])[1]//li[@class='launcher-item']/a/i"));


      List<String> expectedOptionsText = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));

      for (int i = 0; i < expectedOptionsText.size(); i++) {
            Assert.assertEquals(optionsList.get(i).getAttribute("title"), expectedOptionsText.get(i));

         // Assert.assertTrue(optionsList.get(i).isDisplayed());
      }







   }

      @AfterMethod
      public void tearDown(){
         Driver.closeDriver();
      }











}
