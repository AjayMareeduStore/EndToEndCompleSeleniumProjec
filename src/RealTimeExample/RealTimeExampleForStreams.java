package RealTimeExample;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RealTimeExampleForStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on Veggies sorted list
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();

		// Get all the elements in veggies
		List<WebElement> veggiesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		// get all the values of the elements
		List<String> veggiesNamesList = veggiesList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort the values and store in a string
		List<String> orginialSortedList = veggiesNamesList.stream().sorted().collect(Collectors.toList());

		List<String> sortedToValidateList = orginialSortedList.stream().sorted().collect(Collectors.toList());

		// Compare two sorted values with assertion

		Assert.assertTrue(sortedToValidateList.equals(orginialSortedList));

		List<String> veggiePrice;

		do {
			// Get the price elements and values of the veggies
			List<WebElement> veggiesList1 = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			veggiePrice = veggiesList1.stream().filter(s -> s.getText().contains("Rice")).map(s -> veggiesPrice(s))
					.collect(Collectors.toList());

			veggiePrice.stream().forEach(s -> System.out.println(s));

			// Move on to all the pages using paginations and get the price
			if (veggiePrice.size() < 1) {

				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}

		} while (veggiePrice.size() < 1);

		// Click on search textbox and enter data
		driver.findElement(By.id("search-field")).sendKeys("Rice");

		// Get the all veggies values present in the table
		List<WebElement> vegList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		List<WebElement> searchResult = vegList.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());

		Assert.assertEquals(vegList.size(), searchResult.size());

	}

	private static String veggiesPrice(WebElement s) {

		// Get the exact price of a single required veggie
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return price;
	}

}
