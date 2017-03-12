package cucumber.features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver = null;

	
	@Given("^ToDo app home page$")
	public void todo_app_home_page() throws Throwable {
		driver = new FirefoxDriver();
		driver.navigate().to("http://qa-test.avenuecode.com/");
	}

	@When("^Click Sign In$")
	public void click_Sign_In() throws Throwable {
		driver.findElement(By.linkText("Sign In")).click();
	}

	@And("^Add Info$")
	public void add_Info() throws Throwable {
		// Wait for page to load
	    WebDriverWait wait = new WebDriverWait( driver, 10 );
	    wait.until(ExpectedConditions.visibilityOfElementLocated( By.name("user[email]")));
	    
		driver.findElement(By.name("user[email]")).sendKeys("joaomarcossv@gmail.com");
		driver.findElement(By.name("user[password]")).sendKeys("Q%IngUj*lO1am0uN");
		driver.findElement(By.name("commit")).click();
	}

	@Then("^Should be back at ToDo app home page$")
	public void should_be_back_at_ToDo_app_home_page() throws Throwable {
		// Wait for page to load
	    WebDriverWait wait = new WebDriverWait( driver, 10 );
	    wait.until(ExpectedConditions.visibilityOfElementLocated( By.linkText("Sign out")));
	    
		Assert.assertTrue("Not Signed In", driver.getPageSource().contains("Demo ToDo app using Ruby on Rails and Angular JS."));
	}
}
