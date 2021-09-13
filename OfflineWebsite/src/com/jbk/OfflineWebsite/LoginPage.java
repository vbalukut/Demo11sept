package com.jbk.OfflineWebsite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;
	@BeforeTest
	public void initialization(){
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void verifyTitle(){
		
		String actual="JavaByKiran | Log in";
		String expected=driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=1)
	public void verifyLogo(){
		
		WebElement logo=driver.findElement(By.xpath("//img[@src='pages/images/jbk.png']"));
		Assert.assertTrue(logo.isDisplayed());
		
	}
	@Test(priority=2)
	public void verifyText1(){
		
		String actual=driver.findElement(By.xpath("//h4[text()='JAVA | SELENIUM | PYTHON']")).getText();
		String expected="JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actual, expected);
	
	}
	@Test(priority=3)
	public void checkWithInvalidUsername(){
		
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("vikram@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String ExpErrmsg="Please enter email as kiran@gmail.com";
		String actualErr=driver.findElement(By.id("email_error")).getText();
		Assert.assertEquals(actualErr, ExpErrmsg);
		
	}
	@Test(priority=4)
	public void checkWithInvalidPassword(){
		
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("password")).sendKeys("12342");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String ExpErrmsg="Please enter password 123456";
		String actualErr=driver.findElement(By.id("email_error")).getText();
		Assert.assertEquals(actualErr, ExpErrmsg);
		
	}
@Test(priority=5)
public void checkWithValidCreds(){
	driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String ExpMsg = "JavaByKiran | Dashboard";
	Assert.assertEquals(driver.getTitle(),ExpMsg);
}
@Test(priority=6)
public void regNewUser(){
	driver.findElement(By.linkText("Register a new membership")).click();
	driver.findElement(By.id("name")).sendKeys("kiran");
	driver.findElement(By.id("mobile")).sendKeys("123456");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Alert alert=driver.switchTo().alert();
	String actual=alert.getText();
	String expected="User has been registered successfully";
	Assert.assertEquals(actual, expected);
	
}
@AfterTest
public void close(){
	driver.close();
}}

