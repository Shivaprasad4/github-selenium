import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class demo2 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-popup-blocking");
	options.addArguments("start-maximized");
	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	
	driver.get("https://demoqa.com/text-box");
	driver.findElement(By.id("userName")).sendKeys("rama");
	driver.findElement(By.id("userEmail")).sendKeys("rama@gmail.com");
	driver.findElement(By.id("currentAddress")).sendKeys("bangalore");
	driver.findElement(By.id("permanentAddress")).sendKeys("bangalore");
	
//	driver.findElement(By.id("submit")).click();
	Thread.sleep(2000);
	System.out.println("I am Vefore");
	driver.switchTo().frame("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0");
	
	
	System.out.println("I am After");
//	driver.findElement(By.id("background_exit_dc")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(150,1050)");
	
//	System.out.println("I am After Close");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

	


	
}
}
