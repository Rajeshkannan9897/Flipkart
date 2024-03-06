package flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartFlow {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*"); 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());      //to verify that the home page loads successfully.
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("laptop",Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='CXW8mj']//img)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> tab = new ArrayList<String>(windowHandles);
		driver.switchTo().window(tab.get(1));
		WebElement element = driver.findElement(By.xpath("(//li[@class='col col-6-12']//button)[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='Cart']")).click();
	    Thread.sleep(3000);
	    WebElement element2 = driver.findElement(By.xpath("//span[text()='Place Order']"));
	    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	    executor1.executeScript("arguments[0].click();", element2);
	    driver.findElement(By.tagName("input")).sendKeys("offirajeshkannan@gmail.com");
	    driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
	    driver.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']")).sendKeys("8270383779");
	    driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _20xBvF')]")).click();
	}

}
