package RealTimeExample;

import java.lang.reflect.Parameter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class caledarsExample {

	public static void main(String[] args) {
		
		String date = "5";
		String month = "9";
		String year = "2022";
		
		String [] calender = {month,date,year};

        WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		
	    List<WebElement> el = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
	    
	    for(int i = 0; i<el.size(); i++) {
	    	
	    	System.out.println(el.get(i).getAttribute("value"));
	    	Assert.assertEquals(el.get(i).getAttribute("value"), calender[i]);
	    }
	    
	    
	}

}
