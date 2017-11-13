package com.cisco.cep.event;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdditionalComments extends Agenda{
	
	
	public AdditionalComments(WebDriver driver) {
		super(driver);
	}

	Robot robot;
	
	 public void fillAdditionalCommentsSection(String preBriefFilePath, String agendaFilePath,String supportingDocs,String hotButtons,String addcomments){
         uploadPreBriefDoc(preBriefFilePath);
         uploadAgendaDoc(agendaFilePath);
    	 uploadSupportingDoc(supportingDocs);   
    	 fillHotButtons(hotButtons);
    	 additionalComments(addcomments);
    	 clickOnSubmitRequest();
    }
     
	 
	 public void fileUpload(String filePath){
	    	try {
				robot =new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
	    	
	    	StringSelection stringSlection=new StringSelection(filePath);
	    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSlection, null);
	    	
	    	//robot.setAutoDelay(1000);
	    	
	    	//Copy and Paste
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_V);
	    	
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_V);
	    	
	    	//Enter
	    	robot.keyPress(KeyEvent.VK_ENTER);
	    	robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	 
    public void uploadPreBriefDoc(String preBriefFilePath){
    	String[] preBriefToUpload=preBriefFilePath.split(",");
    	driver.findElement(By.xpath("//div[div[text()='Pre Briefing']]/div/label")).click();
    	constWait(2000);
    	fileUpload(preBriefToUpload[r.nextInt(preBriefToUpload.length)]);
    	constWait(2000);
    	driver.findElement(By.xpath("//div[div[text()='Pre Briefing']]/div[label]/button")).click();
    }	
    
    public void uploadAgendaDoc(String agendaFilePath){
    	String[] agendaFilePathToUpload=agendaFilePath.split(",");
    	driver.findElement(By.xpath("//div[div[text()='Agenda']]/div/label")).click();
    	constWait(2000);
    	fileUpload(agendaFilePathToUpload[r.nextInt(agendaFilePathToUpload.length)]);
    	constWait(2000);
    	driver.findElement(By.xpath("//div[div[text()='Agenda']]/div[label]/button")).click();
    }
    
    public void uploadSupportingDoc(String supportingDocFilePath){
    	String[] supportingDocs=supportingDocFilePath.split(",");
    	int random=r.nextInt(supportingDocs.length)+1;
    	for(int i=0;i<random;i++){
    		driver.findElement(By.xpath("//div[div[text()='Supporting Documents (Optional)']]/div/label")).click();
    		constWait(2000);
    		fileUpload(supportingDocs[i]);	
    		constWait(2000);
    		driver.findElement(By.xpath("//div[div[text()='Supporting Documents (Optional)']]/div[label]/button")).click();
    	}
    }
    
    public void fillHotButtons(String hotButtons){
    	String[] hotButtonsData=hotButtons.split(",");
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/div[div[text()='Hot buttons we should know about?']]/div/trix-editor"))));
    	WebElement hotButtonText=driver.findElement(By.xpath("//div/div[div[text()='Hot buttons we should know about?']]/div/trix-editor"));
    	
    	if(hotButtonText.getText().isEmpty()){
    		hotButtonText.sendKeys(hotButtonsData[r.nextInt(hotButtonsData.length)]);
    	}else{
    		hotButtonText.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,hotButtonsData[r.nextInt(hotButtonsData.length)]);
    	}
    }
    
    public void additionalComments(String addComments){
    	String[] additionalCommnets=addComments.split(",");
    	
    	WebElement additionalCommentsText=driver.findElement(By.xpath("//div/div[div[text()='Additional Comments (Optional)']]/div/trix-editor"));
    	/*if(additionalCommentsText.getText().isEmpty()){
    		additionalCommentsText.sendKeys(additionalCommnets[r.nextInt(additionalCommnets.length)]);
    	}else{*/
    		additionalCommentsText.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,additionalCommnets[r.nextInt(additionalCommnets.length)]);
    	/*}*/
    }
    
}
