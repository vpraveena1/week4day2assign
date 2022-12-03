package week4day2Assignment;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://html.com/tags/table/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				List <WebElement> col = driver.findElements(By.xpath("(//table)[1]//tr//th"));
				for(int i=1; i<=col.size();i++) {
			List <WebElement> row = driver.findElements(By.xpath("(//table)[1]//tr[2]//td["+i+"]"));
			for(int j=0; j<row.size();j++) {
				System.out.println(row.get(j).getText());
			}
		 }
	  }
  }
	