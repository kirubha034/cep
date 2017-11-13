import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GetDataFromExcel{

	    String[][] dataDets;
	    static FileInputStream fis;
        static Workbook wb;
        Sheet sh;
        //static String filePath="C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx";
        //-Dfile.path="C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx"
        static String filePath = System.getProperty("file.path");
        
        
	   /* public String[][] getData(){       	        
			try {
				fis = new FileInputStream("C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx");
				wb= WorkbookFactory.create(fis);
				sh= wb.getSheet("Sheet2");
				int i=sh.getLastRowNum();
				System.out.println("Number of Active Rows"+i);
				dataDets=new String[sh.getLastRowNum()][12];
				for(int j = 0;j<sh.getLastRowNum();j++){
					for(int k=0;k<sh.getRow(j).getLastCellNum();k++){
						dataDets[j][k] = sh.getRow(j).getCell(k).toString();
					}
					System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dataDets;
		}*/
	    
       /* public static void readExcel(){       	        
			try {
				fis = new FileInputStream("C:\\Users\\kirajama\\Desktop/TestingCEP.xlsx");
				wb= WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
        
        
        static{
        	try {
				fis = new FileInputStream(filePath);
				wb= WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        public static void main(String[] args) {
        	GetDataFromExcel gd=new GetDataFromExcel();
        	gd.getEventDate("EventDate");
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
        	System.out.println(gd.getPartnerAttendeeDetails("PartnerAttendeeDetails"));
		}
        
	    public String getEventDate(String sheetName){
	    	String dates="";
			 //readExcel();
	    	 sh=wb.getSheet(sheetName);
	    	 for(int i=0; i <= sh.getLastRowNum(); i++){
	    		 if(sh.getLastRowNum()==0||sh.getLastRowNum()==i){
	    			 dates=dates+sh.getRow(i).getCell(0).toString();	 
	    		 }else{
	    			 dates=dates+sh.getRow(i).getCell(0).toString()+",";
	    		 }
	    	 }	 
	    	 System.out.println(dates);
	    	return dates;
	    }
	    
	    public String getPartnerAttendeeDetails(String sheetName){
	    	String partnerAttendeeDetails="";
			 //readExcel();
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
			// readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
			 //readExcel();
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
