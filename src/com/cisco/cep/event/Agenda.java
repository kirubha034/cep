package com.cisco.cep.event;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Agenda extends CollaborationLandscape{

	public Agenda(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void agendatab(String agendaData){
    	String[] agendas=agendaData.split(",");
    	int randomTopicCount=r.nextInt(agendas.length)+1;
    	
    	driver.findElement(By.xpath("//div[span/label[text()='How many Collaboration presenter timeslots are on the agenda?']]/md-input-container/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),""+randomTopicCount);
    	List<WebElement> topicCountinTab=driver.findElements(By.xpath("//div[span[contains(text(),'Presentation')]]/md-card"));
    	Assert.assertTrue(randomTopicCount==topicCountinTab.size());
    	
    	for(int i=0;i<randomTopicCount;i++){
    	//for(int i=0;i<6;i++){
    		String[] detailsPerAgenda=agendas[i].split("-");
    		String[] startTimeSplit=detailsPerAgenda[0].split(" ");
        	String[] endtimeSplit=detailsPerAgenda[1].split(" ");
        	
    		//Date Selection
        	constWait(2000);
    		driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div/md-input-container[label[text()='Date']]/md-select")).click();
        	//WebElement date=driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div/md-input-container[label[text()='Date']]/md-select"));
        	//Actions act= new Actions(driver);
        	//act.moveToElement(date).click().perform();
    		//constWait(2000);
    		List<WebElement> dates=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div"));
    		System.out.println(dates.size());
    		    /*for(int j=0;j<dates.size();j++){
    		    	if(dates.get(j).getText().equals(detailsPerAgenda[0])){
    		    		System.out.println(dates.get(j).getText());
    		    		System.out.println(detailsPerAgenda[0]);
    		    		constWait(5000);
    		        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[7]/md-select-menu/md-content/md-option/div[text()='"+dates.get(j).getText()+"']"))));
    		    	//driver.findElement(By.xpath("//div[7]/md-select-menu/md-content/md-option/div[text()='"+dates.get(j).getText()+"']")).click();
    		    	driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[text()='"+dates.get(j).getText()+"']")).click();
    		    	break;
    		        }
    		    }*/
    		   int opt=r.nextInt(dates.size())+1;
    		   driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+opt+"]/div")).click();
    		    
    		    // From/Start time
    		   //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div/md-input-container[label[text()='From']]/md-select"))));
    		    driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div/md-input-container[label[text()='From']]/md-select")).click();
    		    //wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[8]/md-select-menu/md-content/md-option/div[1]"))));
    		    List<WebElement> fromTimeMatches=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div"));
    		    	for(int t=0;t<fromTimeMatches.size();t++){
    		    		if((fromTimeMatches.get(t).getText()).equals(startTimeSplit[0])){
        		    		driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(t+1)+"]/div")).click();
        		    		break;	
    		    	}			
    		    }
    		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div[3]/md-input-container[label[text()='AM/PM']]/md-select"))));
    			driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div[3]/md-input-container[label[text()='AM/PM']]/md-select")).sendKeys(Keys.ENTER);
    			System.out.println(startTimeSplit[1]);
    			driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+startTimeSplit[1]+"')]")).click();
    			//constWait(5000);
    			
    			// To/End time 
    			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div[4]/md-input-container[label[text()='To']]/md-select"))));
    			driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div[4]/md-input-container[label[text()='To']]/md-select")).click();
    			List<WebElement> toTimeMatches=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[1]"));
    			System.out.println(toTimeMatches.size());
 		    	for(int t=0;t<toTimeMatches.size();t++){
 		    		if((toTimeMatches.get(t).getText()).equals(endtimeSplit[0])){
     		    		driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(t+1)+"]/div[1]")).click();
     		    		//driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(t+1)+"]/div[1]")).sendKeys(Keys.TAB);
     		    		break;	
 		    	    }			
 		        }			
 		    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div[1]/div[2]/div[5]/md-input-container/md-select"))));
 		    	driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div[1]/div[2]/div[5]/md-input-container/md-select")).sendKeys(Keys.ENTER);
 		    	//constWait(2000);
    			driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+endtimeSplit[1]+"')]")).click();
    			
    			//Select topic
    			System.out.println(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[4]/div/md-input-container/md-select/md-select-value[span[text()='Available Presentations']]/span[2]")).isDisplayed());
    			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[4]/div/md-input-container/md-select/md-select-value[span[text()='Available Presentations']]/span[2]"))));
    			driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[4]/div/md-input-container/md-select[md-select-value[span[text()='Available Presentations']]]")).click();
    			//constWait(5000);
    			List<WebElement> listOfTopics=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[1]"));
    			System.out.println(listOfTopics.size());
    			int randomTopic=r.nextInt(listOfTopics.size())+1;
    			//String topicName=listOfTopics.get(randomTopic).getText();
    			//System.out.println(topicName.length());
    			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[text()='"+topicName+"']"))));
    			//driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[text()='"+topicName+"']")).click();
    			driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+randomTopic+"]/div[1]")).click();
    			constWait(3000);
    			// Presentation foucs area
    			if((randomTopicCount > 2) && (i+2 >2)){
    				driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[5]/md-input-container[label[text()='Presentation focus areas']]/div/textarea")).sendKeys("Presentation area text",Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);	
            	}else{
            		driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[5]/md-input-container[label[text()='Presentation focus areas']]/div/textarea")).sendKeys("Presentation area text");
            	}
    	}
    	clickNext();
    }
}
