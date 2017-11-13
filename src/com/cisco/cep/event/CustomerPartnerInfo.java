package com.cisco.cep.event;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CustomerPartnerInfo extends CompetitiveSituation{

	public CustomerPartnerInfo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void fillCustomerPartnerInfo(){
		driver.findElement(By.xpath("//div[div[span[contains(text(),'Customer / Partner Info -')]]]/div[3]/div/md-input-container[label[text()='# of Employees']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"1234");
		driver.findElement(By.xpath("//div[div[span[contains(text(),'Customer / Partner Info -')]]]/div[3]/div/md-input-container[label[text()='Annual Revenue']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"$12B");
		driver.findElement(By.xpath("//div[div[span[contains(text(),'Customer / Partner Info -')]]]/div[3]/div/md-input-container[label[text()='Historical Collab Bookings']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"$34.05");
		clickNext();
	}
}
