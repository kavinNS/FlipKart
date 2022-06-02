package org.flip;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartSearch {
	public static void main(String[] args) throws Exception, IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\Eclipse program\\FlipkartSearch\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7092395624");
		driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys("01234567");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Thread.sleep(3000);
		
		WebElement home = driver.findElement(By.xpath("//div[contains(text(),'Beauty, Toys & More')]"));
		
		Actions a = new Actions(driver);
		a.moveToElement(home).perform();
		Thread.sleep(2000);
		
		WebElement women = driver.findElement(By.xpath("//a[text()='Baby Care']"));
		a.moveToElement(women).perform();
		
		driver.findElement(By.xpath("//a[text()='Baby Diapers']")).click();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='s1Q9rs']")).click();

		String di = driver.getWindowHandle();
		Set<String> alldi = driver.getWindowHandles();
		
		for(String da:alldi) {
			if(!di.equals(alldi)) {
				driver.switchTo().window(da);
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		Thread.sleep(3000);
		TakesScreenshot tk= (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File("F:\\JAVA\\Eclipse program\\FlipkartSearch\\screenshot\\flip.png");
		FileUtils.copyFile(source, target);
	}
	}















		
		


