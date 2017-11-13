package com.cisco.cep.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cisco.cep.event.NewEventWizard;

public class DashBoard extends NewEventWizard{

	public DashBoard(WebDriver driver) {
		super(driver);
	}

	public void goToNewRequestsTab(){
    	constWait(3000);
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-content/div[1]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/span[1]"))));
    	driver.findElement(By.xpath("//md-pagination-wrapper/md-tab-item[1]/span[span]")).click();
    }
	 
	public void selectTheSubmiitedEventFromNewRequestorRequestsTab(String createdEventString){
	    	constWait(3000);
	    	//Actions act = new Actions(driver);
	    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div/div[2][div[1][contains(text(),'"+createdEventString+"')]]")).click();
	    	//act.moveToElement(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div/div[2]/div[1][contains(text(),'"+createdEventString+"')]"))).click().perform();
	}
}
