package com.cisco.cep.event;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CiscoAttendees extends CustomerPartnerAttendeeTab{
	 
	
	public CiscoAttendees(WebDriver driver) {
		super(driver);
	}

	public void fillCiscoAttendeeTab(String ciscoAttendees){
	    	String[] cicoAttendeeToAdd=ciscoAttendees.split(",");
	    	int ciscoAttendeesCount=r.nextInt(cicoAttendeeToAdd.length)+1;
	    	System.out.println(ciscoAttendeesCount);
	    	List<WebElement> ciscoAttendeeList;
	    	for(int j=0;j<ciscoAttendeesCount;j++){
	    		String[] attendeeDetails=cicoAttendeeToAdd[j].split("-");
	    		System.out.println(attendeeDetails[0].trim());
	    		driver.findElement(By.xpath("//md-input-container[label[text()='Search CEC for Cisco attendee']]/input")).sendKeys(attendeeDetails[0].trim());
	    		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span"))));
	        	ciscoAttendeeList= driver.findElements(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span"));
	        	System.out.println(ciscoAttendeeList);
	        	for(int i=0;i<ciscoAttendeeList.size();i++){
	        	if(ciscoAttendeeList.get(i).getText().contains(attendeeDetails[1].trim())){
	        		driver.findElement(By.xpath("//li["+(i+1)+"]/md-autocomplete-parent-scope/div/span")).click();
	        		break;
	        	}
	         }	
	        	constWait(2000);
	    	}
	         int count=driver.findElements(By.xpath("//md-dialog-content/form/div/div/div/div/div/div/div/div[1]")).size();
	         System.out.println(count);
	         Assert.assertEquals(ciscoAttendeesCount, count);
	    	clickNext();
	    }
	
}
