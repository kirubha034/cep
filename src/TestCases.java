import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestCases{
	
	//WebDriver submitter;
	//WebDriver admin;
	//WebDriver presenter;
	
	WebDriver driver;
	//String excelFilePath="C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx";
	String pwd="Ccep2017";
	String selectedRole;
	String selectedEventType;
	String engagedWithCXC;
	String selectedAttendeeType;
	String selectExecutiveSponsor;
	String cxcTopicYesorNo;
	String videoOptions;
	String dateFlexible;
	String metCollabExe;
	String[] collExeList;
	String selectedLocation;
	//String AccTeamObjective="Account team Objectives";
	//String customerPartnerObjectives="String customerPartnerObjectives";
	String competitiveSituation;
	String customerSegemntFocus;
	String[] collfieldList={"Voice","Video","Web Conferencing","IM/ Presence","Business Messaging","Contact Center"};
	
	//String preBriefFilePath="C:\\Users\\kirajama\\Desktop\\Credentials.xlsx";
	//String agendaFilePath="C:\\Users\\kirajama\\Desktop\\Offer data.xlsx";
	//String supportingDocs="C:\\Users\\kirajama\\Desktop\\Offer data.xlsx,C:\\Users\\kirajama\\Documents\\6th unit june 2017 performance (1).pptx";
    String[] monthAndYearSep;
	String eventName;
    
	WebDriverWait wait;
	Random r=new Random();
    Robot robot;
    Date date;
    SimpleDateFormat monthNameandYear;
    
    GetDataFromExcel getDataFromExcel=new GetDataFromExcel();
         
    //String eventDate="12/23/2017-9:15 AM-5:15 PM,12/24/2017-9:15 AM-5:15 PM,12/25/2017-9:15 AM-5:15 PM,12/25/2017-9:15 AM-5:15 PM";
    
    //String agendaData="9:15 AM-10:45 AM,10:45 AM-11:45 AM,11:45 AM-1:30 PM,1:30 PM-2:45 PM,3:00 PM-4:00 PM,4:00 AM-5:00 PM";
    //String addComments="Addditional Comments";
    //String hotButtons="Hot buttons text using script.";
    //String addCommnets="Additional Comments from Excel";
	//  String ciscoAttendee="Kirubha";
   
    
   /* @DataProvider(name="testData")
    public Object[][] datafromExcel(){
    	   Object[][] data=getDataFromExcel.getData();
    	//Object[][] data=new String[2][2];
    	//data[0][0]="kirubha";
    	//data[0][1]="9489044080";
    	
    	//data[1][0]="kirubha";
    	//data[1][1]="9489044080";
    	
    	   return data;
    }*/
    
   /* @Test(dataProvider="testData")
    public void test1(String eventDate,String date){
    	System.out.println(eventDate);
    	System.out.println(date);
    }
    */
    
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
  
    //public void test(String eventDate,String ciscoAttendee, String accTeamObjective,String customerPartnerObjectives, 
	  //       String oppCount,String compSituationText,String agendaData,String preBriefFilePath,String agendaFilePath,String supportingDocs,String hotButtons,String addComments){

    //@BeforeClass
    public void beforeClass(){
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr\\Chrome - 2.30/chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    	driver.manage().window().setSize(new Dimension(412, 732));
    	//driver.manage().window().maximize();
    	driver.get("http://cepdev.cisco.com/");
    	//login("Submitter","fs1.gen");
    }

    @BeforeTest
    public void beforeTest(){
    	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr/geckodriver.exe");
    	//driver=new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\kirajama\\Desktop\\Selenium JAr\\Chrome - 2.30/chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	//driver.manage().window().setSize(new Dimension(412, 732));
    	driver.manage().window().maximize();
    	driver.get("http://cepdev.cisco.com/");
    	//login("Submitter","fs1.gen");
    }  

    Excel xl=new Excel();

    @DataProvider(name="empLogin")
    public Object[][] loginData() {
    	Object[][] arrayObject = xl.getExcelData("C:\\Users\\kirajama\\Desktop/Object.xlsx","Data");
    	return arrayObject;
    }

    @Test(dataProvider="empLogin")
    public void cretaeEvent(String eventDate, String partnerDetails,String ciscoAttendee, String accTeamObjective, String customerPartnerObjectives,String compSituationText, 
    		String agendaData, String preBriefFilePath,String agendaFilePath, String supportingDocs,String hotButtons,String addComments){ 
    	//@Test(invocationCount=10)
    	//public void createEvent(){	
    	try{
    		login("Submitter","fs1.gen");	
    		/*Assert.assertTrue(driver.findElement(By.id("form_id")).isDisplayed());
    		System.out.println(eventDate);
    		System.out.println(partnerDetails);
    		System.out.println(ciscoAttendee);
    		System.out.println(accTeamObjective);
    		System.out.println(customerPartnerObjectives);
    		System.out.println(oppCount);
    		System.out.println(compSituationText);
    		System.out.println(agendaData);
    		System.out.println(preBriefFilePath);
    		System.out.println(agendaFilePath);
    		System.out.println(supportingDocs);
    		System.out.println(hotButtons);
    		System.out.println(addComments);*/

    		fillRequestDetails(eventDate,partnerDetails,ciscoAttendee,accTeamObjective,customerPartnerObjectives,oppCount, compSituationText, 
    				agendaData, preBriefFilePath, agendaFilePath,supportingDocs,hotButtons,addComments);
    		checkInRequetTab(eventName);
    		constWait(3000);	
    		logout();
    	}catch(Exception e){
    		if(driver.findElement(By.xpath("//button[@ng-click='requestCloseOrDelete($event)']/md-icon")).isDisplayed()){
    			driver.findElement(By.xpath("//button[@ng-click='requestCloseOrDelete($event)']/md-icon")).click();	
    			constWait(2000);
    			driver.findElement(By.xpath("//md-dialog[@aria-label='Confirm your request']/md-dialog-actions/button/span[text()='Delete']")).click();
    			constWait(2000);
    		}
    		System.out.println("Exception Block");
    		logout();
    		e.printStackTrace();
    		throw e;
    	}
    	//finally{
    	/*if(driver.findElement(By.xpath("//button[@ng-click='requestCloseOrDelete($event)']/md-icon")).isDisplayed()){
    			driver.findElement(By.xpath("//button[@ng-click='requestCloseOrDelete($event)']/md-icon")).click();	
    			constWait(2000);
    			driver.findElement(By.xpath("//md-dialog[@aria-label='Confirm your request']/md-dialog-actions/button/span[text()='Delete']")).click();
    			logout();
    	  }*/
    	//}	
    }

    @AfterTest
    public void afterTest(){
    	driver.close();
    }

  /*  @AfterClass
    public void afterClass(){
    	SendFileEmail.sendEmailReport();
    }*/

    //@Test
    //@Test(dependsOnMethods="createEvent")
    public void assignTopicToPresenter(){
    	login("Admin","june1.gen");
    	//driver.findElement(By.id("form_id")).sendKeys(Keys.ESCAPE);
    	constWait(2000);
    	goToNewRequestsTab();
    	//String eventName="New Acc (CPCXCB827)";
    	selectTheSubmiitedEventFromNewRequestorRequestsTab(eventName);
    	claimTheEvent(eventName);
    	assginPresenter(eventName);
    	logout();
    }

    //@Test
    //@Test(dependsOnMethods="assignTopicToPresenter")
    public void acceptAsPresenter(){
    	login("Presenter","cutler");
    	//String eventName="New Acc (CPCXCB827)";
    	selectTheSubmiitedEventFromNewRequestorRequestsTab(eventName);
    	acceptOrReject(eventName);
    	logout();
    }

    //@Test(dependsOnMethods="acceptAsPresenter")
    public void ScheduleAndCompleteEvent(){
    	login("Admin","june1.gen");
    	//String eventName="RMIT University (CPCXCB28125) ";
    	//String eventName="SpaceX/PCM&CDW/Space Exploration (CPCXCB12107)";
    	selectTheSubmiitedEventFromMyRequests(eventName);
    	clickOnscheduleButton(eventName);
    	//AdminSummary(eventName);
    	//clickOnscheduleButton(eventName);
    	selectTheSubmiitedEventFromMyScheduled(eventName);
    	completeTheEvent(eventName);
    	checkInHistoryTab(eventName);
    	logout();
    }    

    public void clickOnNewRequest(){
    	constWait(2000);
    	driver.findElement(By.xpath("//button/span[text()='New Event']")).click();
    }

    public void login(String role,String userName){
    	//driver.findElement(By.xpath("//div[contains(text(),'Submit Request')]")).click();
    	if(role.equals("Submitter")){
    		driver.findElement(By.xpath("//div[@id='tab-button']/div[1]")).click();
    		//WebElement loginButton=driver.findElement(By.xpath("//div[@id='tab-button']/div[1]"));	
    		System.out.println(driver.manage().window().getSize());
    		//Point loc=loginButton.getLocation();
    		//long xAxis=loc.getX();
    		//long yAxis=loc.getY();
    		//driver.manage().window().setSize(new Dimension(412, 732));
    		//System.out.println(driver.manage().window().getSize());
    		//loginButton=driver.findElement(By.xpath("//div[@id='tab-button']/div[1]"));
    		//loc=loginButton.getLocation();
    		//long xAxisloc=loc.getX();
    		//long yAxisLoc=loc.getY();
    		//System.out.println("x-axis:"+xAxis+"After"+xAxisloc);
    		//System.out.println("Y-axis:"+yAxis+"After"+yAxisLoc);
    		//Assert.assertTrue(xAxis==xAxisloc, "X-axis position changed");
    		//Assert.assertEquals(yAxis, yAxisLoc);
    	}else {
    		int i=r.nextInt(2);
    		if(i==0){
    			driver.findElement(By.xpath("//div[@id='tab-button']/div[2]")).click();		
    		}else{
    			driver.findElement(By.xpath("//div[div[text()='(Admin/Presenter/Proxy)']]")).click();
    		}
    	}

    	//driver.findElement(By.xpath("//input[@id='input_0']")).sendKeys(userName,Keys.TAB,pwd,Keys.ENTER);
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-input-container[label[text()='CEC Username']]/input[@name='userName']"))));
    	driver.findElement(By.xpath("//md-input-container[label[text()='CEC Username']]/input[@name='userName']")).sendKeys(userName);
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='input_1']"))));
    	constWait(3000);
    	driver.findElement(By.xpath("//md-input-container[label[text()='CEC Password']]/input")).sendKeys(pwd,Keys.ENTER);
    	constWait(5000);
    }

    public void logout(){
    	driver.findElement(By.xpath("//md-menu/div[1]/span[2]")).click();
    	constWait(1000);
    	driver.findElement(By.xpath("//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button/span[contains(text(),'Logout')]")).click();
    }

    public static void constWait(int mills){
    	try {
    		Thread.sleep(mills);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }

    public void selectRandomRole(){
    	driver.findElement(By.xpath("//md-select[@name='requesterRole']")).click();
    	wait=new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//md-option[@ ng-repeat='reqRole in requesterRole']/div"))));
    	//List<WebElement> roles=driver.findElements(By.xpath("//md-option[@ ng-repeat='reqRole in requesterRole']/div"));
    	//System.out.println(roles.size());
    	int result=r.nextInt(2)+1;
    	System.out.println(result);
    	selectedRole=driver.findElement(By.xpath("//md-option[@ ng-repeat='reqRole in requesterRole']["+result+"]/div[1]")).getText();
    	System.out.println(selectedRole);
    	driver.findElement(By.xpath("//md-option[@ ng-repeat='reqRole in requesterRole']["+result+"]/div[1]")).click();
    	//driver.findElement(By.xpath("//md-option[@ ng-repeat='reqRole in requesterRole']/div[1][text()='Field sales']")).click();
    }

    public void selectEventType(){
    	System.out.println("Select Event Type");
    	//List<WebElement> eventTypes=driver.findElements(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes']/md-radio-button/div[2]"));
    	List<WebElement> eventTypes=driver.findElements(By.xpath("//div[@class='ng-scope layout-row']/md-radio-button/div[2]"));
    	System.out.println(eventTypes.size());
    	int result=r.nextInt(eventTypes.size())+1;
    	selectedEventType=driver.findElement(By.xpath("//div[@class='ng-scope layout-row']["+result+"]/md-radio-button/div[2]")).getText();
    	//selectedEventType=driver.findElement(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes'][3]/md-radio-button/div[2]")).getText();
    	System.out.println(selectedEventType);
    	//driver.findElement(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes'][3]/md-radio-button/div[1]/div[1]")).click();
    	driver.findElement(By.xpath("//div[@class='ng-scope layout-row']["+result+"]/md-radio-button/div[1]")).click();

    	if(selectedEventType.equals("Customer/Partner Customer Experience Center(CXC) Briefing")){
    		List<WebElement> cxcEngagement=driver.findElements(By.xpath("//md-radio-group[@name='alreadyEngagedWithCXC']/md-radio-button/div/span"));
    		int randamNum=1+r.nextInt(cxcEngagement.size()-1);
    		engagedWithCXC=driver.findElement(By.xpath("//md-radio-group[@name='alreadyEngagedWithCXC']/md-radio-button["+randamNum+"]/div[2]/span")).getText();
    		System.out.println(engagedWithCXC);
    		driver.findElement(By.xpath("//md-radio-group[@name='alreadyEngagedWithCXC']/md-radio-button["+randamNum+"]/div[1]/div[1]")).click();
    	}
    }

    public void selectAttendeeType(){
    	List<WebElement> attendeeType=driver.findElements(By.xpath("//div[div[text()='Attendee Type']]/md-radio-group/md-radio-button/div[2]"));
    	int result=r.nextInt(attendeeType.size())+1;
    	selectedAttendeeType=driver.findElement(By.xpath("//div[div[text()='Attendee Type']]/md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	driver.findElement(By.xpath("//div[div[text()='Attendee Type']]/md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	System.out.println(selectedAttendeeType);
    }

    public void selectExecutiveSponsor(){
    	/*List<WebElement> executiveOptions=driver.findElements(By.xpath("//div[div[text()='Does the customer have an Executive Sponsor?']]/md-radio-group/md-radio-button/div[2]"));
    	System.out.println(executiveOptions.size());
    	int result=r.nextInt(executiveOptions.size())+1;
    	selectExecutiveSponsor=driver.findElement(By.xpath("//div[div[text()='Does the customer have an Executive Sponsor?']]/md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	driver.findElement(By.xpath("//div[div[text()='Does the customer have an Executive Sponsor?']]/md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	System.out.println(selectExecutiveSponsor);
    	if(selectExecutiveSponsor.equals("Yes")){
    		driver.findElement(By.xpath("//md-input-container[label[text()='Search Executive Sponsor With CEC ID']]/input")).sendKeys("Kirubha Rajamani",Keys.TAB);
    	}*/
    	driver.findElement(By.xpath("//div[div[text()='Does the customer have an Executive Sponsor?']]/md-radio-group/md-radio-button[2]/div[1]")).click();
    }

    public void selectCxcTopic(){
    	List<WebElement> cxcTopics=driver.findElements(By.xpath("//div[div[text()='Is this a CXC dedicated to Collaboration topics only? ']]/md-radio-group/md-radio-button/div[2]"));
    	System.out.println(cxcTopics.size());
    	int result=r.nextInt(cxcTopics.size())+1;
    	cxcTopicYesorNo=driver.findElement(By.xpath("//div[div[text()='Is this a CXC dedicated to Collaboration topics only? ']]/md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	driver.findElement(By.xpath("//div[div[text()='Is this a CXC dedicated to Collaboration topics only? ']]/md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	System.out.println(cxcTopicYesorNo);
    }


    public void AccoutName(){
    	driver.findElement(By.xpath("//md-input-container[label[text()='Customer/Partner/Account Name']]/input")).sendKeys("New Acc");
    	//List<WebElement> list=driver.findElements(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span"));
    	/*if(list.contains(driver.findElement(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span[text()='New Acc']")))){
    		driver.findElement(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span[text()='New Acc']")).click();
    	}else{
    		driver.findElement(By.xpath("//md-input-container[label[text()='Customer/Partner/Account Name']]/input")).sendKeys("New Acc",Keys.TAB);
    	}*/
    	/*System.out.println(list.size());
    	for(int i=0;i<list.size();i++){
    		System.out.println(list.get(i).getText());
    	}*/
    }



    public void selectEventDate(String eventDetails){
    	String[] eventDetDays=eventDetails.split(",");
    	System.out.println("Event Days length"+eventDetDays.length);
    	String[] eventDetails1;
    	String eventdate;
    	String[] eventStartTimings;	
    	String[] endTimings;
    	int eventDateCount=r.nextInt(eventDetDays.length)+1;
    	System.out.println(eventDateCount);
    	for(int j=0;j<eventDateCount;j++){
    		System.out.println("Day"+ (j+1));  //12/25/2017-10:30 AM-5:15 PM
    		eventDetails1=eventDetDays[r.nextInt(eventDetDays.length)].split("-");
    		eventdate=eventDetails1[0];

    		if(j==0){
    			driver.findElement(By.xpath("//div/div[div[md-datepicker]]["+(j+1)+"]/div/md-datepicker/div/button/div")).click();
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			monthNameandYear = new SimpleDateFormat("MMM yyyy");
    			try {
    				date= dateFormat.parse(eventdate);
    				monthAndYearSep=monthNameandYear.format(date).split(" ");
    				System.out.println(monthNameandYear.format(date));
    			} catch (ParseException e) {
    				e.printStackTrace();
    			}
    			if(j==0){
    				constWait(2000);
    				driver.findElement(By.xpath("//td[@class='md-calendar-month-label']/span[text()='"+monthNameandYear.format(new Date())+"']")).click();
    				driver.findElement(By.xpath("//tbody[tr[td[text()='"+monthAndYearSep[1]+"']]]/tr/td/span[text()='"+monthAndYearSep[0]+"']")).click();	
    			}	
    			driver.findElement(By.xpath("//td[@data-timestamp='"+date.getTime()+"']/span")).click(); 
    		}
    		//            //From 
    		//            driver.findElement(By.xpath("//div["+(j+2)+"]/div[2]/md-input-container[label[text()='From']]/md-select")).click();
    		//            
    		//            List<WebElement> fromTimings=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[1]"));
    		//            for(int ft=0;ft<fromTimings.size();ft++){
    		//           	 if((fromTimings.get(ft).getText()).equals(eventStartTimings[0])){
    		//   		    		driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(ft+1)+"]/div[1]")).click();
    		//   		    		break;	
    		//   	    	 }		
    		//            }
    		//            
    		//            driver.findElement(By.xpath("//div["+(j+2)+"]/div[3]/md-input-container/md-select")).click();
    		//            driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+eventStartTimings[1]+"')]")).click();
    		//         
    		if(eventDetDays.length>1 && j<eventDetDays.length-1 ){
    			driver.findElement(By.xpath("//div/div[text()=' Add a day']")).click();
    		}

    		/*//To not working
            driver.findElement(By.xpath("//div["+(j+2)+"]/div[5]/md-input-container[label[text()='To']]/md-select")).click();
            constWait(5000);
            //wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[1]"))));
            List<WebElement> toTimings=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div"));
            //constWait(15000);
            for(int tt=0;tt<toTimings.size();tt++){
            	System.out.println("For Loop");
            	System.out.println(fromTimings.get(tt).getText());
           	 if((fromTimings.get(tt).getText()).equals(endTimings[0])){
             wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(tt+1)+"]/div[1]"))));
           	 driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(tt+1)+"]/div[1]")).sendKeys(Keys.ENTER);
                //driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(tt+1)+"]/div[1]")).click();
           	 System.out.println(toTimings.get(tt).getText().length());
           	 System.out.println(endTimings[0].length());
           	 constWait(2000);
            }
         }
            System.out.println(endTimings[0]);
            driver.findElement(By.xpath("//div["+(j+2)+"]/div[6]/md-input-container/md-select")).click();
            System.out.println(endTimings[1]);
            driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+endTimings[1]+"')]")).click();*/

    	}	

    	/* driver.findElement(By.xpath("//button[@aria-label='Open calendar']/div")).click();
         //for(int i=0;i<eventdetails.length;i++){
        	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     		 monthNameandYear = new SimpleDateFormat("MMM yyyy");
      		try {
      			date= dateFormat.parse(eventDays[0]);
      			System.out.println(date.getTime());
      			System.out.println(monthNameandYear.format(new Date()));
      			monthAndYearSep=monthNameandYear.format(date).split(" ");
    			System.out.println(monthNameandYear.format(date));
      		} catch (ParseException e) {
      			e.printStackTrace();
      		}	 
         //}

         driver.findElement(By.xpath("//td[@class='md-calendar-month-label']/span[text()='"+monthNameandYear.format(new Date())+"']")).click();
         driver.findElement(By.xpath("//tbody[tr[td[text()='"+monthAndYearSep[1]+"']]]/tr/td/span[text()='"+monthAndYearSep[0]+"']")).click();
         driver.findElement(By.xpath("//td[@data-timestamp='"+date.getTime()+"']/span")).click(); 
         driver.findElement(By.xpath("//md-input-container[label[text()='From']]/md-select")).click();

         List<WebElement> fromTimings=driver.findElements(By.xpath("//div[7]/md-select-menu/md-content/md-option/div[1]"));
         for(int ft=0;ft<fromTimings.size();ft++){
        	 if((fromTimings.get(ft).getText()).equals(startTimeSplit[0])){
		    		driver.findElement(By.xpath("//div[7]/md-select-menu/md-content/md-option["+(ft+1)+"]/div[1]")).click();
		    		break;	
	    	}		
         }
         driver.findElement(By.xpath("//div[3]/md-input-container/md-select/md-select-value[span[div]]/span[2]")).click();
         driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+startTimeSplit[1]+"')]")).click();


         driver.findElement(By.xpath("//md-input-container[label[text()='To']]/md-select")).click();
         List<WebElement> toTimings=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[1]"));
         for(int tt=0;tt<toTimings.size();tt++){
        	 if((fromTimings.get(tt).getText()).equals(endTimeSplit[0])){
             //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(tt+1)+"]/div[1]"))));
        	 driver.findElement(By.xpath("//body/div[7]/md-select-menu/md-content/md-option["+(tt+1)+"]/div[1]")).click();
             //driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(tt+1)+"]/div[1]")).click();
        	 System.out.println(toTimings.get(tt).getText());
        	 constWait(30000);
         }
      }
         System.out.println(endTimeSplit[0]);
         driver.findElement(By.xpath("//div[6]/md-input-container/md-select/md-select-value[span[div]]/span[2]")).click();
         System.out.println(endTimeSplit[1]);
         driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+endTimeSplit[1]+"')]")).click();
    	 */
    }

    public void viaVideo(){
    	List<WebElement> viaVideoOptions=driver.findElements(By.xpath("//div[div[text()='Could the presenter join via video? ']]/md-radio-group/md-radio-button/div[2]"));
    	System.out.println(viaVideoOptions.size());
    	int result=r.nextInt(viaVideoOptions.size())+1;
    	videoOptions=driver.findElement(By.xpath("//div[div[text()='Could the presenter join via video? ']]/md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	driver.findElement(By.xpath("//div[div[text()='Could the presenter join via video? ']]/md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	System.out.println("Video"+videoOptions); 	
    }

    public void dateFlexible(){
    	List<WebElement> dateflexibleOptions=driver.findElements(By.xpath("//div[div[text()='Is the date flexible? ']]/md-radio-group/md-radio-button/div[2]"));
    	System.out.println(dateflexibleOptions.size());
    	int result=r.nextInt(dateflexibleOptions.size())+1;
    	dateFlexible=driver.findElement(By.xpath("//div[div[text()='Is the date flexible? ']]//md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[div[text()='Is the date flexible? ']]//md-radio-group/md-radio-button["+result+"]/div[1]"))));
    	//driver.findElement(By.xpath("//div[div[text()='Is the date flexible? ']]//md-radio-group/md-radio-button["+result+"]/div[1]")).sendKeys(Keys.TAB,Keys.TAB);
    	driver.findElement(By.xpath("//div[div[text()='Is the date flexible? ']]//md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	System.out.println(dateFlexible); 
    }

    public void metCollborationExe(){
    	System.out.println("Collab");
    	//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]/md-radio-group/md-radio-button/div[2]"))));
    	List<WebElement> metCollabExeOptions=driver.findElements(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]/md-radio-group/md-radio-button/div[2]"));
    	System.out.println(metCollabExeOptions.size());
    	int result=r.nextInt(metCollabExeOptions.size())+1;
    	//metCollabExe=driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]//md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	metCollabExe=driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]//md-radio-group/md-radio-button[2]/div[2]")).getText();
    	//driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]//md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	//Actions act=new Actions(driver);
    	//act.moveToElement(driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]//md-radio-group/md-radio-button[2]/div[2]"))).click().build().perform();
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]//md-radio-group/md-radio-button[2]/div[2]"))));
    	//driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]/md-radio-group/md-radio-button[2]/div[1]/div[1]")).click();
    	driver.findElement(By.xpath("//div[div[text()='In the last six months, has the customer met with any Collaboration Executives?']]/md-radio-group/md-radio-button[2][div[2][span]]")).click();

    	System.out.println(metCollabExe); 
    	constWait(10000);
    	if(metCollabExe.equals("Yes")){
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-input-container[md-select[md-select-value[span[text()='Select Executives']]]]")));
    		WebElement executiveDropDown=driver.findElement(By.xpath("//md-input-container[md-select[md-select-value[span[text()='Select Executives']]]]"));
    		executiveDropDown.click();
    		constWait(2000);
    		List<WebElement> cxcList=driver.findElements(By.xpath("//md-option[@ng-value='cxcUser']/div[2]"));
    		System.out.println(metCollabExeOptions.size());
    		System.out.println(r.nextInt(cxcList.size()-1));
    		collExeList=new String[3];
    		for(int i=0;i<3;i++){
    			int size=r.nextInt(metCollabExeOptions.size())+1;
    			driver.findElement(By.xpath("//md-option[@ng-value='cxcUser']["+size+"]/div[2]")).click();
    			collExeList[i]=driver.findElement(By.xpath("//md-option[@ng-value='cxcUser']["+size+"]/div[2]")).getText();
    		}
    	}
    }

    public void eventLocation(){
    	//List<WebElement> eventLocOptions=driver.findElements(By.xpath("//div[div[text()='Event Location']]//md-radio-group/md-radio-button/div[2]"));
    	//System.out.println(eventLocOptions.size());
    	//int result=r.nextInt(eventLocOptions.size())+1;
    	//selectedLocation=driver.findElement(By.xpath("//div[div[text()='Event Location']]//md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
    	selectedLocation=driver.findElement(By.xpath("//div[div[text()='Event Location']]//md-radio-group/md-radio-button[2]/div[2]")).getText();
    	//driver.findElement(By.xpath("//div[div[text()='Event Location']]//md-radio-group/md-radio-button["+result+"]/div[1]")).click();
    	driver.findElement(By.xpath("//div[div[text()='Event Location']]//md-radio-group/md-radio-button[2]/div[1]/div[1]")).click();
    	System.out.println(selectedLocation);

    	if(selectedLocation.equals("Cisco location")){
    		driver.findElement(By.xpath("//md-select-value/span[text()='Select Location']")).click();
    		List<WebElement> locationsList=driver.findElements(By.xpath("//md-option[@ng-value='venue']/div"));
    		System.out.println(locationsList.size());
    		int opt=r.nextInt(locationsList.size())+1;
    		selectedLocation=driver.findElement(By.xpath("//md-option[@ng-value='venue']["+opt+"]/div")).getText();
    		driver.findElement(By.xpath("//md-option[@ng-value='venue']["+opt+"]/div")).click();
    		System.out.println(selectedLocation);
    	}

    	if(selectedLocation.equals("Customer location")){
    		driver.findElement(By.xpath("//md-input-container[label[text()='Location ']]/input")).sendKeys("Customer Location");
    	}
    }

    public void clickNext(){	
    	driver.findElement(By.xpath("//button/b[text()='Next']")).click();
    	constWait(7000);
    }

    public void navigateTabByclick(){
    	driver.findElement(By.xpath("//div[@ng-repeat='formTab in eventTabList'][11]/div[2]")).click();
    }

    public void getEventName(){
    	String[] eventFullName=driver.findElement(By.xpath("//md-dialog/md-toolbar/div/h2")).getText().split("-");
    	eventName=eventFullName[1].trim();
    	System.out.println(eventName+ eventName.length());
    }

    public void goToNewRequestsTab(){
    	constWait(3000);
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-content/div[1]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/span[1]"))));
    	driver.findElement(By.xpath("//md-pagination-wrapper/md-tab-item[1]/span[span]")).click();
    }

    public void selectTheSubmiitedEventFromNewRequestorRequestsTab(String createdEventString){
    	constWait(3000);
    	//Actions act = new Actions(driver);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div/div[2][div[1][contains(text(),'"+createdEventString+"')]]")).click();
    	//act.moveToElement(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div/div[2]/div[1][contains(text(),'"+createdEventString+"')]"))).click().perform();
    }

    public void selectTheSubmiitedEventFromMyRequests(String createdEventString){
    	constWait(3000);
    	//Actions act = new Actions(driver);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div/div/div[2][div[1][contains(text(),'"+createdEventString+"')]]")).click();
    	//act.moveToElement(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div/div[2]/div[1][contains(text(),'"+createdEventString+"')]"))).click().perform();
    }

    public void selectTheSubmiitedEventFromMyScheduled(String createdEventString){
    	constWait(2000);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[3]/div/div/div/md-card/div/div/div[2][div[1][contains(text(),'"+createdEventString+"')]]")).click();
    }

    public void completeTheEvent(String createdEventString){
    	constWait(3000);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[3]/div/div/div/md-card/div/div/div[2][div[1][contains(text(),'"+createdEventString+"')]]")).click();
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[3]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]/div[2]/div/button[span[text()='Complete']]")).click();

    }

    public void checkInHistoryTab(String createdEventString){
    	constWait(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[5]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]")).isDisplayed(), true);   
    }

    public void checkInRequetTab(String createdEventString){
    	constWait(2000);
    	Assert.assertEquals(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div[div[2][div[1][contains(text(),'"+createdEventString+"')]]]")).isDisplayed(), true);
    }

    public void claimTheEvent(String createdEventString){
    	constWait(2000);
    	//Actions act = new Actions(driver);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div[div[2][div[1][contains(text(),'"+createdEventString+"')]]]/div/div/button[span[text()='Claim']]")).click();
    	//act.moveToElement(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div/div[div[2][div[1][contains(text(),'"+createdEventString+"')]]]/div/div/button[span[text()='Claim']]"))).click().perform();
    	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//md-dialog-actions/button/span[text()='Claim']"))));
    	constWait(2000);
    	driver.findElement(By.xpath("//md-dialog-actions/button/span[text()='Claim']")).click();
    	//act.moveToElement(driver.findElement(By.xpath("//md-dialog-actions/button/span[text()='Claim']"))).click().perform();
    	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]"))));
    	constWait(2000);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]")).click();
    }

    List<WebElement> topicCards;
    public void assginPresenter(String createdEventString){
    	//Select the event
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div[div[div[2][div[1][contains(text(),'"+createdEventString+"')]]]]")).click();

    	constWait(2000);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]/div[2]/div/button[span[text()='Assign']]")).click();
    	topicCards=driver.findElements(By.xpath("//md-tabs-content-wrapper/md-tab-content/div/div/md-card"));
    	System.out.println(topicCards.size());
    	// WebElement selectPresenterInput;
    	//for(int i=topicCards.size()-1;i>=0;i--){
    	for(int i=0;i<topicCards.size();i++){  
    		System.out.println("Round "+i);
    		driver.findElement(By.xpath("//md-card["+(i+1)+"]/div/div/md-autocomplete[@md-floating-label='Select Presenter']/md-autocomplete-wrap/md-input-container/input")).sendKeys("Matt Cutler");
    		//driver.findElement(By.xpath("//md-autocomplete-parent-scope/span[text()='press1.gen -X (Generic User at Cisco) User']")).click();
    		driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions']/li/md-autocomplete-parent-scope/span")).click();
    		driver.findElement(By.xpath("//md-card["+(i+1)+"]/div/div/button[text()='Assign']")).click();
    		constWait(5000);
    	}
    }

    public void clickOnscheduleButton(String createdEventString){
    	constWait(2000);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]/div[2]/div/button[span[text()='Schedule']]")).click();

    	//Admin summary 
    	if(driver.findElement(By.xpath("//form[@name='adminSummary']")).isDisplayed()){
    		driver.findElement(By.xpath("//form[@name='adminSummary']/md-dialog-content/div/md-input-container[1]/input")).sendKeys("Spark space for"+createdEventString);
    		List<WebElement> optionsList1=driver.findElements(By.xpath("//md-dialog-content/div/div[2]/div[label[text()='Was an Executive presenter warranted for this event?']]/md-radio-group/md-radio-button/div[2]"));
    		int randomNumber1=r.nextInt(optionsList1.size())+1;
    		driver.findElement(By.xpath("//md-dialog-content/div/div[2]/div[label[text()='Was an Executive presenter warranted for this event?']]/md-radio-group/md-radio-button["+randomNumber1+"]/div[1]")).click();
    		String selectedOption1=driver.findElement(By.xpath("//md-dialog-content/div/div[2]/div[label[text()='Was an Executive presenter warranted for this event?']]/md-radio-group/md-radio-button["+randomNumber1+"]/div[2]/span")).getText();
    		if(selectedOption1.equalsIgnoreCase("No")){
    			driver.findElement(By.xpath("//form[@name='adminSummary']/md-dialog-content/div/md-input-container[2]/input")).sendKeys("Additional Information for "+ createdEventString);
    		}
    		List<WebElement> optionsList2=driver.findElements(By.xpath("//md-dialog-content/div/div[3][label[text()='Was an Executive scheduled for this event?']]/md-radio-group/md-radio-button/div[2]"));
    		int randomNumber2=r.nextInt(optionsList2.size())+1; 
    		driver.findElement(By.xpath("//md-dialog-content/div/div[3][label[text()='Was an Executive scheduled for this event?']]/md-radio-group/md-radio-button["+randomNumber2+"]/div[1]")).click();
    		String selectedOption2=driver.findElement(By.xpath("//md-dialog-content/div/div[3][label[text()='Was an Executive scheduled for this event?']]/md-radio-group/md-radio-button["+randomNumber2+"]/div[2]/span")).getText();

    		if(selectedOption2.equalsIgnoreCase("No")){
    			List<WebElement> optionsList3=driver.findElements(By.xpath("//md-dialog-content/div/div[4][label[text()=' Was another level of presenter scheduled?']]/md-radio-group/md-radio-button[1]/div[2]"));
    			int randomNumber3=r.nextInt(optionsList3.size())+1;
    			driver.findElement(By.xpath("//md-dialog-content/div/div[4][label[text()=' Was another level of presenter scheduled?']]/md-radio-group/md-radio-button["+randomNumber3+"]/div[1]")).click();
    			// String selectedOption3=driver.findElement(By.xpath("//md-dialog-content/div/div[4][label[text()=' Was another level of presenter scheduled?']]/md-radio-group/md-radio-button["+randomNumber3+"]/div[2]/span")).getText();
    		}
    		driver.findElement(By.xpath("//md-dialog-actions/button[b[text()='Save']]")).click();

    		constWait(2000);
    		//Again click on scheduled button
    		driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]/div[2]/div/button[span[text()='Schedule']]")).click();
    	}

    }

    /*public void AdminSummary(String createdEventString){
	   if(driver.findElement(By.xpath("//form[@name='adminSummary']")).isDisplayed()){
	  driver.findElement(By.xpath("//form[@name='adminSummary']/md-dialog-content/div/md-input-container[1]/input")).sendKeys("Spark space for"+createdEventString);
	  List<WebElement> optionsList1=driver.findElements(By.xpath("//md-dialog-content/div/div[2]/div[label[text()='Was an Executive presenter warranted for this event?']]/md-radio-group/md-radio-button/div[2]"));
	  int randomNumber1=r.nextInt(optionsList1.size())+1;
	  driver.findElement(By.xpath("//md-dialog-content/div/div[2]/div[label[text()='Was an Executive presenter warranted for this event?']]/md-radio-group/md-radio-button["+randomNumber1+"]/div[1]")).click();
	  String selectedOption1=driver.findElement(By.xpath("//md-dialog-content/div/div[2]/div[label[text()='Was an Executive presenter warranted for this event?']]/md-radio-group/md-radio-button["+randomNumber1+"]/div[2]/span")).getText();
	  if(selectedOption1.equalsIgnoreCase("No")){
		  driver.findElement(By.xpath("//form[@name='adminSummary']/md-dialog-content/div/md-input-container[2]/input")).sendKeys("Additional Information for "+ createdEventString);
	  }
	  List<WebElement> optionsList2=driver.findElements(By.xpath("//md-dialog-content/div/div[3][label[text()='Was an Executive scheduled for this event?']]/md-radio-group/md-radio-button/div[2]"));
	  int randomNumber2=r.nextInt(optionsList2.size())+1; 
	  driver.findElement(By.xpath("//md-dialog-content/div/div[3][label[text()='Was an Executive scheduled for this event?']]/md-radio-group/md-radio-button["+randomNumber2+"]/div[1]")).click();
	  String selectedOption2=driver.findElement(By.xpath("//md-dialog-content/div/div[3][label[text()='Was an Executive scheduled for this event?']]/md-radio-group/md-radio-button["+randomNumber2+"]/div[2]/span")).getText();

	  if(selectedOption2.equalsIgnoreCase("No")){
		  List<WebElement> optionsList3=driver.findElements(By.xpath("//md-dialog-content/div/div[4][label[text()=' Was another level of presenter scheduled?']]/md-radio-group/md-radio-button[1]/div[2]"));
		  int randomNumber3=r.nextInt(optionsList3.size())+1;
		  driver.findElement(By.xpath("//md-dialog-content/div/div[4][label[text()=' Was another level of presenter scheduled?']]/md-radio-group/md-radio-button["+randomNumber3+"]/div[1]")).click();
		 // String selectedOption3=driver.findElement(By.xpath("//md-dialog-content/div/div[4][label[text()=' Was another level of presenter scheduled?']]/md-radio-group/md-radio-button["+randomNumber3+"]/div[2]/span")).getText();
	  }
	  driver.findElement(By.xpath("//md-dialog-actions/button[b[text()='Save']]")).click();
	 }
   }*/

    String selectedOption;
    public void acceptOrReject(String createdEventString){
    	constWait(2000);
    	driver.findElement(By.xpath("//md-tabs-content-wrapper/md-tab-content[1]/div/div/div/md-card/div[div[div[2][div[contains(text(),'"+createdEventString+"')]]]]/div[2]/div/button[span[text()='Accept/Decline']]")).click();
    	topicCards=driver.findElements(By.xpath("//md-tabs-content-wrapper/md-tab-content/div/div/md-card"));
    	for(int i=0;i<topicCards.size();i++){
    		constWait(2000);
    		driver.findElement(By.xpath("//md-card["+(i+1)+"]/div/div/button[text()='Accept']")).click();
    		constWait(2000);
    		List<WebElement> vidoeOrInperson=driver.findElements(By.xpath("//md-radio-group/md-radio-button/div[2]"));
    		int optionNumber=r.nextInt(vidoeOrInperson.size())+1;
    		selectedOption=driver.findElement(By.xpath("//md-radio-group/md-radio-button["+optionNumber+"]/div[2]")).getText();
    		System.out.println(selectedOption);
    		System.out.println(optionNumber);
    		constWait(2000);
    		driver.findElement(By.xpath("//md-radio-group/md-radio-button["+optionNumber+"]/div[1]/div[1]")).click();
    		constWait(2000);
    		driver.findElement(By.xpath("//md-dialog-actions/button[span[contains(text(),'Accept')]]")).click();
    		constWait(2000);
    	}
    }

    public void fillRequestDetails(String eventDate,String partnerDetails, String ciscoAttendee, String accTeamObjective,String customerPartnerObjectives, String oppCount, 
    		String compSituationText, String agendaData,String preBriefFilePath,String agendaFilePath,String supportingDocs,String hotButtons,String addcomments){

    	selectRandomRole();
    	if(selectedRole.equals("Field sales")){
    		selectEventType();
    	}

    	selectAttendeeType();
    	selectExecutiveSponsor();
    	selectCxcTopic();
    	AccoutName();
    	selectEventDate(eventDate);
    	viaVideo();
    	dateFlexible();
    	metCollborationExe();
    	eventLocation(); 	 
    	clickNext();
    	getEventName();
    	//finalizeLater();
    	//navigateTabByclick();
    	// ------------------
    	fillPartnerCustomerTab(partnerDetails);
    	fillCiscoAttendeeTab(ciscoAttendee);
    	fillAccountTeamObjective(accTeamObjective);
    	fillCustomerObjective(customerPartnerObjectives);
    	fillOpportunityTab(oppCount);
    	fillCompetitiveSituation(compSituationText);
    	fillCustomerPartnerInfo();
    	collaborationLandscape();
    	agendatab(agendaData);
    	fillAdditionalCommentsSection(preBriefFilePath,agendaFilePath,supportingDocs,hotButtons,addcomments);
    }

    public void finalizeLater(){
    	driver.findElement(By.xpath("//button[b[text()='Finalize Later']]")).click();
    }

    public void fillPartnerCustomerTab(String partnerDetails){
    	System.out.println(partnerDetails);
    	String[] partnerDetailsList=partnerDetails.split(",");
    	int count=r.nextInt(partnerDetailsList.length);
    	System.out.println(count);
    	for(int i=0;i<=count;i++){
    		String[] partnerDetailsToAdd=partnerDetailsList[i].split("-");
    		System.out.println(partnerDetailsToAdd[0].trim());
    		System.out.println("Attendee tab");
    		constWait(3000);
    		Assert.assertTrue(driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container[label[text()='Attendee Name']]/input")).isDisplayed());
    		//driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container/label[text()='Attendee Name']")).click();
    		driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container[label[text()='Attendee Name']]/input")).sendKeys(partnerDetailsToAdd[0].trim());
    		Actions act=new Actions(driver);
    		act.moveToElement(driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container/label[text()='Attendee Name']"))).click();
    		act.sendKeys(partnerDetailsToAdd[0].trim());
    		act.build().perform();
    		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//md-input-container[label[text()='Title']]/input"))));
    		//constWait(2000);
    		//driver.findElement(By.xpath("//md-input-container[label[text()='Attendee Name']]/input"));
    		System.out.println(partnerDetailsToAdd[1]);
    		driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div/md-input-container[label[text()='Title']]/input")).sendKeys(partnerDetailsToAdd[1].trim());
    		System.out.println(partnerDetailsToAdd[2]);
    		driver.findElement(By.xpath("//div[@name='requestInfo']/div/md-card["+(i+1)+"]/div/div[@ng-model='customerAttendee.details']/trix-editor")).sendKeys(partnerDetailsToAdd[2].trim());
    		if((i+1)!=(count+1)){
    			driver.findElement(By.xpath("//button[span[text()='Add Attendee']]")).click();
    		} 
    	}
    	clickNext(); 	
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
    	//Assert.assertEquals(ciscoAttendeesCount, count);
    	clickNext();
    }

    public void fillAccountTeamObjective(String accTeamObjectives){
    	String[] accTeamObjective=accTeamObjectives.split(",");
    	driver.findElement(By.xpath("//div[@ng-model='eventDetails.teamObjective']/trix-editor")).sendKeys(accTeamObjective[r.nextInt(accTeamObjective.length-1)]);
    	clickNext();
    }

    public void fillCustomerObjective(String customerPartnerObjectives){
    	String[] custPartObjective=customerPartnerObjectives.split(",");
    	driver.findElement(By.xpath("//div[@ng-model='eventDetails.customerObjective']/trix-editor")).sendKeys(custPartObjective[r.nextInt(custPartObjective.length-1)]);
    	clickNext();
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

    public void fillCustomerPartnerInfo(){
    	driver.findElement(By.xpath("//div[div[span[contains(text(),'Customer / Partner Info -')]]]/div[3]/div/md-input-container[label[text()='# of Employees']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"1234");
    	driver.findElement(By.xpath("//div[div[span[contains(text(),'Customer / Partner Info -')]]]/div[3]/div/md-input-container[label[text()='Annual Revenue']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"$12B");
    	driver.findElement(By.xpath("//div[div[span[contains(text(),'Customer / Partner Info -')]]]/div[3]/div/md-input-container[label[text()='Historical Collab Bookings']]/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"$34.05");
    	clickNext();
    }

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
    		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div/md-input-container[label[text()='From']]/md-select"))));
    		driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div/md-input-container[label[text()='From']]/md-select")).click();
    		//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[8]/md-select-menu/md-content/md-option/div[1]"))));
    		List<WebElement> fromTimeMatches=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div"));
    		for(int t=0;t<fromTimeMatches.size();t++){
    			if((fromTimeMatches.get(t).getText()).equals(startTimeSplit[0])){
    				driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(t+1)+"]/div")).click();
    				break;	
    			}			
    		}
    		constWait(2000);	
    		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div[3]/md-input-container[label[text()='AM/PM']]/md-select"))));
    		driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div/div[2]/div[3]/md-input-container[label[text()='AM/PM']]/md-select")).sendKeys(Keys.ENTER);
    		System.out.println(startTimeSplit[1]);
    		driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+startTimeSplit[1]+"')]")).click();
    		constWait(2000);

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
    		constWait(2000);
    		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div[1]/div[2]/div[5]/md-input-container/md-select"))));
    		driver.findElement(By.xpath("//div[span[text()=' Presentation # "+(i+1)+"']]/md-card/div[1]/div[2]/div[5]/md-input-container/md-select")).sendKeys(Keys.ENTER);
    		constWait(2000);
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

    public void fillAdditionalCommentsSection(String preBriefFilePath, String agendaFilePath,String supportingDocs,String hotButtons,String addcomments){
    	//uploadPreBriefDoc(preBriefFilePath);
    	//uploadAgendaDoc(agendaFilePath);
    	//uploadSupportingDoc(supportingDocs);   
    	fillHotButtons(hotButtons);
    	additionalComments(addcomments);
    	clickOnSubmitRequest();
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

    public void clickOnSubmitRequest(){
    	driver.findElement(By.xpath("//button[b[text()='Submit Request']]")).click();
    }
}
