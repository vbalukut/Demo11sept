package com.jbk.OfflineWebsite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserPage {
WebDriver driver;
boolean status=false;
@BeforeTest
public void initialization(){
	System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/users.html");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
}
@Test
	public void numberOfColumns(){
	List<WebElement> table =driver.findElements(By.xpath("//table[@class='table table-hover']//th"));
	for(WebElement element:table){
		String contentOfTable=element.getText();
		System.out.println(contentOfTable);
		if(contentOfTable.equalsIgnoreCase("state")){
			status=true;
		}//table[@class='table table-hover']//tr//td[1]
	}
	Assert.assertEquals(table.size(), 8);
}

@Test
public void numberOfRows(){
List<WebElement> table =driver.findElements(By.xpath("//table[@class='table table-hover']//tr//td[1]"));
for(WebElement element:table){
	String contentOfTable=element.getText();
	System.out.println(contentOfTable);
	if(contentOfTable.equalsIgnoreCase("state")){
		status=true;
	}
}
Assert.assertEquals(table.size(), 4);
}



@Test
public void verifyUserNames(){
List<WebElement> tablecontent =driver.findElements(By.xpath("//table[@class='table table-hover']//tr//td[6]"));
//List<WebElement> userNames =driver.findElements(By.xpath("//table[@class='table table-hover']//tr//td[6]//preceding-sibling::td[4]"));

//ArrayList<String> tableData=new ArrayList<>();
for(WebElement element:tablecontent){
	String contentOfTable=element.getText();
	System.out.println(contentOfTable);
	if(contentOfTable.equalsIgnoreCase("Male")){
		System.out.println();
	}
}}

@Test
public void deleteDefaultUser(){
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[8]/a/span")).click();
	Alert alert=driver.switchTo().alert();
	String actualmsg=alert.getText();
	String expectedmsg="You can not delete Default User";
	Assert.assertEquals(actualmsg, expectedmsg);
	
}
@Test
public void deleteUser(){
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[3]/td[8]/a/span")).click();
	Alert alert=driver.switchTo().alert();
	String actualmsg=alert.getText();
	String expectedmsg="Are you sure you want to delete this user";
	Assert.assertEquals(actualmsg, expectedmsg);
	
}
@Test
public void addUser(){
	driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("kiran");
	driver.findElement(By.id("mobile")).sendKeys("123456");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("java");
	driver.findElement(By.id("Male")).click();

WebElement wb = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
Select ss = new Select(wb); 
ss.selectByIndex(1);

Select select = new Select(driver.findElement(By.xpath(("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"))));
select.selectByVisibleText("Maharashtra");
select.selectByVisibleText("3");
driver.findElement(By.xpath("//input[@class ='form-control']")).sendKeys("123456");
driver.findElement(By.xpath("//button[@id='button']")).click();
}

@AfterTest
public void close(){
	driver.close();
}
}