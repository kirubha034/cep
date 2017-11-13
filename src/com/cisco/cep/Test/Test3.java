package com.cisco.cep.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void bf(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr\\Chrome - 2.30/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.google.co.in/search?q=selenium&oq=selenium&aqs=chrome..69i57j69i60l3j69i65l2.1963j0j7&sourceid=chrome&ie=UTF-8");
	//driver.manage().window().maximize();
	//wait.until(ExpectedConditions);
	}
	
	@AfterTest
	public void afterMethod(){
		driver.close();
	}
	
	@Test
	public void t1(){
		driver.get("https://www.google.co.in/search?q=selenium&oq=selenium&aqs=chrome..69i57j69i60l3j69i65l2.1963j0j7&sourceid=chrome&ie=UTF-8");
	}
	
	@Test
	public void t2(){
		driver.get("https://www.go4worldbusiness.com/buyers/clothing-accessories.html");
	}
  
}
