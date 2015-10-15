//package project;
//
///**
// * Created by marciomarinho on 1/09/15.
// */
//
//import cucumber.api.DataTable;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java8.En;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//public class ProjectSteps implements En {
//
//    private WebDriver driver;
//
//    @Before
//    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
//
//    public ProjectSteps() {
//
//        Given("^I visit the add projects page$", () -> {
//            driver.get(getHostAndPort() + "/projects/new");
//            driver.findElement(new By.ById("name"));
//        });
//
//        When("^I enter the fields :$", (DataTable dataTable) -> {
//
//            Map<String, String> data = dataTable.asMap(String.class, String.class);
//            for (Map.Entry<String, String> entry : data.entrySet()) {
//                WebElement e = driver.findElement(new By.ByXPath("//label[contains(text(),'" + entry.getKey() + "')]"));
//                e.click();
//                e.sendKeys(entry.getValue());
//            }
//
//        });
//
//        When("^I submit the form$", () -> {
//            driver.findElement(new By.ById("submit")).click();
//        });
//
//        Then("^I should see \"([^\"]*)\" in the projects list$", (String text) -> {
//            driver.findElement(new By.ByXPath(".//*[@id='projects_list']//td[contains(., '" + text + "')]"));
//        });
//
//    }
//
//    private String getHostAndPort() {
//        try {
//            return InetAddress.getLocalHost().getHostName()  + ":8080";
//        } catch (UnknownHostException e) {
//            return "localhost:8080";
//        }
//    }
//}
