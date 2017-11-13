package com.cisco.cep.event;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerObjectives extends AccountTeamObjectives{
	
	public CustomerObjectives(WebDriver driver) {
		super(driver);
	}

	public void fillCustomerObjective(String customerPartnerObjectives){
		String[] custPartObjective=customerPartnerObjectives.split(",");
		driver.findElement(By.xpath("//div[@ng-model='eventDetails.customerObjective']/trix-editor")).sendKeys(custPartObjective[r.nextInt(custPartObjective.length-1)]);
		clickNext();
	}
	
}
