package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tmsSteps {
    String courseName;
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("Имя курса {string}")
    public void имяКурса(String courseName) {
        this.courseName = courseName;
    }

    @When("Пользователь открывает ссылку курса")
    public void пользовательОткрываетСсылкуКурса() {
        driver.get("https://teachmeskills.by/kursy-programmirovaniya/kursy-programmirovaniya-online");
        driver.findElement(By.xpath(String.format("//strong[text()='%s']", courseName))).click();
    }

    @Then("Заголовок страницы {string}")
    public void заголовокСтраницы(String courseName) {
        Assert.assertEquals(driver.findElement(By.xpath("//h1/div/span/span")).getText(), courseName, "Имя курса не совпадает.");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Вызываю sout")
    public void вызываюSout() {
        System.out.println("!!!");
    }
}
