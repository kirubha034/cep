package com.cisco.cep.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver1;
	
	public static void constWait(int mills){
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	@BeforeTest
	public void beforeTest(){
		
		//System.out.println("BT");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr/geckodriver.exe");
		//driver=new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr\\Chrome - 2.30/chromedriver.exe");
		driver1=new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
		driver1.get("http://cepdev.cisco.com/");
		
		WebDriver driver2=new ChromeDriver();
		driver2.get("http://google.com/");
		driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver2.manage().window().maximize();
		
		WebDriver driver3=new ChromeDriver();
		driver3.get("http://https://www.guru99.com/sessions-parallel-run-and-dependency-in-selenium.html/");
		driver3.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver3.manage().window().maximize();
		driver3.close();
		
		driver2.close();
		
		driver1.close();	
	}  
}
