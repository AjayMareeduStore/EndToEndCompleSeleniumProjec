package SeleniumBrushup1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildtoparentAndSiblingConcepts {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		// Sibling concepts  - /following-sibling::tagname
		
		// Relative xpath is used by // which can get anywhere in dom, wherease absoulte from starting of the dom which is not suggested
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String name = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(name);

 
		//child - parent - /parent::tagname
		
		// In CSS selector we cant to this traverse although css is faster but xpath can only do this
		
		String Parent = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
		System.out.println(Parent);
		

	}

}
