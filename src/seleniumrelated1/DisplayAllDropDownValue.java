package seleniumrelated1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DisplayAllDropDownValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chromedriver", "E:\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.navigate().to("https://katalon-demo-cura.herokuapp.com");
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//a[@id='menu-toggle']/i")).click();
				driver.findElement(By.xpath("//nav[@id='sidebar-wrapper']/ul//li[3]/a")).click();
				driver.findElement(By.name("username")).sendKeys("John Doe");
				driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
				driver.findElement(By.id("btn-login")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				Select s=new Select(driver.findElement(By.id("combo_facility")));
				List<WebElement>drop=s.getOptions();
				System.out.println("number is"+drop.size());
				for(WebElement ele:drop) {
					String t=ele.getText();
					System.out.println(t);
					
						
				
				}
				
	}

}
