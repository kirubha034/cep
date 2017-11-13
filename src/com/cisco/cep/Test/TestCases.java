package com.cisco.cep.Test;
import java.util.concurrent.TimeUnit;

import com.cisco.cep.generics.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cisco.cep.pages.DashBoard;
import com.cisco.cep.pages.LoginPage;
import com.cisco.cep.event.*;
import com.google.common.base.Verify;

public class TestCases extends BaseTest{
    
	String excelFilePath="C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx";
	GetDataFromExcel getDataFromExcel=new GetDataFromExcel(excelFilePath);
	AdditionalComments createEvent=new AdditionalComments(driver1);
	
	String eventDate      = getDataFromExcel.getEventDate("EventDate");
	String partnerDetails=getDataFromExcel.getPartnerAttendeeDetails("PartnerAttendeeDetails");
	String ciscoAttendee  =getDataFromExcel.getCiscoAttendeeList("CiscoAttendeeList");
	String accTeamObjective=getDataFromExcel.getAccountTeamObjective("AccountTeamObjectives");
	String customerPartnerObjectives=getDataFromExcel.getCustomerPartnerObjective("CustomerPartnerObjectives");
	//String oppCount=getDataFromExcel.getCompetitiveSituation("CompetitiveSituation");
	String compSituationText=getDataFromExcel.getAgendaDocument("CompetitiveSituation");
	String agendaData=getDataFromExcel.getAgendaTimings("AgendaTimings");
	String preBriefFilePath=getDataFromExcel.getPreBriefDocs("PreBriefDocuments");
	String agendaFilePath=getDataFromExcel.getAgendaDocument("AgendaDocuments");
	String supportingDocs=getDataFromExcel.getSupportingDocument("SupportingDocuments");
	String hotButtons=getDataFromExcel.getHotButtonText("HotButtons");
	String addComments=getDataFromExcel.getAdditionalCommentsText("AdditionalComments");
	String oppCount="3";
	
	
	/*@Test
	public void createEvent(){	
		LoginPage lp=new LoginPage(driver);
		lp.login("Submitter","fs1.gen");
		FillRequestTab fillRequestDetailsTab=new FillRequestTab(driver);
		fillRequestDetailsTab.fillRequestDetails(eventDate);
		//Assert.assertTrue(driver.findElement(By.id("form_id")).isDisplayed());
		//fillRequestDetails( eventDate, partnerDetails, ciscoAttendee, accTeamObjective, customerPartnerObjectives, oppCount, compSituationText, 
		                                                          // agendaData, preBriefFilePath, agendaFilePath, supportingDocs, hotButtons, addComments);		
		//createEvent.fillRequestDetails(eventDate);
		CustomerPartnerAttendeeTab customerPartnerAttendeeTab=new CustomerPartnerAttendeeTab(driver);
		customerPartnerAttendeeTab.fillPartnerCustomerTab(partnerDetails);
		createEvent.fillCiscoAttendeeTab(ciscoAttendee);
		createEvent.fillAccountTeamObjective(accTeamObjective);
		createEvent.fillCustomerObjective(customerPartnerObjectives);
		createEvent.fillOpportunityTab(oppCount);
		createEvent.fillCompetitiveSituation(compSituationText);
		createEvent.fillCustomerPartnerInfo();
		createEvent.agendatab(agendaData);
		createEvent.additionalComments(addComments);
		constWait(5000);
		lp.logout();	
	}*/
	
	/*@Test
	 public void assignTopicToPresenter(){
		    LoginPage lp=new LoginPage(driver);
	    	lp.login("Admin","june1.gen");
	    	driver.findElement(By.id("form_id")).sendKeys(Keys.ESCAPE);
	    	constWait(2000);
	    	DashBoard db=new DashBoard(driver);
	    	db.goToNewRequestsTab();
	    	String eventName="New Acc (CPCXCB827)";
	    	db.selectTheSubmiitedEventFromNewRequestorRequestsTab(eventName);
	    	db.claimTheEvent(eventName);
	    	db.assginPresenter(eventName);
	    	logout();
	}*/
	
	
	
	@Test
	public void test(){

	}	
}
