package com.cisco.cep.event;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewEventWizard {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Random r=new Random();
	
	public NewEventWizard(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void constWait(int mills){
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    @FindBy(xpath="//button/b[text()='Next']")
	WebElement clickNextButton;
	 
	public void clickNext(){	
		clickNextButton.click();
		constWait(3000);
	}

	//@FindBy(xpath="//div[@ng-repeat='formTab in eventTabList'][11]/div[2]")
	//WebElement navigateByTab;
	
	public void navigateTabByclick(){
		driver.findElement(By.xpath("//div[@ng-repeat='formTab in eventTabList'][11]/div[2]")).click();
	}

	String eventName;
	public void getEventName(){
		String[] eventFullName=driver.findElement(By.xpath("//md-dialog/md-toolbar/div/h2")).getText().split("-");
		eventName=eventFullName[1].trim();
		System.out.println(eventName+ eventName.length());
	}
	
	@FindBy(xpath="//button[b[text()='Submit Request']]")
	WebElement submitRequestButton;
	
	public void clickOnSubmitRequest(){
    	submitRequestButton.click();
    }
	
}
