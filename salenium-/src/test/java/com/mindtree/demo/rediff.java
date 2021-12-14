package com.mindtree.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rediff.com");
		
		driver.findElement(By.cssSelector("a[class*=signin]")).click();
		driver.findElement(By.xpath("//input[(@id='login1')]")).sendKeys("raghu");
		driver.findElement(By.xpath("//input[(@name='passwd')]")).sendKeys("rcb");
		driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();

	}

}
