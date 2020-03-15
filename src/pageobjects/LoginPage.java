
// Page Object for Login Page


package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	//public NgWebDriver ngWebDriver;
	
	//Page URL
	private static String PAGE_URL="http://cafetownsend-angular-rails.herokuapp.com/login";
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/label[1]/input")
	private WebElement user_name;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/label[2]/input")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='login-form']/fieldset/button")
	private WebElement login_button;
	
    
	/*public WebDriverWait wait = new WebDriverWait(driver, 5);
	private WebElement user_name = driver.findElement(ByAngular.model("user.name"));
	private WebElement password = driver.findElement(ByAngular.model("user.password"));
	private WebElement login_button = driver.findElement(By.xpath("//*[@id='login-form']/fieldset/button"));
	*/
	
	public LoginPage(WebDriver driver) {           
		this.driver = driver; 
		
        driver.get(PAGE_URL);
        // ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        //ngWebDriver.waitForAngularRequestsToFinish();
        PageFactory.initElements(driver, this);
        
	}
	
	public void set_user_name(String uname){
		assert user_name.isEnabled();
		user_name.clear();
		user_name.sendKeys(uname);
	   }
	
	public void set_password(String passwrd){
		assert password.isEnabled();
		password.clear();
		password.sendKeys(passwrd);
	   }
	
	public void click_login_button(){
		assert login_button.isEnabled();
		login_button.click();
	   }
	
}
