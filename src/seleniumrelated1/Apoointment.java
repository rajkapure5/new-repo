package seleniumrelated1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Apoointment {
	WebDriver driver;
	
	@BeforeClass
	public void openbrowser() {
		System.setProperty("webdriver.chromedriver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://katalon-demo-cura.herokuapp.com");
	}
	@Test(priority=1)
	public void login() {
		driver.findElement(By.xpath("//a[@id='menu-toggle']/i")).click();
		driver.findElement(By.xpath("//nav[@id='sidebar-wrapper']/ul//li[3]/a")).click();
		driver.findElement(By.name("username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
	}
	@Test(priority=2)
	public void form() throws InterruptedException {
	
		JavascriptExecutor execut=(JavascriptExecutor)driver;
		execut.executeScript("window.scroll(0,400)");
		Select s=new Select(driver.findElement(By.id("combo_facility")));
		s.selectByVisibleText("Hongkong CURA Healthcare Center");
		driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).getCssValue("font-color");
		
	boolean r=driver.findElement(By.id("chk_hospotal_readmission")).isSelected();
	System.out.println(r);
	Reporter.log("r");
	driver.findElement(By.id("chk_hospotal_readmission")).click();
	driver.findElement(By.id("radio_program_medicaid")).click();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//section[@id='appointment']/div[1]/div[1]/form/div[4]/div[1]/div[1]/div[1]/span")).click();
	String a="14";
	List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='table-condensed']//td"));
	for(WebElement ele:alldates) {
		String d=ele.getText();
		if(d.equals(a)) {
			ele.click();
			break;
		}
	}
	boolean j=driver.findElement(By.id("btn-book-appointment")).isDisplayed();
	Reporter.log("j");
	System.out.println(j);
	boolean b=driver.findElement(By.id("btn-book-appointment")).isEnabled();
	Reporter.log("b");
	System.out.println(b);
	
	}
	@Test(priority=3)
	public void printmsg() {
	Assert.assertTrue(driver.findElement(By.xpath("//section[@id='appointment']/div/div/div/h2")).getText().matches("Make Appointment"));
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	}
	@Test(priority=4)
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='menu-toggle']/i")).click();
		
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
}
