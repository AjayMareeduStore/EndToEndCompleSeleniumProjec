package RealTimeExample;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAddtoCartQuestion {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		//Implcit wait is more readable but as it is globally used it cannot fine the performance issues.
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	    //Explicit wait is used to targer specific element to load instead of all element.
		
		// Explicti and fluent are from wait interface
		
		//Fluent wait has polling interval time which can only search for based in interval time given.
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		

		String[] itemsNeeded = { "Brocolli", "Beans" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        AddItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("Ajay");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //Untill(ExpectedConditions.invisibilityofelementLocated is mostly used.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void AddItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException {

		int j = 0;
		List<String> requiredItems = Arrays.asList(itemsNeeded);
		List<WebElement> veggies = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < veggies.size(); i++) {

			String[] listedItems = veggies.get(i).getText().split("-");
			String actualVeggies = listedItems[0].trim();

			if (requiredItems.contains(actualVeggies)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				
				j++;

				if (j == itemsNeeded.length) {

					System.out.println("Requested Items Successfully Added into the cart");

					break;
				}
			}

		}
	}

}
