package com.vytrack.pages;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinbarPage  {

    public PinbarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[.='Learn how to use this space']")
    public WebElement pinbarLink;

    @FindBy(xpath = "//h3[.='How To Use Pinbar']")
    public WebElement howToUsePinbarText;

    @FindBy(xpath = "//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']")
    public WebElement pinBarImage;

    @FindBy(xpath = "//p[normalize-space(text())='Use pin icon on the right top corner of page to create fast access link in the pinbar.']")
    public WebElement fastAccessLongText;







}
