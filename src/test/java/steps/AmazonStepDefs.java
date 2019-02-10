package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AmazonPage;
import utilities.Driver;

public class AmazonStepDefs {
    AmazonPage apObj = new AmazonPage();


    @Given("User is on the amazon homepage")
    public void user_is_on_the_amazon_homepage() {

        Driver.getDriver().get("https://amazon.com");


    }

    @When("User enters headphones keyword")
    public void user_enters_headphones_keyword() {

        apObj.amazonSearchBox.sendKeys("headphones");

    }

    @When("User clicks to amazon search button")
    public void user_clicks_to_amazon_search_button() {

        apObj.amazonSearchButton.click();

    }

    @Then("User should see headphones in results")
    public void user_should_see_headphones_in_results() {

        String actualText = apObj.amazonSearchResult.getText();

        Assert.assertTrue("The keyword headphones was not located", actualText.contains("headphones"));

    }

    @When("User enters {string} keyword")
    public void userEntersKeyword(String product) {
        apObj.amazonSearchBox.sendKeys(product);
    }
}
