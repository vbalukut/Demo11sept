package com.jbk.OfflineWebsite;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dashboard {
	WebDriver driver;
	@BeforeTest
	public void initialization(){
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/dashboard.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void checkTitle(){
		String actual="JavaByKiran | Dashboard";
		String expected=driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=2)
	public void courses(){
		
		ArrayList<String> expListOfCourses =new ArrayList<>();
		expListOfCourses.add("Selenium");
		expListOfCourses.add("Java / J2EE");
		expListOfCourses.add("Python");
		expListOfCourses.add("Php");
		
		ArrayList<String> actualListOfCourses =new ArrayList<>();
		
		List<WebElement> elements =driver.findElements(By.tagName("h3"));
		for(WebElement actListOfElements:elements){
			String actList= actListOfElements.getText();
			actualListOfCourses.add(actList);
			
	}
		Assert.assertEquals(actualListOfCourses, expListOfCourses);
		}
	
	@Test(priority=3)
	public void faculty(){
		
		ArrayList<String> expListOfCourses =new ArrayList<>();
		expListOfCourses.add("Automation Testing");
		expListOfCourses.add("Software Development");
		expListOfCourses.add("Data Science");
		expListOfCourses.add("Web Development");
		
		ArrayList<String> actualListOfCourses =new ArrayList<>();
		
		List<WebElement> elements =driver.findElements(By.tagName("p3"));
		for(WebElement actListOfElements:elements){
			String actList= actListOfElements.getText();
			actualListOfCourses.add(actList);
			
	}
		Assert.assertEquals(actualListOfCourses, expListOfCourses);
		}

	@Test(priority=3)
	public void moreInfo(){
		
		ArrayList<String> expListOfCourses =new ArrayList<>();
		expListOfCourses.add("Automation Testing");
		expListOfCourses.add("Software Development");
		expListOfCourses.add("Data Science");
		expListOfCourses.add("Web Development");
		
		//ArrayList<String> actualListOfCourses =new ArrayList<>();
		
		List<WebElement> elements =driver.findElements(By.xpath("//a[@class='small-box-footer']"));
		for(WebElement actListOfElements:elements){
			actListOfElements.click();
			
			
	}
		/*Assert.assertEquals(actualListOfCourses, expListOfCourses);*/
		}
@AfterSuite
public void close(){
	driver.close();
}}