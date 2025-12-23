package SeleniumBrushup1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownBrushup {

	public static void main(String[] args) throws InterruptedException {

		// Select will be as tagname if it is static dropdown
		// we use Select class to work on static dropdowns

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select slt = new Select(element);

		slt.selectByIndex(1);

		System.out.println(slt.getFirstSelectedOption().getText());

		slt.selectByValue("AED");

		System.out.println(slt.getFirstSelectedOption().getText());

		slt.selectByVisibleText("USD");

		System.out.println(slt.getFirstSelectedOption().getText());

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000);

		int i = 1;

		while (i < 6) {

			driver.findElement(By.id("hrefIncAdt")).click();

			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// Handling dynamic dropdown using parent-child xpath

		// if we see no such element execption it means xpath is wrong
		// if we see element not visible exception it means it has intercepted or
		// dulicate

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR'] ")).click();

		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0...5")) {

			Assert.assertTrue(true);

		}

		else {

			System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
			Assert.assertTrue(false);

		}

		// Handling suggestive dropdown using conditional statements

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> Options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement options : Options) {

			if (options.getText().equalsIgnoreCase("india")) {

				options.click();

				break;

			}

		}

	}

}
