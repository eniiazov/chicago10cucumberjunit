package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GasMileageCalculatorPage {


    public GasMileageCalculatorPage(){

        //driver = Driver.getDriver();
        PageFactory.initElements( Driver.getDriver(), this);

    }


    @FindBy(id="uscodreading")
    public WebElement currentOdometerReadingInput;

    @FindBy(id="uspodreading")
    public WebElement previousOdometerReadingInput;

    @FindBy(id="usgasputin")
    public WebElement gasInput;

    @FindBy(xpath = "(//input[@alt='Calculate'])[1]")
    public WebElement calculateButton;

    @FindBy(xpath = "//b[contains(text(), 'miles per gallon')]")
    public WebElement resultInGallon;
}
