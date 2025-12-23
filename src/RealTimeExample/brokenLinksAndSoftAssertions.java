package RealTimeExample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class brokenLinksAndSoftAssertions {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Need to get the href of a link and get url
		// Do OpenConnection and get the status code
		// iterate through all the links in footer and get href and url
		// Validate the status code which is greater than 400

		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert a = new SoftAssert(); // This is a testng assertion used for softassetions

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			// syntax to open connected with any url is

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD"); // need to set request method
			conn.connect();

			int statusCode = conn.getResponseCode();

			System.out.println(statusCode);

			a.assertTrue(statusCode < 400,
					"The link " + link.getText() + " is failed with status code of " + statusCode + "");

		}

		a.assertAll(); // this will used to check all the conditons and post the failed after execution
		driver.close();

	}

}
