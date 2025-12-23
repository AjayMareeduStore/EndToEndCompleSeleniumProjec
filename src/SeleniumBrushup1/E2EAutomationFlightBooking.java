package SeleniumBrushup1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EAutomationFlightBooking {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR'] ")).click();

		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {

			Assert.assertTrue(true);

		}

		else {

			System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
			Assert.assertTrue(false);

		}

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000);

		int i = 1;

		while (i < 6) {

			driver.findElement(By.id("hrefIncAdt")).click();

			i++;
		}

		WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select slt = new Select(element);

		slt.selectByIndex(1);

		System.out.println(slt.getFirstSelectedOption().getText());

		slt.selectByValue("AED");

		System.out.println(slt.getFirstSelectedOption().getText());

		slt.selectByVisibleText("USD");

		System.out.println(slt.getFirstSelectedOption().getText());

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
