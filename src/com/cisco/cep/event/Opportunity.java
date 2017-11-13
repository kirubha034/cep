package com.cisco.cep.event;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Opportunity extends CustomerObjectives{

	public Opportunity(WebDriver driver) {
		super(driver);
	}

	public void fillOpportunityTab(String count){
		//Double oppCount=Double.parseDouble(count);
		int countOfOpp=Integer.parseInt(count);
		for(int i=1;i<=countOfOpp;i++){
			Assert.assertTrue(driver.findElement(By.xpath("//div[div[span[div[text()='Opportunity ']]]]/div[2]/div[1]")).isDisplayed());
			driver.findElement(By.xpath("//div[div[span[div[text()='Opportunity ']]]]/div[2]/div["+i+"]//label[text()='Opportunity']/following-sibling::input")).sendKeys("Opportunity - "+i,Keys.TAB,"Size -"+i,Keys.TAB,"Timing -"+i);
			if(countOfOpp>i){
				System.out.println("Checking the Add button"+i);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[span[text()='Add']]"))));
				driver.findElement(By.xpath("//button/span[text()='Add']")).click();
			}	
		}
		clickNext();
	}
}
