
// Test file for cucumber steps

package tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CreateNewEmployeePage;
import pageobjects.EmployeesPage;
import pageobjects.LoginPage;


//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = { "pretty"},features = { "src/steps/" })

public class tests {
	 WebDriver driver;
	 public LoginPage loginpage;
	 public EmployeesPage employeepage;
	 public CreateNewEmployeePage createnewemployee;
	
	 
	 @Before
	 public void setup() {
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	       // headless yap
	      loginpage = new LoginPage(driver);
	      employeepage = new EmployeesPage(driver);
	      createnewemployee= new CreateNewEmployeePage(driver);
	 }
	 
	@After
	public void close(){
	   driver.close();
	   }
	 
	 
	@Given("uname is luke password skywalker")
    public void uname_is_luke_password_skywalker() {
		loginpage.set_user_name("Luke");
		loginpage.set_password("Skywalker");
		
    }
 
    @When("user click login button")
    public void user_click_login_button()  {
    	loginpage.click_login_button();
		
    }
 
    @Then("user login successful")
    public void user_login_successful(){
    	employeepage.isPageOpened();
    }
	
    @Given("user logins to system and goes to create new employee page")
    public void user_logins_to_system_and_goes_to_create_new_employee_page() {
        
    	uname_is_luke_password_skywalker();
    	user_click_login_button();
    	user_login_successful();
    }

    @When("user enters new employee information and clicks add button")
    public void user_enters_new_employee_information_and_clicks_add_button() {
    	
    	employeepage.click_create_user_button();
		createnewemployee.isPageOpened();
    	createnewemployee.set_first_name("Onur");
		createnewemployee.set_last_name("s");
		createnewemployee.set_start_date("2020-12-12");
		createnewemployee.set_email("a@b.com");
		createnewemployee.click_add_button();
    }

    @Then("new employee operation is successful")
    public void new_employee_operation_is_successful() {
        
    	Assert.assertTrue(employeepage.checkemployee("Onur","s"));
    }

    
}
