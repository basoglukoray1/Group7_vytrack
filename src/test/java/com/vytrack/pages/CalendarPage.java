package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {


    public CalendarPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    //check the repeat checkbox
    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat-view')]")
    public WebElement repeatCheckBox;

    //locate to Repeat every box
    @FindBy(xpath = "(//input[@class='recurrence-subview-control__number' and @value='1'])[1]")
    public WebElement checkRepeatEvery;

    //locate check repeat every box
    @FindBy(xpath = "//input[@class='recurrence-subview-control__number']")
    public WebElement checkRepeatBox;

    //locate error message text
    @FindBy(xpath = "//span[text()='This value should not be blank.']")
    public WebElement errorMessage;

}
