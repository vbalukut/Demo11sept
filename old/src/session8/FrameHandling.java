package session8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameHandling {
WebDriver driver;
	
	@Test
	public void test02()throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("signin-block")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		Thread.sleep(5000);
		driver.findElement(By.id("mobileNoInp")).sendKeys("596325852");
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		Thread.sleep(5000);
		driver.findElement(By.id("recaptcha-anchor")).click();

}
}