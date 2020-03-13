package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;
import pageobjects.EmployeesPage;
import pageobjects.CreateNewEmployeePage;

public  class Tests {
	
	 WebDriver driver;
	 public LoginPage loginpage;
	 public EmployeesPage employeepage;
	 public CreateNewEmployeePage createnewemployee;
	 
	
	@Before
	   public void setup(){
	       //
		
	       driver = new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	       // headless yap
	       loginpage = new LoginPage(driver);
	       employeepage = new EmployeesPage(driver);
	       createnewemployee= new CreateNewEmployeePage(driver);
	       
	   }
	@Test
	   public void login() {
		
	       //Create object of LoginPage Class

			loginpage.set_user_name("Luke");
			loginpage.set_password("Skywalker");
			loginpage.click_login_button();
			employeepage.isPageOpened();
	   }
	@Test
	public void addnewemployee() {
		
	       //Create object of LoginPage Class
			login();
			employeepage.click_create_user_button();
			createnewemployee.isPageOpened();
			
			createnewemployee.set_first_name("Onur");
			createnewemployee.set_last_name("s");
			createnewemployee.set_start_date("2020-12-12");
			createnewemployee.set_email("a@b");
			createnewemployee.click_add_button();
			
			
			Assert.assertTrue(employeepage.checkemployee("Onur","s"));
	   
	}
	
	

	  @After
	    public void close(){
	          driver.close();
	       }

}
