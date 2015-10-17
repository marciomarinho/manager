package features.project;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.Application;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by marciomarinho on 29/09/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebAppConfiguration
@IntegrationTest
public class MyStepdefs {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Given("^I visit the add projects page$")
    public void i_visit_the_add_projects_page() throws Throwable {
        driver.get(getHostAndPort() + "/projects/new");
        driver.findElement(new By.ById("name"));
    }

    @Given("^I visit the projects list$")
    public void i_visit_the_projects_list() throws Throwable {
        driver.get(getHostAndPort() + "/projects");
    }

    @When("^I enter the fields :$")
    public void i_enter_the_fields(DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            WebElement e = driver.findElement(new By.ByXPath("//label[contains(text(),'" + entry.getKey() + "')]"));
            e.click();
            e.sendKeys(entry.getValue());
        }
    }

    @When("^I submit the form$")
    public void i_submit_the_form() throws Throwable {
        driver.findElement(new By.ById("submit")).click();
    }

    @Then("^I should see \"([^\"]*)\" in the projects list$")
    public void i_should_see_in_the_projects_list(String text) throws Throwable {
        driver.findElement(new By.ByXPath(".//*[@id='projects_list']//td[contains(., '" + text + "')]"));
    }


    @When("^I click delete \"([^\"]*)\"$")
    public void i_click_delete(String arg1) throws Throwable {
        WebElement element = driver.findElement(new By.ByXPath("//a[contains(@class, 'delete')][@Name='" + arg1 + "']"));
        element.click();
    }

    @When("^I click edit \"([^\"]*)\"$")
    public void i_click_edit(String arg1) throws Throwable {
        WebElement element = driver.findElement(new By.ByXPath("//a[contains(@class, 'edit')][@Name='" + arg1 + "']"));
        element.click();
    }

    @Then("^I should not see \"([^\"]*)\" in the projects list$")
    public void i_should_not_see_in_the_projects_list(String arg1) throws Throwable {

        try {
            WebElement element = driver.findElement(new By.ById(arg1));
            if (element.isDisplayed()) {
                throw new Throwable("The element was found, but SHOULD NOT !");
            }
        } catch(org.openqa.selenium.NoSuchElementException ex) {
            //Ok, element not found
        }

    }

    private String getHostAndPort() {
        try {
            return InetAddress.getLocalHost().getHostName() + ":8080";
        } catch (UnknownHostException e) {
            return "localhost:8080";
        }
    }

}
