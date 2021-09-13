package session7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Set;

public class PopupWindowHandle {

	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/dashboard.html");
		List<WebElement> links=(List<WebElement>) driver.findElement(By.linkText("More info"));
		String mainWindow =driver.getWindowHandle();
		
		for(WebElement link:links)
		{link.click();
		Set<String> window =driver.getWindowHandles();
		for(String win:window)
		{System.out.println(win);
		if(!win.equals(mainWindow))
		{
			driver.switchTo().window(win);
			driver.getCurrentUrl().contains("Python");
			driver.close();
		}
		}
		}
	}
}
