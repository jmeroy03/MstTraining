package steps;

import engine.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;


public class MyStepDefs{
    private WebDriver driver;

    public MyStepDefs (Driver driver){
        this.driver = driver.get();
    }

    @Given("I redirect to guru page")
    public void iRedirectToGuruPage() {
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @Then("I should see Demo Site is displayed")
    public void iShouldSeeDemoSiteIsDisplayed() {
        Boolean Display = driver.findElement(By.xpath(".//*[text()='Demo Site']")).isDisplayed();
        Assert.assertTrue(Display);

    }

    @And("Registration link is displayed")
    public void registrationLinkIsDisplayed() {
        Boolean Display = driver.findElement(By.xpath(".//*[text()='REGISTER']")).isDisplayed();
        Assert.assertTrue(Display);
        System.out.println("");
    }

    @Given("I go to Guru{int} page")
    public void iGoToGuruPage(int arg0) {
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @When("I Click Register button")
    public void iClickRegisterButton() {
       driver.findElement(By.xpath(".//*[text()='REGISTER']")).click();

    }

    @And("I Fill All fields")
    public void iFillAllFields(DataTable inputData) {
        Map<String, String> inputvalues = inputData.asMap(String.class, String.class);
        driver.findElement(By.xpath(".//input[@name='firstName']")).sendKeys(inputvalues.get("First Name"));
        driver.findElement(By.xpath(".//input[@name='lastName']")).sendKeys(inputvalues.get("Last Name"));
        driver.findElement(By.xpath(".//input[@name='phone']")).sendKeys(inputvalues.get("Phone"));
        driver.findElement(By.id("userName")).sendKeys(inputvalues.get("Email"));
        driver.findElement(By.xpath(".//input[@name='address1']")).sendKeys(inputvalues.get("Address"));
        driver.findElement(By.xpath(".//input[@name='city']")).sendKeys(inputvalues.get("City"));
        driver.findElement(By.xpath(".//input[@name='state']")).sendKeys(inputvalues.get("State"));
        driver.findElement(By.xpath(".//input[@name='postalCode']")).sendKeys(inputvalues.get("Postal Code"));
        Select state = new Select(driver.findElement(By.xpath(".//select[@name='country']")));
        state.selectByVisibleText(inputvalues.get("Country"));
        driver.findElement(By.id("email")).sendKeys(inputvalues.get("Username"));
        driver.findElement(By.xpath(".//input[@name='password']")).sendKeys(inputvalues.get("Password"));
        driver.findElement(By.xpath(".//input[@name='confirmPassword']")).sendKeys(inputvalues.get("Confirm Password"));
    }

    @And("I click Submit button")
    public void iClickSubmitButton() {
        driver.findElement(By.xpath(".//input[@name='submit']")).click();
    }


    @Then("I see Sing Off link button")
    public void iSeeSingOffLinkButton() {
        Boolean Display = driver.findElement(By.xpath(".//*[text()='SIGN-OFF']")).isDisplayed();
        Assert.assertTrue(Display);
    }
}