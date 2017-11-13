package com.cisco.cep.generics;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class GetDataFromExcel{
	
	public GetDataFromExcel(String filePath) {
		this.filePath=filePath;
	}
	    String filePath;
	    String[][] dataDets;
	    FileInputStream fis;
        Workbook wb;
        Sheet sh;
        Object[][] data;
	    
        public void readExcel(){       	        
			try {
				fis = new FileInputStream(filePath);
				wb= WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
             
        public static void main(String[] args) {
        	GetDataFromExcel gd=new GetDataFromExcel("C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx");
        	System.out.println(gd.getEventDate("EventDate"));
        	//gd.getCiscoAttendeeList("CiscoAttendeeList");
        	//gd.getAccountTeamObjective("AccountTeamObjectives");
        	//gd.getCustomerObjective("CustomerPartnerObjectives");
        	//gd.getCompetitiveSituation("CompetitiveSituation");
        	//gd.getAgendaTimings("AgendaTimings");
        	//gd.getPreBriefDocs("PreBriefDocuments");
        	//gd.getAgendaDocument("AgendaDocuments");
        	//gd.getSupportingDocument("SupportingDocuments");
        	//gd.getHotButtonText("HotButtons");
        	//gd.getAdditionalCommentsText("AdditionalComments");
        	//System.out.println(gd.getPartnerAttendeeDetails("PartnerAttendeeDetails"));
		}
        
	    public String getEventDate(String sheetName){
	    	String dates="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			dates=dates+sh.getRow(i).getCell(0).toString();	 
	    		 }else{
	    			dates=dates+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	    	 
	    	return dates;
	    }
	    
	    public String getPartnerAttendeeDetails(String sheetName){
	    	String partnerAttendeeDetails="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 partnerAttendeeDetails=partnerAttendeeDetails+sh.getRow(i).getCell(0).toString();	 
	    		 }else{
	    			 partnerAttendeeDetails=partnerAttendeeDetails+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	    	 
	    	return partnerAttendeeDetails;
	    }
	    
	    public String getCiscoAttendeeList(String sheetName){
	    	String attendees="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 attendees=attendees+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 attendees=attendees+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	    
	    	return attendees;
	    }
	    
	    public String getAccountTeamObjective(String sheetName){
	    	String accountTeamObjectives="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 accountTeamObjectives=accountTeamObjectives+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 accountTeamObjectives=accountTeamObjectives+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  
	    	return accountTeamObjectives;
	    }
	    
	    public String getCustomerPartnerObjective(String sheetName){
	    	String cutomerObjectives="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 cutomerObjectives=cutomerObjectives+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 cutomerObjectives=cutomerObjectives+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  
	    	return cutomerObjectives;
	    }
	    
	    public String getCompetitiveSituation(String sheetName){
	    	String competitiveSituation="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 competitiveSituation=competitiveSituation+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 competitiveSituation=competitiveSituation+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  
			return competitiveSituation;
	    }
	    
	    public String getAgendaTimings(String sheetName){
	    	String agendaTimings="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 agendaTimings=agendaTimings+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 agendaTimings=agendaTimings+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  
	    	return agendaTimings;
	    }
	    
	    public String getPreBriefDocs(String sheetName){
	    	String preBriefDocs="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 preBriefDocs=preBriefDocs+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 preBriefDocs=preBriefDocs+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  
			 return preBriefDocs;	
	    }
	    
	    public String getAgendaDocument(String sheetName){
	    	String agendaDocument="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 agendaDocument=agendaDocument+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 agendaDocument=agendaDocument+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  		
	    	return agendaDocument;
	    }
	    
	    public String getSupportingDocument(String sheetName){
	    	String supportingDocument="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 supportingDocument=supportingDocument+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 supportingDocument=supportingDocument+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  			 
	    	return supportingDocument;
	    }
	    
	    public String getHotButtonText(String sheetName){
	    	String hotButtonText="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 hotButtonText=hotButtonText+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 hotButtonText=hotButtonText+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  			 
	    	 System.out.println(hotButtonText);
	    	return hotButtonText;
	    }
	    
	    public String getAdditionalCommentsText(String sheetName){
	    	String additionalCommentsText="";
			 readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 additionalCommentsText=additionalCommentsText+sh.getRow(i).getCell(0).toString();
	    		 }else{
	    			 additionalCommentsText=additionalCommentsText+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	  		
	    	return additionalCommentsText;
	    }
}
