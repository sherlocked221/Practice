package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {
	String firstname="legend";
	String lastname="stark";
	String username="starklegend9";
	String password="sherlock@221";
	String Confpassword="sherlock@221";
	String title="Gmail";
	public static WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Stark\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
	}

	@Test
	public void DemoTest() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//div[text()='For myself']"));
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
		fillSignUpForm(firstname,lastname, username, password, Confpassword);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='countryList']")).click();
		driver.findElement(By.xpath("(//div[@data-value='us'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("phoneNumberId")).sendKeys("23452262");
		Thread.sleep(5000);

	}

	public static void fillSignUpForm(String fn,String ln,String un,String pwd,String cpwd)
	{
		driver.findElement(By.name("firstName")).sendKeys(fn);
		driver.findElement(By.name("lastName")).sendKeys(ln);
		driver.findElement(By.name("Username")).sendKeys(un);
		driver.findElement(By.name("Passwd")).sendKeys(pwd);
		driver.findElement(By.name("ConfirmPasswd")).sendKeys(cpwd);
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}
