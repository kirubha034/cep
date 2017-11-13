package com.cisco.cep.pages;
import com.cisco.cep.event.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends NewEventWizard{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	String pwd="Ccep2017";
	
	/*WebElement submitRequest=driver.findElement(By.xpath("//div[@id='tab-button']/div[1]"));
	WebElement viewRequest=driver.findElement(By.xpath("//div[@id='tab-button']/div[2]"));
	WebElement generalLogin=driver.findElement(By.xpath("//div[div[text()='(Admin/Presenter/Proxy)']]"));*/
	
	public void login(String role,String userName){
		//driver.findElement(By.xpath("//div[contains(text(),'Submit Request')]")).click();
		if(role.equals("Submitter")){
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='tab-button']/div[1]"))));
			//driver.findElement(By.xpath("//div[@id='tab-button']/div[1]")).click();
			driver.findElement(By.cssSelector(".md-raised.md-primary.md-button.md-ink-ripple.next-button")).click();
		}else {
			int i=r.nextInt(2);
			if(i==0){
				driver.findElement(By.xpath("//div[@id='tab-button']/div[2]")).click();		
			}else{
				driver.findElement(By.xpath("//div[div[text()='(Admin/Presenter/Proxy)']]")).click();
			}
		}

		//driver.findElement(By.xpath("//input[@id='input_0']")).sendKeys(userName,Keys.TAB,pwd,Keys.ENTER);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-input-container[label[text()='CEC Username']]/input[@name='userName']"))));
		driver.findElement(By.xpath("//md-input-container[label[text()='CEC Username']]/input[@name='userName']")).sendKeys(userName);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='input_1']"))));
		constWait(3000);
		driver.findElement(By.xpath("//md-input-container[label[text()='CEC Password']]/input")).sendKeys(pwd,Keys.ENTER);
		constWait(5000);
	}
	
	 public void logout(){
	    	driver.findElement(By.xpath("//md-menu/div[1]/span[2]")).click();
	    	constWait(1000);
	    	driver.findElement(By.xpath("//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button/span[contains(text(),'Logout')]")).click();
	    }
}
