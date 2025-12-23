package SeleniumBrushup1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SynchronizationInSelenium {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		/*driver.get("https://www.amazon.in/ref=nav_logo");
		WebElement ele = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement ele2 = driver.findElement(By.id("twotabsearchtextbox"));
		
		
		//Actions is the class used to do mouse and keyboard actions in selenium
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		act.moveToElement(ele2).click().keyDown(Keys.SHIFT).sendKeys("Grip").doubleClick().build().perform();*/
		
		
		
		// This is how we handle windows in Selenium Using java 
		
		/*driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
	
		 
		// Peace of code to iterate between windows
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		
		driver.switchTo().window(ChildWindow);
		System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		String mailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(ParentWindow);
		driver.findElement(By.id("username")).sendKeys(mailId);*/
		
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); // This will move into frame
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement Drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);                     // Actions class is usefull for us to handle drag and drop
		act.dragAndDrop(drag, Drop).build().perform();
		
		driver.switchTo().defaultContent(); // This will bring back from frame
		
		
		
		
		
		
		
	
		
		


		

	}

}
