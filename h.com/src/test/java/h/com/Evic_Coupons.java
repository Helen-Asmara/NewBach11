package h.com;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Evic_Coupons {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		  
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         JavascriptExecutor js= (JavascriptExecutor) driver;
         
		
		driver.get("https://www.harristeeter.com/");
		WebElement evic=driver.findElement(By.xpath("(//a[contains(@class, 'kds-Link')])[1]"));
		//js.executeScript("click",evic);
		js.executeScript("arguments[0].click();", evic);
		  
;	}

}
