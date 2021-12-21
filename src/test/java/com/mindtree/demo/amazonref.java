package com.mindtree.demo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author shiva
 *
 */
public class amazonref {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Refrigerator");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String searchPrice ="";
		List<WebElement> divElement = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		
		for(int i=0;i<divElement.size();i++) {
		if(divElement.get(i).findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")).getText().contains("Samsung 198 L 4")) {
		System.out.println("ITEM FOUND");
		System.out.println("ITEM NAME--> "+divElement.get(i).findElement(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")).getText());
		WebElement Spanprice = divElement.get(i).findElement(By.className("a-price-whole"));
		System.out.println("ITEM PRICE :"+Spanprice.getText());
		searchPrice = Spanprice.getText();
		break;
		}
		}

		String Ref = driver.findElement(By.partialLinkText("Samsung 198 L 4")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		driver.get(Ref);
		Set<String> id = driver.getWindowHandles();
		Iterator<String> s = id.iterator();
		String parent = s.next();
		String child = s.next();
		driver.switchTo().window(child);
       
		String price = driver.findElement(By.id("priceblock_ourprice")).getText();
		System.out.println();
		System.out.println("New Window Page Price:" + price);
		
		List<WebElement> head=driver.findElements(By.xpath("//table[@id='productDetails_techSpec_section_1']/tbody/tr/th"));
		List<WebElement> data=driver.findElements(By.xpath("//table[@id='productDetails_techSpec_section_1']/tbody/tr/td"));

        for(int i=0;i<head.size();i++) {
        	if(head.get(i).getText().contentEquals("Capacity"))
        	{
        		System.out.println("Capacity:"+data.get(i).getText());
        		break;
        	}
        }
        
        if(price.contains(searchPrice)) {
        	System.out.println("Prices Are Matching");
        }
        
        List<WebElement> itemWeight = driver.findElements(By.xpath("//table[@id='HLCXComparisonTable'] //tr[@class='comparison_other_attribute_row']"));
        
        for(int i=0;i<itemWeight.size();i++) {
        	
        	if(itemWeight.get(i).getText().contains("Item Weight"))
        	{
        		System.out.println(itemWeight.get(i).getText());
        		break;
        	}
        }
        driver.quit();
        
	}

}
