package com.cisco.cep.event;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CustomerPartnerAttendeeTab extends FillRequestTab{

	public CustomerPartnerAttendeeTab(WebDriver driver) {
		super(driver);
	}

	public void fillPartnerCustomerTab(String partnerDetails){
    	String[] partnerDetailsList=partnerDetails.split(",");
    	
    	int count=r.nextInt(partnerDetailsList.length);
    	for(int i=0;i<count;i++){
    		String[] partnerDetailsToAdd=partnerDetailsList[i].split("-");
    		//Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Customer")));
    		driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container[label[text()='Attendee Name']]/input")).sendKeys(partnerDetailsToAdd[0].trim());
    		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-input-container[label[text()='Title']]/input"))));
    		//constWait(2000);
    		//driver.findElement(By.xpath("//md-input-container[label[text()='Attendee Name']]/input"));
        	driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container[label[text()='Title']]/input")).sendKeys(partnerDetailsToAdd[1].trim());
        	driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div[@ng-model='customerAttendee.details']/trix-editor")).sendKeys(partnerDetailsToAdd[2].trim());
        	if((i!=1)&&(i+1)<count){
        		driver.findElement(By.xpath("//button[span[text()='Add Attendee']]")).click();
        	} 
    	}
    	clickNext(); 	
    }
}
