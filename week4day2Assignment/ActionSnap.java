package week4day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSnap {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--disable-notifications");
        
        driver.get("https://www.snapdeal.com/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@class='catText']"))).perform();
        
        driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
	}

}