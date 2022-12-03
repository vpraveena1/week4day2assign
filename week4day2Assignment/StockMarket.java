package week4day2Assignment;
/*Assignment1:
============
1. Launch the URL https://www.chittorgarh.com/
2. Click on stock market
3. Click on NSE bulk Deals
    hint-(Table-2)
4. Get all the Security names
5. Ensure whether there are duplicate Security names8 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockMarket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement> scurityname = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr"));
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i <scurityname.size(); i++) {
			
			String name = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]//td[3]")).getText();
			
			list.add(name);
			
			System.out.println(name);
			
		}
		int size = list.size();
		
		System.out.println("List  Size "+size);
		
		Set<String> set = new LinkedHashSet<String>(list);
		
		int size2 = set.size();
		
		System.out.println("Set Size "+size2);
		
		if (size==size2) {
			
			System.out.println("Dup Not Removed");
			
		}
		else {
			System.out.println("Dup Removed");
		}
		
	}

}
