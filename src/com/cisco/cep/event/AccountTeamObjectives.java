package com.cisco.cep.event;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountTeamObjectives extends CiscoAttendees{

	public AccountTeamObjectives(WebDriver driver) {
		super(driver);
	}

	public void fillAccountTeamObjective(String accTeamObjectives){
		String[] accTeamObjective=accTeamObjectives.split(",");
		driver.findElement(By.xpath("//div[@ng-model='eventDetails.teamObjective']/trix-editor")).sendKeys(accTeamObjective[r.nextInt(accTeamObjective.length-1)]);
		clickNext();
	}
}
