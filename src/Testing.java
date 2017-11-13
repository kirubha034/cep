import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.seleniumhq.jetty9.util.ArrayUtil;


public class Testing {	
  
	public static void main(String[] args) {
		
	  // Pyramid Pgm
	  /*int row=10;
		int count=1;
		int spaceCount=row-1;
		for(int i=1;i<=row;i++){
			for(int s=0;s<=spaceCount;s++){
				System.out.print(' ');
			}
			 int k=0;
			 for(int j=1;j<=count;j++){
				 if(j<=i)
					 k=k+1;
				 else
					 k=k-1;
			     System.out.print(k);	 
			 }
			
			 count=count+2;
			 spaceCount=spaceCount-1;
			 System.out.println();
		 }*/
		//System.out.println("  kirubh  a  ".trim().length());
		
		/*ArrayList<Object> al=new ArrayList<Object>();
		al.add(1);
		al.add(2);
		al.add(6);
		al.add(2);
		al.add(6);
		al.add(7);
		al.add(5);
		
		//int[] a={1,2,3,4,5,6,7};
		
		for(int i=0;i<al.size();i++){
		  for(int j=i+1;j<al.size();j++){
			  if(al.get(i).equals(al.get(j))){
				  System.out.println(al.get(j));
				  al.remove(j);
				  j--;  
			  }
		  }	
		}
		System.out.println(al);*/
		//int i=0;
		//System.out.println(i+3%2);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the limit:");
		String limitFromKeyBoard=sc.next();
		int i=Integer.parseInt(limitFromKeyBoard);
		recursive(i,1);
	}
	
	public static void recursive(int limit, int start){
		if(start<=limit){
			System.out.println(start);
			start=start+1;
			recursive(limit,start);
		}
		
	/*Map<Integer, String> test= new HashMap<Integer,String>();
	test.put(1, "Kirubha");
	test.put(1, "kirubha");
	
		for(Map.Entry m: test.entrySet()){
			System.out.println(m.getKey()+" "+m.getValue());
		}
	*/	
	}
}
