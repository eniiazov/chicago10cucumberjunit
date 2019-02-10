package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePage {

    WebDriver driver;

    public GooglePage(){

        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@value='Google Search']")
    public WebElement searchButton;




}
