package com.mindtree.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class demo2 {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("start-maximized");
	options.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	
	//demoqa Site
	driver.get("https://demoqa.com/text-box");
	driver.findElement(By.id("userName")).sendKeys("rama");
	driver.findElement(By.id("userEmail")).sendKeys("rama@gmail.com");
	driver.findElement(By.id("currentAddress")).sendKeys("bangalore");
	driver.findElement(By.id("permanentAddress")).sendKeys("bangalore");
	
	driver.findElement(By.xpath("//*[@id=\"close-fixedban\"]/img")).click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://demoqa.com/select-menu");
	WebElement hAndL = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[4]/div"));
	
	Actions a = new Actions(driver);
	a.moveToElement(hAndL).build().perform();
	
	driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]/div/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"react-select-2-input\"]")).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.xpath("//*[@id=\"react-select-2-input\"]")).sendKeys(Keys.ENTER);

	
}
}
