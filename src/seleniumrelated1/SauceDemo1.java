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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SauceDemo1 {
	WebDriver driver;
@BeforeClass
public void openbrowser() {
	
	System.setProperty("webdriver.chromedriver", "E:\\\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	driver.navigate().to("https://www.saucedemo.com/");
	
	
}
@Test(priority=1)
public void login() throws InterruptedException {
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(2000);
}
@Test(priority=2)
public void selectproduct() {
	driver.findElement(By.xpath("//a[@id='item_4_title_link']/div")).click();
	driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(2));
	driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
	
}
@Test(priority=3)
public void removeproduct() throws IOException {
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
}
@Test(priority=4)
public void logout() {
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.id("logout_sidebar_link")).click();
	
}
@AfterClass
public void closebrowser() {
	driver.close();
}
}
