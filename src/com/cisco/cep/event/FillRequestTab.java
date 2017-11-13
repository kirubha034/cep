package com.cisco.cep.event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillRequestTab extends NewEventWizard{
	
	public FillRequestTab(WebDriver driver) {
		super(driver);
	}
	
		//Requestor Info
		String selectedRole;
		
		//WebElement roleDropDown=driver.findElement(By.xpath("//md-select[@name='requesterRole']"));
		@FindBy(xpath="//md-select[@name='requesterRole']")
		WebElement roleDropDown;
		
		public void selectRandomRole(){
			roleDropDown.click();
			//driver.findElement(By.xpath("//md-select[@name='requesterRole']")).click();
			
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
		 
		 
		String selectedEventType;
		String engagedWithCXC;
		
		
		public void selectEventType(){
			System.out.println("Select Event Type");
			List<WebElement> eventTypes=driver.findElements(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes']/md-radio-button/div[2]"));
			System.out.println(eventTypes.size());
			int result=r.nextInt(eventTypes.size())+1;
			selectedEventType=driver.findElement(By.xpath("//div[@class='ng-scope layout-row']["+result+"]/md-radio-button/div[2]")).getText();
			//selectedEventType=driver.findElement(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes'][3]/md-radio-button/div[2]")).getText();
			System.out.println(selectedEventType);
			//driver.findElement(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes'][3]/md-radio-button/div[1]/div[1]")).click();
			driver.findElement(By.xpath("//div[@ng-repeat='et in engTypeSrv.allEngTypes']["+result+"]/md-radio-button/div[1]")).click();

			if(selectedEventType.equals("Customer/Partner Customer Experience Center(CXC) Briefing")){
				List<WebElement> cxcEngagement=driver.findElements(By.xpath("//md-radio-group[@name='alreadyEngagedWithCXC']/md-radio-button/div/span"));
				int randamNum=1+r.nextInt(cxcEngagement.size()-1);
				engagedWithCXC=driver.findElement(By.xpath("//md-radio-group[@name='alreadyEngagedWithCXC']/md-radio-button["+randamNum+"]/div[2]/span")).getText();
				System.out.println(engagedWithCXC);
				driver.findElement(By.xpath("//md-radio-group[@name='alreadyEngagedWithCXC']/md-radio-button["+randamNum+"]/div[1]/div[1]")).click();
			}
		}
		 
		String selectedAttendeeType;
		public void selectAttendeeType(){
			List<WebElement> attendeeType=driver.findElements(By.xpath("//div[div[text()='Attendee Type']]/md-radio-group/md-radio-button/div[2]"));
			int result=r.nextInt(attendeeType.size())+1;
			selectedAttendeeType=driver.findElement(By.xpath("//div[div[text()='Attendee Type']]/md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
			driver.findElement(By.xpath("//div[div[text()='Attendee Type']]/md-radio-group/md-radio-button["+result+"]/div[1]")).click();
			System.out.println(selectedAttendeeType);
		}
		
		String selectExecutiveSponsor;
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
		
		String cxcTopicYesorNo;
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
			/*List<WebElement> list=driver.findElements(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span"));
			if(list.contains(driver.findElement(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span[text()='New Acc']")))){
				driver.findElement(By.xpath("//md-virtual-repeat-container/div/div/ul/li/md-autocomplete-parent-scope/div/span[text()='New Acc']")).click();
			}else{
				driver.findElement(By.xpath("//md-input-container[label[text()='Customer/Partner/Account Name']]/input")).sendKeys("New Acc",Keys.TAB);
			}
			System.out.println(list.size());*/
			/*for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getText());
			}*/
		}
		    
		    
		SimpleDateFormat monthNameandYear;
		Date date;
		String[] monthAndYearSep;
		String eventName;

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
				//System.out.println(eventdate);
				//eventStartTimings=eventDetails1[1].split(" ");
				//System.out.println(eventStartTimings[0]);
				//System.out.println(eventStartTimings[1]);
				//endTimings=eventDetails1[2].split(" ");
				//System.out.println(endTimings[0]);
				//System.out.println(endTimings[1]);    

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
			     //From 
				//driver.findElement(By.xpath("//div["+(j+2)+"]/div[2]/md-input-container[label[text()='From']]/md-select")).click();
				//	            
				//List<WebElement> fromTimings=driver.findElements(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[1]"));
				//for(int ft=0;ft<fromTimings.size();ft++){
				//if((fromTimings.get(ft).getText()).equals(eventStartTimings[0])){
				//	driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option["+(ft+1)+"]/div[1]")).click();
				//	break;	
				//}		
				//}
				//	            
				//driver.findElement(By.xpath("//div["+(j+2)+"]/div[3]/md-input-container/md-select")).click();
				//driver.findElement(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option/div[contains(text(),'"+eventStartTimings[1]+"')]")).click();
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

		String videoOptions;
		public void viaVideo(){
			List<WebElement> viaVideoOptions=driver.findElements(By.xpath("//div[div[text()='Could the presenter join via video? ']]/md-radio-group/md-radio-button/div[2]"));
			System.out.println(viaVideoOptions.size());
			int result=r.nextInt(viaVideoOptions.size())+1;
			videoOptions=driver.findElement(By.xpath("//div[div[text()='Could the presenter join via video? ']]/md-radio-group/md-radio-button["+result+"]/div[2]")).getText();
			driver.findElement(By.xpath("//div[div[text()='Could the presenter join via video? ']]/md-radio-group/md-radio-button["+result+"]/div[1]")).click();
			System.out.println("Video"+videoOptions); 	
		}

		String dateFlexible;
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
		    
		    
		    String metCollabExe;
			String[] collExeList;
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
		    
		    
		    String selectedLocation;
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
		
		    public void getEventName(){
		  	  String[] eventFullName=driver.findElement(By.xpath("//md-dialog/md-toolbar/div/h2")).getText().split("-");
		  	  eventName=eventFullName[1].trim();
		        System.out.println(eventName+ eventName.length());
		     }

		    public void fillRequestDetails(String eventDate){
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
		    }
		    
}
