package com.cisco.cep.event;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollaborationLandscape extends CustomerPartnerInfo{
	
	public CollaborationLandscape(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String[] collfieldList={"Voice","Video","Web Conferencing","IM/ Presence","Business Messaging","Contact Center"};
    String customerSegemntFocus;
    
	public void collaborationLandscape(){
		//List<WebElement> collfieldList= driver.findElements(By.xpath("//div[div[div[span[text()='Collaboration Landscape']]]]/div/div/div/label"));
		//System.out.println(collfieldList.size());

		//for(int i=0;i<collfieldList.length;i++){
		//System.out.println(collfieldList[i]);
		//driver.findElement(By.xpath("//div[span[text()='Collaboration Landscape']]/div/div/md-input-container[label[text()='"+collfieldList[i]+"']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),collfieldList[i]);
		driver.findElement(By.xpath("//div[span[text()='Collaboration Landscape']]/div/div/md-input-container[label[text()='Voice']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),collfieldList[0],Keys.TAB,
				Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,collfieldList[1],Keys.TAB,
				Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,collfieldList[2],Keys.TAB,
				Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,collfieldList[3],Keys.TAB,
				Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,collfieldList[4],Keys.TAB,
				Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,collfieldList[5]);
		//}

		if(selectedAttendeeType.equals("Partner")){
			List<WebElement> partnerfieldList=driver.findElements(By.xpath("//div[div[text()=' Annual Partner Revenue for Cisco products by category']]/div/md-input-container/label"));
			for(int i=0;i<partnerfieldList.size();i++){
				driver.findElement(By.xpath("//div[div[text()=' Annual Partner Revenue for Cisco products by category']]/div/md-input-container[label[text()='"+partnerfieldList.get(i).getText()+"']]/input")).sendKeys(selectedAttendeeType+"Optional"+partnerfieldList.get(i).getText());	
			}


			List<WebElement> options=driver.findElements(By.xpath("//div[div[text()='Which customer segment do you focus on?']]/md-radio-group/md-radio-button/div[2]"));
			int opt=r.nextInt(options.size())+1;
			customerSegemntFocus=driver.findElement(By.xpath("//div[div[text()='Which customer segment do you focus on?']]/md-radio-group/md-radio-button["+opt+"]/div[2]")).getText();
			driver.findElement(By.xpath("//div[div[text()='Which customer segment do you focus on?']]/md-radio-group/md-radio-button["+opt+"]/div[1]")).click();
			System.out.println(customerSegemntFocus);
		}
		clickNext();
	}
}
