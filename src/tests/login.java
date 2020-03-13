package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\z003srtv\\Documents\\SeleniumDocs\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
		
		System.out.println(driver.getTitle());
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-form']/fieldset/label[1]/input")));
		
		driver.findElement(By.xpath("//*[@id='login-form']/fieldset/label[1]/input")).sendKeys("Luke");
		driver.findElement(By.xpath("//*[@id='login-form']/fieldset/label[2]/input")).sendKeys("Skywalker");
		driver.findElement(By.xpath("//*[@id='login-form']/fieldset/button")).click();

	}

}

