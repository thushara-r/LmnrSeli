package basepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass_sauce {
	
public static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
		driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com");
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	@AfterTest
	 
	 public void postCondition()
	 {
		 // code is to close the browser
		driver.quit();;
	}

}


