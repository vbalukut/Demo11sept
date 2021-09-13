package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Locators {
WebDriver driver ;
@Test
public void test(){
	
	/*//Default locators
	
	driver.findElement(By.id("email"));
	driver.findElement(By.name("viewport"));
	driver.findElement(By.tagName("P"));
	driver.findElement(By.className("btn btn-primary btn-block btn-flat"));
	
	//HyperLink test
	
	driver.findElement(By.linkText("Register a new membership"));
	driver.findElement(By.partialLinkText("Register"));
	
	//Css Selector
	
	//id
	driver.findElement(By.cssSelector("input#email"));
	
	//name
	driver.findElement(By.cssSelector("div.login-logo"));
	
	//tagname-class-attributes
	driver.findElement(By.cssSelector("button.btn btn-primary btn-block btn-flat[type='submit']"));
	
	//tagname-id-attributes
		driver.findElement(By.cssSelector("div#password_error[stype='color:red;']"));*/
	
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/add_user.html");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
Select select = new Select(driver.findElement(By.tagName("select")));
select.deselectByVisibleText("Maharashtra");
}
}
