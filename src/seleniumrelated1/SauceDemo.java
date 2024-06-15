package seleniumrelated1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;
public class SauceDemo {
		// TODO Auto-generated method stub
	WebDriver driver;
	public void Sauce() throws InterruptedException {
		System.setProperty("webdriver.chromedriver", "E:\\testng jar files\\New folder\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origin=*");
		driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='item_4_title_link']/div")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println(Thread.currentThread());
		driver.close();
		
	}
	@Test(priority=2,enabled=false)
	public void saucedemo() throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "E:\\selenium project\\geckodriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='item_4_title_link']/div")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(2));
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scroll(0,200)");
		boolean k=driver.findElement(By.id("checkout")).isDisplayed();
		System.out.println(k);
		boolean l=driver.findElement(By.id("checkout")).isEnabled();
		System.out.println(l);
		File m=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(m, new File("E:\sscreenshot.jpg"));
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	System.out.println(Thread.currentThread());
		driver.close();
	}

}
