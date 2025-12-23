package RealTimeExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; //Static package to import manually or selenium 4

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

public class Selenium4Features {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		// Above

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());

		// Below
		WebElement dob = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();

		// RightSide

		WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText());

		// LeftSide
		WebElement radioBtnClick = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(radioBtnClick)).click();

		// SwitchToNewTab and get Data Parrallelly
		driver.switchTo().newWindow(WindowType.TAB); // this will invoke new tab

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver
				.findElements(By.cssSelector("[class*='text-primary transition-colors leading-tight']")).get(1)
				.getText();

		WebElement name1 = driver.switchTo().window(parentWindow).findElement(By.xpath("(//input[@name='name'])[1]"));
		name1.sendKeys(courseName);

		// GetScreenshotOFaWebElement
		File file = name1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\admin\\Desktop\\ScreenShots\\ScreenShot1.png"));
		
		//get dimenstions any element 
		
		System.out.println(name1.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());

	}

}
