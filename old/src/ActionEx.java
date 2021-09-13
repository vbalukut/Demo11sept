import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionEx {
	WebDriver driver;
	Actions action;
	
@Test
public void test1() throws InterruptedException{
	System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://javabykiran.com/playground/");
	Thread.sleep(3000);
	List<WebElement> links=driver.findElements(By.xpath("//a[@class='nav-links']"));
	action= new Actions(driver);
	for(WebElement link:links)
	{action.moveToElement(link).pause(2000).build().perform();
	}
	
driver.findElement(By.linkText("Drag and Drop")).click();
Thread.sleep(2000);
  WebElement src =driver.findElement(By.xpath("//li[@data-name='Home']"));
  WebElement target =driver.findElement(By.xpath("//li[@data-name='Contact Us']"));
  action.dragAndDrop(src, target).perform();
  action.contextClick().perform();
  
  driver.findElement(By.linkText("login")).click();
  
  WebElement uname =driver.findElement(By.xpath("//input[@type='email']"));
  WebElement pass =driver.findElement(By.xpath("//input[@type='password']"));
  WebElement loginbtn =driver.findElement(By.xpath("//button[@type='submit']"));
  
  action.click(uname).sendKeys("kiran@gmail.com").build().perform();
  action.click(pass).sendKeys("123456").build().perform();
  action.click(loginbtn).perform();
}
}
