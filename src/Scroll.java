import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hwpf.converter.AbstractWordUtils.NumberingState;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scroll {
	String name;
	String stDate;
	String endDate;
	String stTime;
	String endTime;
       
	File src=new File("C:\\Users\\kirajama\\Desktop/Credentials.xlsx");
	Workbook wb;
	Sheet sh;
	Scroll sc=new Scroll();
	static boolean c;
	
	
	 public static void main(String[] args) throws Exception{
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\kirajama\\Desktop\\WS-L-Eclipse\\CEP\\Browser/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kirubha034@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("9489044080",Keys.ENTER);*/
		 /*Random r=new Random();
		 for(int i=0;i<10;i++){
			 int ran=r.nextInt(2)+1;
			 System.out.println(ran);
		 }*/
		 
		/* Integer i=new Integer(222);
		 String s="aaA";
		 for(int j=1;j<s.length();j++){
			 System.out.println(s.charAt(0)==s.charAt(j));*/
		
		 //Random Number
		  //Random r= new Random();
		 //for(int i=0;i<2;i++){
			// System.out.println(r.nextInt(2));	 
		 //}
		 
	    /*System.out.println(7/2);
	    System.out.println(3%2);*/
		 
		 /*String s="12.0";
		 Double i=Double.parseDouble(s);
		 System.out.println(i.intValue());*/
	    
		     //String eventdate="08/08/2017";
        	 //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
     		 //monthNameandYear = new SimpleDateFormat("MMM yyyy");
      	
      		//Date date= dateFormat.parse(eventdate);
      		//System.out.println(date);
      			//monthAndYearSep=monthNameandYear.format(date).split(" ");
    			//System.out.println(monthNameandYear.format(date));
		 //int x=10;
		 ///System.out.println(x);
		// System.out.println(x++);
		 //System.out.println(x--);
		 //System.out.println(++x);
		 //System.out.println(x--);
		 //System.out.println(--x);
		 
		/* System.out.println(c);
		 System.out.println();*/
		 /*int x= 100;
		 int y= 80;
		 
		  y=x+y;
		  x=y-x;
		  y=y-x;
		 
         System.out.println("After swapping x - "+x);
         System.out.println("After swapping y - "+y);*/
         //int[] c={10,20,30,40,60,70,80,90,100};
         //reduceByOne(101,1000);
         //System.out.printf("Hello World");
         //System.out.println(addArrayByrec(c.length,c));
         
		/* int i=19;
		 int remainder;
		 int a;
		 String binary="";
		
		 while(i>=2){
			a=i/2;
			System.out.println(a);
			remainder=i%2;
			i=a;
			System.out.println(remainder);
			binary=remainder+binary;
			if(i<2){
				binary=i+binary;
			}
		 }
		 System.out.println(binary);*/
		 //System.out.println(new Integer(binary).intValue());
		 	 
		 
         //List ls=new ArrayList();
         //ls.add("kirubha");
         //ls.add("Arun");
         //System.out.println(ls.contains("Kirubha"));
         
	   /*1 1 1 1 1 1 1 1 
		 1 1 1 1 1 1 2 2 
		 1 1 1 1 1 3 3 3 
		 1 1 1 1 4 4 4 4 
		 1 1 1 5 5 5 5 5 
		 1 1 6 6 6 6 6 6 
		 1 7 7 7 7 7 7 7 
		 8 8 8 8 8 8 8 8 */
		 
		/* int rowCount=8;
		 for(int i=1;i<=rowCount;i++){
			 for(int j=1;j<=rowCount;j++){
				 if(j<=rowCount-i){
					 System.out.print(1+" ");	 
				 }else{
					 System.out.print(i+" ");	 
				 }
			 }
			 System.out.println();
			 }*/
		
		 
		 
		 
	//-------------------------------------
	 
		 String s1="aadcdcaacdmnxyyx";
		 String s2="";
		 int length=s1.length()-1;
		 
		 System.out.println(s1.length()); 
		 for(int i=0;i<length;i++){
			 System.out.println(s1.charAt(i)==s1.charAt(i+1));
			 if(s1.charAt(i)==s1.charAt(i+1)){
					 for(int k=i;k<=i+1;k++){
						 s1=s1.replace(s1.charAt(i),' ');
						 System.out.println(s1);
					 }
					 i=i-1;
					 
			 }
				 System.out.println(s1=s1.replace(" ",""));
				 length=s1.length()-1;
		 }
		 
	 }
		
	
		 
	 static int sum;
	 public static int addArrayByrec(int n,int[] b){
		if(n>0){
			sum=sum+b[n-1];
			//System.out.println(sum);
			addArrayByrec(n-1, b);
		}
		return sum;
	 }
	 
	 public static void reduceByOne(int start, int a){
		 if(start<=a){
			System.out.println(start);
			 reduceByOne(start+1,a);
		 }
	 }
	 
	 
}
		 /* System.out.println("Length -"+s.length());*/

	 
	/* public void readExcel(){
		 FileInputStream fis;
		 try {
			fis = new FileInputStream(src);
			wb=WorkbookFactory.create(fis);
			sh=wb.getSheet("Sheet1");
		 } catch (Exception e) {
			e.printStackTrace();
		 }
	 }
	 
	 public int getRowCount(){
		 int rowCount=sh.getLastRowNum()-1;
		 return rowCount;
		 }*/

