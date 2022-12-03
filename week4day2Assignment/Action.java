package week4day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Assignment 8: (Actions)
=============
LeafGround Assignment:
https://www.leafground.com/drag.xhtml
*/
public class Action {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.switchTo().frame(0);
		WebElement drag= driver.findElement(By.xpath("//div[@id='form:conpnl']"));
		
		Actions builder=new Actions(driver);
		System.out.println(drag.getLocation());
		builder.dragAndDropBy(drag, 200, 50).perform();
		System.out.println(drag.getLocation());
		WebElement source = driver.findElement(By.xpath("//div[@id='form:drag_content']/p"));
		WebElement desti = driver.findElement(By.xpath("//div[@id='form:drop_content']/p"));
		Actions build = new Actions(driver);
		build.dragAndDrop(source, desti).perform();
		System.out.println(desti.getText());
		
		
	}
	

}
