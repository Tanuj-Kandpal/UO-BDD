package stepDefinitions;

import Helpers.DriverHelper;
import PageObjects.CreateAccountPage;
import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static java.util.concurrent.ThreadLocalRandom.current;

public class CreateAccountStepDef extends CreateAccountPage {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    private WebDriver driver;
    String url, browserName, actualUrl;

    public CreateAccountStepDef() throws IOException {
    }

    @Before("@account")
    public void initiate() throws IOException {

    }

    @Given("I am able to navigate to create account page")
    public void navigateToCreateAccountPage() {
        titleToContain("Create Account", 10);
    }

    @Given("Fill all the required details")
    public void fillRequiredDetails() {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(current().nextLong(100000000L, 1000000000L)+"@mailto.plus");
        setPassword("Password");
        selectCheckboxes();
    }

    @When("I click on create account button")
    public void submitAccountForm() {
        clickCreateAccountButton();
        waitForPageToLoad(10);
    }

    @Then("I should able to create an account successfully")
    public void verifyAccountCreation() {
        waitForSpinnerToDisappear();
        validateSuccessAccountBanner();
        String actualText = getSuccessBannerText();
        Assert.assertEquals(actualText,"Your Universal Account has been created.");
    }

    @Given("^I fill in the registration form with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        // TODO: Implement form filling logic
    }

    @Then("I should see validation errors and not be allowed to create account")
    public void verifyValidationErrorsAndAccountNotCreated() {
        // TODO: Implement validation checks
    }
    @After("@account")
    public void close() {
        tearDown();
    }
}
