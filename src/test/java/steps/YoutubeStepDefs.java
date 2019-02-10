package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.YoutubePage;
import utilities.Driver;

public class YoutubeStepDefs {

    YoutubePage yobj = new YoutubePage();

    @Given("User is on the youtube homepage")
    public void user_is_on_the_youtube_homepage() {

        Driver.getDriver().get("https://youtube.com");

    }

    @Given("User is able to see the search box")
    public void user_is_able_to_see_the_search_box() {
        Assert.assertTrue(yobj.youtubeSearchBox.isDisplayed());
    }

    @Given("User is able to see the search button")
    public void user_is_able_to_see_the_search_button() {
        Assert.assertTrue(yobj.youtubeSearchButton.isDisplayed());

    }

    @When("User searches for FUNNY CAT VIDEOS")
    public void user_searches_for_FUNNY_CAT_VIDEOS() throws InterruptedException {

        Thread.sleep(2000);
        yobj.youtubeSearchBox.sendKeys("FUNNY CAT VIDEOS"  + Keys.ENTER);
        Thread.sleep(2000);


    }

    @Then("User should see results related to funny cat videos")
    public void user_should_see_results_related_to_funny_cat_videos() {
        String actual = Driver.getDriver().getTitle();
        System.out.println(actual);

        String expected = "CAT";

        Assert.assertTrue("Does not contain", actual.contains(expected) );
    }

    @When("User searches for FUNNY DOG VIDEOS")
    public void user_searches_for_FUNNY_DOG_VIDEOS() throws InterruptedException {
        Thread.sleep(2000);
        yobj.youtubeSearchBox.sendKeys("FUNNY DOG VIDEOS" + Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("User should see results related to funny dog videos")
    public void user_should_see_results_related_to_funny_dog_videos() {
        String actual = Driver.getDriver().getTitle();
        System.out.println(actual);

        String expected = "DOG";

        Assert.assertTrue("Does not contain", actual.contains(expected) );

    }

    @When("User searches for FUNNY PET VIDEOS")
    public void user_searches_for_FUNNY_PET_VIDEOS() throws InterruptedException {
        Thread.sleep(2000);
        yobj.youtubeSearchBox.sendKeys("FUNNY PET VIDEOS" + Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("User should see results related to funny pet videos")
    public void user_should_see_results_related_to_funny_pet_videos() {

        String actual = Driver.getDriver().getTitle();
        System.out.println(actual);

        String expected = "PET";

        Assert.assertTrue("Does not contain", actual.contains(expected) );

    }
}
