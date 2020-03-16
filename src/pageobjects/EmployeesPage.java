
// Page Object for Employees Page

package pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class EmployeesPage {
	
	private WebDriver driver;
	//Page URL
	//private static String PAGE_URL="http://cafetownsend-angular-rails.herokuapp.com/employees";
	
	@FindBy(id="bAdd")
	private WebElement button_create_user;
	
	@FindBy(id="bEdit")
	private WebElement button_edit_user;
	
	@FindBy(id="bDelete")
	private WebElement button_delete_user;
	
	@FindBy(id="employee-list")
	private WebElement employee_list;
	
	@FindBy(id="greetings")
	private WebElement greetings;
	
	@FindBy(id="employee-list")
	private WebElement employeelist;
	
	@FindBy(xpath="//*[@ng-repeat='employee in employees']")
	private WebElement list_elements;
	
	public EmployeesPage(WebDriver driver) {           
		this.driver = driver; 
        //driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
	}
	
	public void click_create_user_button(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assert button_create_user.isEnabled();
		button_create_user.click();
	   }
	
	public void click_edit_user_button(){
		assert button_edit_user.isEnabled();
		button_edit_user.click();
	   }
	
	public void click_delete_user_button(){
		assert button_delete_user.isEnabled();
		button_delete_user.click();
	   }
		
	public void isPageOpened(){

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals("Hello Luke",greetings.getText());
		
	   }
	
	public boolean checkemployee(String empName, String empSName) {
		
		List<WebElement> emplist = employeelist.findElements(By.tagName("li"));
		String fullname= empName +" "+empSName;
		boolean result = false;
		System.out.println("Full Name: " + fullname);
		System.out.println("Total Employee Number: " + emplist.size());
		
		for (WebElement we: emplist)	
		{
			System.out.println("Full Name In List: " + we.getText());
			
			if (we.getText().contains(fullname))
			{
				result=true;
				break;
			}
			else {result= false;}
		}
		System.out.println("Result: " + result);
		return result;
		
	}
}
