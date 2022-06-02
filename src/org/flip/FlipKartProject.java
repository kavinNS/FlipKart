package org.flip;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FlipKartProject {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\Eclipse program\\FlipkartSearch\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7092395624");
		driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys("01234567");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//WebElement price = driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]"));
		//Select a = new Select(price);
		//a.selectByValue("10000");
		WebElement price = driver.findElement(By.xpath("(//div[contains(@style,'transform')])[2]"));
		price.click();
		Actions a = new Actions(driver);
		a.dragAndDropBy(price, -150 , 0).perform();
		WebElement mobileprice = driver.findElement(By.xpath("//div[@class='_3sckoD']"));
		System.out.println("mobile price: "+ mobileprice.getText());
		
		//driver.findElement(By.xpath("(//div[@class='_3FdLqY'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='QvtND5 _2w_U27']")).click();
		driver.findElement(By.xpath("//div[text()='POCO']")).click();
		driver.findElement(By.xpath("//div[@class='THxusM _3yuvK8']")).click();
		WebElement model = driver.findElement(By.xpath("(//div[@class='_3sckoD'])[2]"));
		System.out.println("MOBILE MODEL: "+ model.getText());
		
		driver.findElement(By.xpath("//div[text()='4 GB']")).click();
		WebElement ram = driver.findElement(By.xpath("(//div[@class='_3sckoD'])[3]"));
		System.out.println("MOBILE RAM: "+ ram.getText());
		
		Thread.sleep(3000);
		TakesScreenshot tk= (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File("F:\\JAVA\\Eclipse program\\FlipkartSearch\\screenshot\\mobile.png");
		FileUtils.copyFile(source, target);
		
	}

}
