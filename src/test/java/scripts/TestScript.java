package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import testBase_1.TestBase;

public class TestScript extends TestBase {
	
	WebDriver d;
	@Test
	public void test()
	{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		d=new FirefoxDriver();
		
		d.get("https://www.google.co.in/");
		
		d.quit();
	}

}
