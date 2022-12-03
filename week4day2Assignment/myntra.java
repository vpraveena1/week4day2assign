package week4day2Assignment;
	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class myntra {

		public static void main(String[] args) throws IOException {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch=new ChromeOptions();
			ch.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(ch);
			driver.manage().window().maximize();
			driver.get("https://www.myntra.com/");
			WebElement men = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Men']"));
			Actions hover = new Actions(driver);
			hover.moveToElement(men).perform();
			driver.findElement(By.xpath("//li[@data-reactid='40']")).click();
			String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText().replaceAll("[^0-9]", "");
			System.out.println("Total Count: "+count);
			String jackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText().replaceAll("[^0-9]", "");
			int j=Integer.parseInt(jackets);
			String rainjackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText().replaceAll("[^0-9]", "");
			int k=Integer.parseInt(rainjackets);
			int d = j+k;
			String total = Integer.toString(d);
			if(count.contains(total)) {
				System.out.println("Count is: Matched");
			}
			else {
				System.out.println("Not Match Count");
			}
			driver.findElement(By.xpath("//label[text()='Jackets']")).click();
			driver.findElement(By.xpath("//div[@class='brand-more']")).click();
			driver.findElement(By.xpath("//label[text()='Duke']")).click();
			driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close sprites-remove')]")).click();
			List<WebElement> coatname = driver.findElements(By.xpath("//h3[@class='product-brand']"));
			System.out.println("No.Of Items : "+coatname.size());
			for(int c=0; c<coatname.size(); c++) {
				if(!coatname.get(c).getText().contains("Duke")) {
					System.out.println("not Duke Brad");
				}
			}
			System.out.println("All are Same Brand: Duke");
			WebElement findElement = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
			Actions sort_hover = new Actions(driver);
			sort_hover.moveToElement(findElement).perform();
			driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
			String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
			System.out.println("Product Price: "+price);
			driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> lst = new ArrayList<String>(windowHandles);
			driver.switchTo().window(lst.get(1));
			File source = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./snap/screen.png");
			FileUtils.copyFile(source, dest);
			driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
			driver.quit();
		}
	

}
