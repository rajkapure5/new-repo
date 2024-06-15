package seleniumrelated1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndianRailway {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver", "E:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//div[@class='h_container_sm']/div[2]/a/i")).click();
		driver.findElement(By.xpath("//div[@class='ng-star-inserted']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("2814041")).sendKeys("rajkapure5");
		driver.findElement(By.id("465605")).sendKeys("Raj2151kapure");

	}

}
