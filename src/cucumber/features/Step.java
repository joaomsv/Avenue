package cucumber.features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait( driver, 10 );
	
	String username = new String("João Marcos Soares Vieira");
	String email = new String("joaomarcossv@gmail.com");
	String password = new String("Q%IngUj*lO1am0uN");
	
	@Before
	public void Setup() throws Throwable{
		driver.navigate().to("http://qa-test.avenuecode.com/");
		driver.findElement(By.linkText("Sign In")).click();
		
	    wait.until(ExpectedConditions.elementToBeClickable( By.name("commit")));
	    
		driver.findElement(By.name("user[email]")).sendKeys(email);
		driver.findElement(By.name("user[password]")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/users/sign_out']")));
	}
	
	@After
	public void Finish() throws Throwable{
		driver.quit();
	}
	
	@Given("^I am at the ToDo app home page$")
	public void i_am_at_the_ToDo_app_home_page() throws Throwable {
		driver.navigate().to("http://qa-test.avenuecode.com/");
	}

	@When("^I Click on ([^\"]*)$")
	public void i_Click_on_the_ToDo_App1(String link) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable( By.linkText(link)));
		driver.findElement(By.linkText(link)).click();
	}
	
	@When("^I Click on \"([^\"]*)\"$")
	public void i_Click_on_the_ToDo_App2(String link) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable( By.linkText(link)));
		driver.findElement(By.linkText(link)).click();
	}
	
	@And("^I add a Task with Add Task button$")
	public void i_add_a_Task_with_Add_Task_button() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new_task")));
		driver.findElement(By.id("new_task")).sendKeys("test1");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/form/div[2]/span")).click();
	}

	@And("^I add a Task with Enter key$")
	public void i_add_a_Task_with_Enter_key() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new_task")));
		driver.findElement(By.id("new_task")).sendKeys("test2");
		driver.findElement(By.id("new_task")).sendKeys(Keys.ENTER);
	}
	
	@And("^I input \"([^\"]*)\"$")
	public void i_input(String text) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new_task")));
		driver.findElement(By.id("new_task")).sendKeys(text);
		driver.findElement(By.id("new_task")).sendKeys(Keys.ENTER);
	}

	@And("^I input a task greater than (\\d+)$")
	public void i_input_a_task_greater_than(int size) throws Throwable {
		String text = new String();
		for(int i=0;i<=size;i++)
		{
			text=text+"a";
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new_task")));
		driver.findElement(By.id("new_task")).sendKeys(text);
		driver.findElement(By.id("new_task")).sendKeys(Keys.ENTER);
	}
	
	@And("^I click on \"([^\"]*)\"$")
	public void i_click_on(String path) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		driver.findElement(By.xpath(path)).click();
	}

	@And("^I input a subtask greater than (\\d+)$")
	public void i_input_a_subtask_greater_than(int size) throws Throwable {
		String text = new String();
		for(int i=0;i<=size;i++)
		{
			text=text+"a";
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-subtask")));
		driver.findElement(By.id("new_sub_task")).sendKeys(text);
		driver.findElement(By.id("add-subtask")).click();
	}

	@And("^I input subtask \"([^\"]*)\" and due date \"([^\"]*)\"$")
	public void i_input_subtask_and_due_date(String subtask, String due_date) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-subtask")));
		driver.findElement(By.id("new_sub_task")).sendKeys(subtask);
		driver.findElement(By.id("dueDate")).sendKeys(due_date);
		driver.findElement(By.id("add-subtask")).click();
	}

	@Then("^Subtask \"([^\"]*)\" should not existe$")
	public void subtask_should_not_existe(String text) throws Throwable {
		Assert.assertFalse(text + " exists", driver.getPageSource().contains(text));
	}
	
	@Then("^The subtask should not exist$")
	public void the_subtask_should_not_exist() throws Throwable {
		String text = new String();
		for(int i=0;i<=250;i++)
		{
			text=text+"a";
		}
		Assert.assertFalse(text + " exists", driver.getPageSource().contains(text));		
	}
	
	@Then("^Both Task ID and description should be disabled$")
	public void both_Task_ID_and_description_should_be_disabled() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div[3]/button")));
		Assert.assertFalse("Task ID not Read-only", driver.findElement(By.xpath("//*[@id='edit_task']")).isEnabled());
		//System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/h3")).getAttribute("readOnly"));
	}

	@Then("^\"([^\"]*)\" should me visible$")
	public void should_me_visable(String link) throws Throwable {
		Assert.assertTrue(link + " not visible", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/button")).isDisplayed());
	}


	@Then("^The task should not exist$")
	public void the_task_should_not_exist() throws Throwable {
		String text = new String();
		for(int i=0;i<=250;i++)
		{
			text=text+"a";
		}
		Assert.assertFalse(text + " exists", driver.getPageSource().contains(text));
	}

	
	@Then("^\"([^\"]*)\" should not exist$")
	public void should_not_exist(String text) throws Throwable {
		Assert.assertFalse(text + " exists", driver.getPageSource().contains(text));
	}

	@Then("^The My Task link should be in the NavBar$")
	public void the_My_Task_link_should_be_in_the_NavBar() throws Throwable {
		Assert.assertTrue("My Task not on NavBar", driver.findElement(By.linkText("My Tasks")).isDisplayed());
	}
	
	@Then("^I should be at My Tasks Page$")
	public void i_should_be_at_My_Tasks_Page() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new_task")));
		Assert.assertTrue("Not on My Tasks Page",driver.getCurrentUrl().equals("http://qa-test.avenuecode.com/tasks"));
	}
	
	@Then("^A message with the user name should be there$")
	public void a_message_with_the_user_name_should_be_there() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("new_task")));
		Assert.assertTrue("No message found", driver.getPageSource().contains(username + "'s ToDo List"));
	}
	
	@Then("^Both tasks should be added$")
	public void both_tasks_should_be_added() throws Throwable {
		Assert.assertTrue("Test1 not found", driver.getPageSource().contains("test1"));
		Assert.assertTrue("Test2 not found", driver.getPageSource().contains("test2"));
	}
}
