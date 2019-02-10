package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.WikiPage;
import utilities.Driver;

public class wiki_stepDefs {

    WikiPage wpObj = new WikiPage();

    @Given("User is on the Wikipedia homepage")
    public void user_is_on_the_Wikipedia_homepage() {

        Driver.getDriver().get("https://wikipedia.org");

    }

    @When("User enters steve jobs to search bar and clicks enter")
    public void user_enters_steve_jobs_to_search_bar_and_clicks_enter() {

        wpObj.wikiSearchBox.sendKeys("Steve Jobs" + Keys.ENTER);

    }

    @Then("User should see the first header is displaying steve jobs")
    public void user_should_see_the_first_header_is_displaying_steve_jobs() {

        String actualText = wpObj.firstHeader.getText();
        String expected = "Steve Jobs";

        Assert.assertTrue(actualText.equals(expected));


    }


}
