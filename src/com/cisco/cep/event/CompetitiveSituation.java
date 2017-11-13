package com.cisco.cep.event;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompetitiveSituation extends Opportunity{

	public CompetitiveSituation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String competitiveSituation;

	public void fillCompetitiveSituation(String compSitutationText){
		List<WebElement> options=driver.findElements(By.xpath("//div[div[span[text()='Competitive Situation']]]/div/md-radio-group/md-radio-button/div[2]"));
		System.out.println(options.size());
		int opt=r.nextInt(options.size())+1;
		competitiveSituation=driver.findElement(By.xpath("//div[div[span[text()='Competitive Situation']]]/div/md-radio-group/md-radio-button["+opt+"]/div[2]")).getText();
		driver.findElement(By.xpath("//div[div[span[text()='Competitive Situation']]]/div/md-radio-group/md-radio-button["+opt+"]/div[1]")).click();
		System.out.println(competitiveSituation);

		if(competitiveSituation.equals("Yes")){
			driver.findElement(By.xpath("//div[@ng-model='eventDetails.competitive.list']/trix-editor")).sendKeys(compSitutationText);
		}
		clickNext();
	}
}
