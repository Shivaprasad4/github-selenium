package com.mindtree.demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {
	private static void clickCompare(WebDriver driver) {
		try {
			driver.findElement(By.partialLinkText("SAMSUNG 253 L")).findElement(By.cssSelector("label._6Up2sF")).click();
		}
		catch(Exception e) {
			System.out.println("SAMSUNG 253 L Not Found");
		}
		try {
			driver.findElement(By.partialLinkText("SAMSUNG 198 L")).findElement(By.cssSelector("label._6Up2sF")).click();;
		}
		catch(Exception e) {
			System.out.println("SAMSUNG 198 L Not Found");
		}
		try {
			driver.findElement(By.partialLinkText("Whirlpool 190 L")).findElement(By.cssSelector("label._6Up2sF")).click();
		}
		catch(Exception e) {
			System.out.println("Whirlpool 190 L Not Found");
		}
		try {
			driver.findElement(By.partialLinkText("SAMSUNG 192 L")).findElement(By.cssSelector("label._6Up2sF")).click();
		}
		catch(Exception e) {
			System.out.println("SAMSUNG 192 L Not Found");
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();

		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("Refrigerator");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		clickCompare(driver);

		WebElement samsungAnchorText = driver.findElement(By.partialLinkText("SAMSUNG 198 L"));
		String SamsungSearchPrice = samsungAnchorText.findElement(By.cssSelector("div._30jeq3._1_WHN1")).getText();
		System.out.println("SearchPrice: "+SamsungSearchPrice);


		String Ref = driver.findElement(By.partialLinkText("SAMSUNG 198 L")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.WINDOW); 
		driver.manage().window().maximize();
		driver.get(Ref);

		String pagePrice = driver.findElement(By.cssSelector("div._30jeq3._16Jk6d")).getText();
		System.out.println("PagePrice: "+pagePrice);
		if(SamsungSearchPrice.contains(pagePrice)) {
			System.out.println("Prices are Matching");
		}

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _1FH0tX']")).click();

		List<WebElement> item = driver.findElements(By.xpath("//table[@class='_14cfVK'] //tr[@class='_1s_Smc row']"));
		
		System.out.println("IN TECHNICAL DETAILS");
		for(int i=0;i<item.size();i++) {

			if(item.get(i).getText().contains("Weight"))
			{
				System.out.println(item.get(i).getText());

				break;
			}
		}

		driver.findElement(By.cssSelector("a[class='_11o22n _87aCMT']")).click();
		List<WebElement> rowElements  = driver.findElements(By.xpath("//div[@class='row CQXY4c _3T4CNT']"));
		int start = 2;
		int end = 3;
		String searchPattern = "Capacity";
		System.out.println("IN COMPARE DETAILS PAGE");
		for(int i=0;i<rowElements.size();i++) {

			WebElement headerElement = rowElements.get(i).findElement(By.cssSelector("div._2EPN2A"));
			List<WebElement> contents = rowElements.get(i).findElements(By.cssSelector("div._3eKu10"));

			if(headerElement.getText().contentEquals(searchPattern)) {
				System.out.println(searchPattern+": ");
				for(int j=start-1;j<end;j++)
				{
					System.out.print(contents.get(j).getText()+" ");
				}
				break;	
			}
		}
		driver.quit();

	}

	

}
