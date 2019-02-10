package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.DatatablesPage;
import utilities.Driver;

public class Datatables_stepDefs {

    DatatablesPage dtpObj = new DatatablesPage();

    @Given("User is on the datatables homepage")
    public void user_is_on_the_datatables_homepage() {
        Driver.getDriver().get("https://editor.datatables.net/");
    }

    @Given("User clicks to New Button")
    public void user_clicks_to_New_Button() {

        dtpObj.newButton.click();

    }

    @Then("User should see Create New Entry Box")
    public void user_should_see_Create_New_Entry_Box() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(dtpObj.newEmployeeForm.isDisplayed());
    }

    @Then("User should enter firstname")
    public void user_should_enter_firstname() {

        dtpObj.firstNameInput.sendKeys("John");

    }

    @Then("User should enter lastname")
    public void user_should_enter_lastname() {
        dtpObj.lastNameInput.sendKeys("Wick");
    }

    @Then("User should enter position")
    public void user_should_enter_position() {

        dtpObj.positionInput.sendKeys("retired assasin");
    }

    @Then("User should enter office")
    public void user_should_enter_office() {

        dtpObj.officeInput.sendKeys("London");
    }

    @Then("User should enter extension")
    public void user_should_enter_extension() {

        dtpObj.extensionInput.sendKeys("312");
    }

    @Then("User should enter start date")
    public void user_should_enter_start_date() {
        dtpObj.startDateInput.sendKeys("2019-02-10");
    }

    @Then("User should enter salary")
    public void user_should_enter_salary() {
        dtpObj.salaryInput.sendKeys("500000");
    }

    @Then("User should click to create button")
    public void user_should_click_to_create_button() {
        dtpObj.createButton.click();
    }

    @Then("User should enter office {string}")
    public void user_should_enter_office(String office) {

        dtpObj.officeInput.sendKeys(office);

    }

    @Then("User should enter extension {string}")
    public void user_should_enter_extension(String extension) {

        dtpObj.extensionInput.sendKeys(extension);

    }

    @Then("User should enter start date {string}")
    public void user_should_enter_start_date(String date) {

        dtpObj.startDateInput.sendKeys(date);

    }

    @Then("User should enter salary {string}")
    public void user_should_enter_salary(String salary) {

        dtpObj.salaryInput.sendKeys(salary);


    }

    @Then("User enters first name to search box")
    public void user_enters_first_name_to_search_box() {

        dtpObj.searchBox.sendKeys("john");


    }

    @Then("User should see first name is inserted in the table")
    public void user_should_see_first_name_is_inserted_in_the_table() {

        String expected = "John";
        String actual = dtpObj.firstResult.getText();

        Assert.assertTrue("Name was not found!",actual.contains(expected));

    }


    @Then("User should enter firstname {string}")
    public void user_should_enter_firstname(String firstName) {

        dtpObj.firstNameInput.sendKeys(firstName);

    }

    @Then("User should enter lastname {string}")
    public void user_should_enter_lastname(String lastName) {

        dtpObj.lastNameInput.sendKeys(lastName);

    }

    @Then("User should enter position {string}")
    public void user_should_enter_position(String position) {

        dtpObj.positionInput.sendKeys(position);

    }

    @Then("User enters first name {string} to search box")
    public void user_enters_first_name_to_search_box(String firstname) {

        dtpObj.searchBox.sendKeys(firstname);
    }

    @Then("User should see first name {string} is inserted in the table")
    public void user_should_see_first_name_is_inserted_in_the_table(String expectedName) throws InterruptedException {

        String expected = expectedName;
        Thread.sleep(500);
        String actual = dtpObj.firstResult.getText();

        //TODO: fix this later
        Assert.fail();
        Thread.sleep(500);
        Assert.assertTrue("Name was not found!",actual.contains(expected));

    }
}
