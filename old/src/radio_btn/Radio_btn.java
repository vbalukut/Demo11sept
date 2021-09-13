package radio_btn;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_btn {
static WebDriver driver;

public static void main(String[] args) {
	driver= new ChromeDriver();
	driver.get("file:///C:/Users/vikram/Desktop/JBK%20software/Selenium%20Softwares/Offline%20Website/pages/examples/add_user.html");
	List<WebElement> radio =driver.findElements(By.xpath("//input[@name='gender']"));
	for(int i=0;i<radio.size();i++)
	{
		WebElement radio_btn =radio.get(i);
		String value =radio_btn.getAttribute("value");
		System.out.println(value);
	
if(value.equals("Male")){
	radio_btn.click();
}}	
}
}
