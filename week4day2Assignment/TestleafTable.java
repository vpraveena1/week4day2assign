package week4day2Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Assignment4:
============
1.http://testleaf.herokuapp.com/pages/table.html
2.https://leafground.com/table.xhtml  */
public class TestleafTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//column count and display
		List<WebElement> column = driver.findElements(By.xpath("//table//th"));
		
		System.out.println(column.size());
		for (int i = 0; i < column.size(); i++) {
			System.out.println(column.get(i).getText());
					}
		//row count and display
List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
		
		System.out.println(row.size());
		for (int i = 0; i < row.size(); i++) {
			System.out.println(row.get(i).getText());
		}
		//progress value
			String text = driver.findElement(By.xpath("(//font[@color='black'])[7]")).getText();
			System.out.println("Progess value is"+text);
			//vital task
			String text2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).getText();
			System.out.println("vital "+text2);
					}

}
