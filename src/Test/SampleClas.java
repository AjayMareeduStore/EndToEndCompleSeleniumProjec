package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SampleClas {
    public static void main(String[] args) {
    	
    	WebDriver driver = new ChromeDriver();
        driver.get("https://udemy.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
