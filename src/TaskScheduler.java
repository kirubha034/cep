

import java.util.Timer;
import java.util.TimerTask;

public class TaskScheduler extends TimerTask{
		
	    @Override
		public void run() {
			System.out.println("Run Me ~ from default pkg");
			ReportThroughScheduler.sendFileIfExists();
		}
	
		public static void main(String[] args) {
			
			TimerTask task = new TaskScheduler();

	    	Timer timer = new Timer();
	    	timer.schedule(task, 1000,2000);//schedule(TimerTask task,long delay, long period); message every 2 seconds, with a 1 second delay for the first time of execution.
	    	
		}
}
