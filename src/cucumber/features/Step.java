package cucumber.features;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver = null;
	
	@Before
	public void Setup() throws Throwable{
		driver = new FirefoxDriver();
		driver.navigate().to("http://qa-test.avenuecode.com/");
		driver.findElement(By.linkText("Sign In")).click();
		
		WebDriverWait wait = new WebDriverWait( driver, 10 );
	    wait.until(ExpectedConditions.visibilityOfElementLocated( By.name("user[email]")));
	    
		driver.findElement(By.name("user[email]")).sendKeys("joaomarcossv@gmail.com");
		driver.findElement(By.name("user[password]")).sendKeys("Q%IngUj*lO1am0uN");
		driver.findElement(By.name("commit")).click();
	}
	
	@After
	public void Finish() throws Throwable{
		driver.quit();
	}
	
	@Given("^I am at the ToDo app home page$")
	public void i_am_at_the_ToDo_app_home_page() throws Throwable {
		driver.navigate().to("http://qa-test.avenuecode.com/");
	}

	@When("^I Click on the ([^\"]*)$")
	public void i_Click_on_the_ToDo_App(String link) throws Throwable {
		driver.findElement(By.linkText(link));
	}

	@Then("^The My Task link should be in the NavBar$")
	public void the_My_Task_link_should_be_in_the_NavBar() throws Throwable {
		Assert.assertTrue("My Task not on NavBar", driver.findElement(By.linkText("My Tasks")).isDisplayed());
	}
}
