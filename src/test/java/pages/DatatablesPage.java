package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DatatablesPage {

    //WebDriver driver;

    public DatatablesPage(){

        //driver = Driver.getDriver();
        PageFactory.initElements( Driver.getDriver(), this);

    }

    @FindBy(xpath = "//button[@class='dt-button buttons-create']")
    public WebElement newButton;

    @FindBy(css = ".DTE_Body")
    public WebElement newEmployeeForm;

    @FindBy(css= "#DTE_Field_first_name")
    public WebElement firstNameInput;

    @FindBy(css= "#DTE_Field_last_name")
    public WebElement lastNameInput;

    @FindBy(css= "#DTE_Field_position")
    public WebElement positionInput;

    @FindBy(css= "#DTE_Field_office")
    public WebElement officeInput;

    @FindBy(css= "#DTE_Field_extn")
    public WebElement extensionInput;

    @FindBy(css= "#DTE_Field_start_date")
    public WebElement startDateInput;

    @FindBy(css= "#DTE_Field_salary")
    public WebElement salaryInput;

    @FindBy(css= ".btn")
    public WebElement createButton;

    @FindBy(xpath= "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath= "//td[@class='sorting_1']")
    public WebElement firstResult;
}
