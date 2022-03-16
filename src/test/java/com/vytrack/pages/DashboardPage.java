package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {


    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //click on Activities button
    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/a/span")
    public WebElement activitiesButton;

    //click to Calendar Events
    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[3]/a/span")
    public WebElement calendarButton;

    //click to create calendar event button
    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createEventButton;






}
