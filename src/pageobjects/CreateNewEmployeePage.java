
// Page Object for Create Employee Page

package pageobjects;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateNewEmployeePage {
	
	private WebDriver driver;
	//Page URL
	//private static String PAGE_URL="http://cafetownsend-angular-rails.herokuapp.com/employees/new";
	
	@FindBy(xpath="//*[@ng-model='selectedEmployee.firstName']")
	private WebElement txt_first_name;
	
	@FindBy(xpath="//*[@ng-model='selectedEmployee.lastName']")
	private WebElement txt_last_name;
	
	@FindBy(xpath="//*[@ng-model='selectedEmployee.startDate']")
	private WebElement txt_start_date;
	
	@FindBy(xpath="//*[@ng-model='selectedEmployee.email']")
	private WebElement txt_email;
	
	@FindBy(xpath="//*[@class='formFooter']/button[2]")
	private WebElement button_add;
	
	
	public CreateNewEmployeePage(WebDriver driver) {           
		this.driver = driver; 
        //driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
	}
	
	public void set_first_name(String firstname){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assert txt_first_name.isEnabled();
		txt_first_name.clear();
		txt_first_name.sendKeys(firstname);
	   }
	
	public void set_last_name(String lastname){
		assert txt_last_name.isEnabled();
		txt_last_name.clear();
		txt_last_name.sendKeys(lastname);
	   }
	
	public void set_start_date(String startdate){
		assert txt_start_date.isEnabled();
		txt_start_date.clear();
		txt_start_date.sendKeys(startdate);
	   }
	
	public void set_email(String email){
		assert txt_email.isEnabled();
		txt_email.clear();
		txt_email.sendKeys(email);
	   }
	
	public void click_add_button(){
		assert button_add.isEnabled();
		button_add.click();
	   }
	
	public void isPageOpened(){
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertTrue(button_add.isEnabled());
		
	   }
}
