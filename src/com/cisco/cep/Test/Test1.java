package com.cisco.cep.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class Test1 {
	
	/*@Test(dataProvider="getData")
	public void method1(String userName, String pwd){
		System.out.println("Start Test");
		//Assert.assertEquals(userName,"testuser2");
		System.out.println(pwd);
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	
	
	@DataProvider
	public Object[][] getData()
	{	
		
	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0] ="sampleuser1";
	data[0][1] ="abcdef";

	// 2nd row
	data[1][0] ="testuser2";
	data[1][1] ="zxcvb";
	
	// 3rd row
	data[2][0] ="guestuser3";
	data[2][1] ="pass123";

	data[3][0] ="guestuser3";
	data[3][1] ="pass123";
	
	return data;
	}*/
	int data=50;
	
	void change(int data){  
		 data=data+100;//changes will be in the local variable only
		 System.out.println(data);
		 }  
	
	public static void add(int a){
			System.out.println(a);
			a--;
			//System.out.println(a--);
			if(a!=0){
				add(a);	
			}
	}
	
	public static void main(String[] args) {
		  /* Test1 t1=new Test1();
		   System.out.println("before change "+t1.data);  
		   t1.change(500);  
		   System.out.println("after change "+t1.data);  */
		//add(10);
		
	
	
	PriorityQueue pq=new PriorityQueue();
	   pq.add(1);
	   pq.add(2);
	   pq.add(2);
	   pq.add(3);
	   List it=new ArrayList();
	   ListIterator listIt=it.listIterator();
	   Iterator il= pq.iterator();
	   while(pq.peek()!=null){
		   System.out.println(pq.poll());
	   }
	}
}
