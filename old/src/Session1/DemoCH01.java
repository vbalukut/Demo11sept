package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCH01 {
	@Test 
	public void testLoginSuccessful() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		driver.close();
	}
	
	@Test(dependsOnMethods= "testLoginSuccessful")
	public void testDashboard() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/dashboard.html");
		driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b")).getText();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		driver.close();
	}
	
	
	@Test(dependsOnMethods= "testDashboard")
	public void userTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/users.html");
		String actErrMsg = driver
				.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).getText();
		String expErrMsg = "Add User";
		Assert.assertEquals(actErrMsg, expErrMsg);
		driver.close();
	}
}
