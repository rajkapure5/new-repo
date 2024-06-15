package seleniumrelated1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver", "E:\\\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		List<WebElement> web= driver.findElements(By.tagName("img"));
		System.out.println(web.size());
		for(WebElement ele:web) {
			
			
						
			String s=ele.getAttribute("src");
			 System.out.println(s);
			 if(s.isEmpty()) {
				 System.out.println("url is empaty");
				 continue;
			 }
			try {
				HttpURLConnection huc=(HttpURLConnection)(new URL(s).openConnection());
			    huc.connect();
				if(huc.getResponseCode()!=200) {
						System.out.println("broken image:"+s);
						
				}
						else {
							System.out.println("fine image:"+s);
							
						}
						
			} catch (Exception e) {
				
			
			}

		}
	}

}
