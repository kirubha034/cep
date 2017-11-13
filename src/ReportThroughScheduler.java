

import java.io.File;
import java.text.SimpleDateFormat;


public class ReportThroughScheduler {
	static long timeStamp;
	static File fileName=new File("C:\\Users\\kirajama\\Desktop\\WS-L-Eclipse\\CEP\\test-output\\emailable-report.html");
	//public static void main(String[] args) {
	static public void sendFileIfExists(){
		 System.out.println(fileName.exists());
		 if(fileName.exists()){
			 SendFileEmail.sendEmailReport();
			 fileName.delete();
			 System.out.println("File deleted");
			 System.out.println(fileName.exists());
		 }
		 //timeStamp=fileName.lastModified();
		 //System.out.println(timeStamp);
		 //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 //System.out.println("After Format : " + sdf.format(timeStamp));
	} 
}

