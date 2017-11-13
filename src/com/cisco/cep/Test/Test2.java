package com.cisco.cep.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Test2 {
	static Random r=new Random();
	
	/*@Test
	public void method2(){
		List lt= new ArrayList();
		lt.add(true);
		lt.add(false);
		Assert.assertEquals(lt.get(r.nextInt(lt.size())), true);
		System.out.println("Method 2 in Test2");
	}*/
	
	/*@BeforeClass
	public void bf(){
		System.out.println("Beofre Class");
	}
	
	@AfterMethod
	public void afterMethod(){
		//SendFileEmail.sendEmailReport();
		System.out.println("After Method");
	}
	
	@BeforeMethod
	public void beforeMethos(){
		System.out.println("Before Methods");
	}*/
	
	/*public static void main(String[] args) {
		for(int i=0;i<=40;i++){
			System.out.println(r.nextInt(2)+1);		
		}
	}*/
	
	/*@AfterSuite
	public void sendReport() {
			SendFileEmail.sendEmailReport();
	}*/
	
	/*@Test(description="Descrption one for Method")
	public void method1(){
		System.out.println("Method 1 in Test3") ;
	}*/
	
/*	@Test(description="Descrption two for Method")
	public void method2(){
		Assert.assertEquals(1, 2);
		System.out.println("Method 2 in Test3") ;
	}	*/
	
	public WebDriver driver;
	@Test
	public void method3(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr\\Chrome - 2.30/chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    	//driver.manage().window().setSize(new Dimension(412,732));
    	driver.manage().window().maximize();
    	driver.get("https://stackoverflow.com/questions/11358316/selenium-webdriver-open-new-tab-instead-of-a-new-window");
    	for(int i=0;i<10;i++){
    		Robot robot;
				try {
					robot = new Robot();
					robot.keyPress(KeyEvent.VK_CONTROL);
	    		    robot.keyPress(KeyEvent.VK_T);
	    		    driver.get("https://stackoverflow.com/questions/11358316/selenium-webdriver-open-new-tab-instead-of-a-new-window");
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
    	}
    	
		System.out.println("Method 3 in Test3") ;
	}
	
}
