package SeleniumBrushup1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String Username = "rahul";
		
		String Password = GetPassword(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(Username);

		driver.findElement(By.name("inputPassword")).sendKeys(Password);
		
		driver.findElement(By.id("chkboxTwo")).click();

		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
		
		Thread.sleep(3000);
		
		String RetriveDataUsername = driver.findElement(By.tagName("h2")).getText();
		
		String RetriveData = driver.findElement(By.tagName("p")).getText();
		
		Assert.assertEquals(RetriveData, "You are successfully logged in.");
		
		Assert.assertEquals(RetriveDataUsername, "Hello "+Username+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']"));
		
		System.out.println(RetriveData);
		
		driver.close();
		
				
		
		
	

	}
	
	public static String GetPassword(WebDriver driver) throws InterruptedException 
	{
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);//
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		Thread.sleep(2000);

		String text = driver.findElement(By.cssSelector("form p")).getText();
		
		String [] GetPassword = text.split("'");
		
		String PasswordText = GetPassword[1].split("'")[0];
	
		return PasswordText;
		
		
	}

}
