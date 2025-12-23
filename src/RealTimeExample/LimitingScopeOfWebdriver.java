package RealTimeExample;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingScopeOfWebdriver {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// get the count of links available in the page

		System.out.println(driver.findElements(By.tagName("a")).size());

		// get the count of links available in the footer sections

		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// get the count of links available in the cloumn a in the footer section

		WebElement coloumnA = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		System.out.println(coloumnA.findElements(By.tagName("a")).size());
		List<WebElement> el = coloumnA.findElements(By.tagName("a"));

		for (int i = 1; i < el.size(); i++) {

			String newWindow = Keys.chord(Keys.CONTROL, Keys.ENTER);
			el.get(i).sendKeys(newWindow);

		}

		// Iteared through all the window got the title

		Set<String> it = driver.getWindowHandles();
		Iterator<String> items = it.iterator();

		while (items.hasNext()) {

			driver.switchTo().window(items.next());
			System.out.println(driver.getTitle());

		}

		// Click on everylink and get the page title

	}

}
