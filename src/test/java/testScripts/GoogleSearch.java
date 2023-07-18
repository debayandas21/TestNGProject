package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleSearch {

	WebDriver driver;
	
	@BeforeTest
	public void Setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test
	public void JavaTutorial_Search() {
		
		
		driver.get("https://google.com/");
		
		SoftAssert sfAssert= new SoftAssert();
		
		sfAssert.assertEquals(driver.getTitle(), "Gogle - search");
		
		WebElement SearchBox= driver.findElement(By.name("q"));
		SearchBox.sendKeys("Java Tutorial");
		SearchBox.submit();
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		
		
	}
	
	@Test
	public void SeleniumTutorial_Search() {

		driver.get("https://google.com/");
		WebElement SearchBox = driver.findElement(By.name("q"));
		SearchBox.sendKeys("Selenium Tutorial");
		SearchBox.submit();
		
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");

	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
