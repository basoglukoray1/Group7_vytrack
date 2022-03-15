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

import java.util.List;

public class US99_manage_filters {

    @DataProvider(name="UserCredentials")
    public Object[][]credentials(){
        return new Object[][]{
                {ConfigurationReader.getProperty("sales_manager_username"),ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("store_manager_username"),ConfigurationReader.getProperty("password")}

        };
    }

    @Test(dataProvider = "UserCredentials")
    public void TC_filter_selected_ByDefault_(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        //login
        VytrackUtils.login(username,password);

        //hover over marketing button
        WebElement marketingbutt= Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Marketing' and contains(@class, 'title title-level-1')]"));

        BrowserUtils.sleep(1);
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(marketingbutt).perform();

        //locating Campaigns butt
        BrowserUtils.sleep(1);
        WebElement campaignbutt=  Driver.getDriver().findElement(By.xpath("(//span[normalize-space()='Campaigns' and contains(@class, 'title title-level-2')])[1]"));
        campaignbutt.click();

        //locating filters icon
        BrowserUtils.sleep(1);
        WebElement filtericon=Driver.getDriver().findElement(By.xpath("(//div[@class='actions-panel pull-right form-horizontal']//a)[1]"));
        filtericon.click();

        //locating ManageFilters butt.
        Driver.getDriver().findElement(By.linkText("Manage filters")).click();

        //checking if all five checkbox are selected by default
        List<WebElement> checkbox= Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']"));
        for (WebElement webElement : checkbox) {
            Assert.assertTrue(webElement.isSelected());
        }
        Driver.closeDriver();

    }

    @Test(dataProvider = "UserCredentials")
    public void TC_uncheck_any_amount_of_boxes(String username, String password){

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        //login
        VytrackUtils.login(username,password);

        //hover over marketing button
        WebElement marketingbutt= Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Marketing' and contains(@class, 'title title-level-1')]"));

        BrowserUtils.sleep(1);
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(marketingbutt).perform();

        //locating Campaigns butt
        BrowserUtils.sleep(1);
        WebElement campaignbutt=  Driver.getDriver().findElement(By.xpath("(//span[normalize-space()='Campaigns' and contains(@class, 'title title-level-2')])[1]"));
        campaignbutt.click();

        //locating filters icon
        BrowserUtils.sleep(1);
        WebElement filtericon=Driver.getDriver().findElement(By.xpath("(//div[@class='actions-panel pull-right form-horizontal']//a)[1]"));
        filtericon.click();

        //locating ManageFilters butt
        Driver.getDriver().findElement(By.linkText("Manage filters")).click();
        BrowserUtils.sleep(1);

        // uncheck all the options
        List<WebElement> checkbox= Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']"));
        for (int i = 0; i < checkbox.size(); i++) {
            BrowserUtils.sleep(1);
            Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']")).get(i).click();
            // verify that all the options are unchecked
            Assert.assertFalse(Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']")).get(i).isSelected());
        }
// check some  options back
        for (int i = 2; i < checkbox.size(); i++) {
            BrowserUtils.sleep(1);
            Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']")).get(i).click();
            // verify that all the options are unchecked
            Assert.assertTrue(Driver.getDriver().findElements(By.xpath("//input[@name='multiselect_0']")).get(i).isSelected());
        }
        Driver.closeDriver();


    }


}
