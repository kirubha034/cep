package com.cisco.cep.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TaskScheduler extends TimerTask{
		
	    @Override
		public void run() {
			System.out.println("Run Me ~");
			DateTimeFounder.sendFileIfExists();
		}
	
		public static void main(String[] args) {
			TimerTask task = new TaskScheduler();

	    	Timer timer = new Timer();
	    	timer.schedule(task, 1000,1000);
		}
}
