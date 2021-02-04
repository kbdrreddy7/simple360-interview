package com.simply360.assignment;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Problem2 {

	public static void printMatchResults(List<String> regexList, List<String> strings){
		
		new RegexThreadScheduler().printMatchResults(regexList, strings);
		
	}

}


class RegexThreadScheduler{
	

	int completedRegexCount;

	public void printMatchResults(List<String> regexList, List<String> strings) {
		try {


			/*
		1. We are not using BlockingQueue as we are not changing the data

			 */


			if(regexList==null || regexList.size()==0)
				throw new IllegalArgumentException("Please give a valid regex list");

			if(strings==null || strings.size()==0)
				throw new IllegalArgumentException("Please give a valid strings list");


			ExecutorService pool = Executors.newFixedThreadPool(strings.size());   


			/*
		     We are considering that the job(matchFinderJob) will take more time,
			 so we are using 'completedRegexCount' to keep a track of jobs that get completed,
			 and we don't shutdown the pool until all the jobs are completed

			 -----
			 In the given strings case, we no need to track the count, we can shutdown directly

			 */
			this.completedRegexCount=0;



			for(String regex: regexList) 
				pool.submit(new matchFinderJob(regex,strings,this));


			synchronized (this) {
				while(this.completedRegexCount<regexList.size())
					this.wait();this.wait(1000);
			}


			pool.shutdown();




		} catch (InterruptedException e) {
			// we can handle exception properly...we can log to file
			e.printStackTrace();
		}


	}

	public void increamentRegexCount() {
		this.completedRegexCount++;

	}
	
}




class matchFinderJob implements Runnable{

	String regex;
	List<String> strings;
	RegexThreadScheduler regexThreadScheduler;



	public matchFinderJob(String regex, List<String> strings,RegexThreadScheduler regexThreadScheduler) {
		super();
		this.regex = regex;
		this.strings = strings;
		this.regexThreadScheduler=regexThreadScheduler;
	}



	@Override
	public void run() {

		List<String> matchResults= Problem1.getMatchResults(regex, strings);
		

		// while doing changes to increamentCount--> others threads shoudn't increment or check the count
		synchronized (regexThreadScheduler) {
			regexThreadScheduler.increamentRegexCount();
			regexThreadScheduler.notify();//regexThreadScheduler.notifyAll();
		}
		
		
		System.out.println( "Thread name: '"+ Thread.currentThread().getName()+"' ---> regex '"+ regex+"' --> matching with the list:"+matchResults);



	}

}