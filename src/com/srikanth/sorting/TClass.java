package com.srikanth.sorting;

public class TClass {

	private int count =0;
	public void increment(){
		synchronized(this){
			count++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  TClass tc = new TClass();
		
		  Thread t1 = new Thread(new Runnable() {
			    public void run()
			    {
			         for(int i=0;i<1000;i++){
			        	tc.increment();
			         }
			    }});  
		  Thread t2 = new Thread(new Runnable() {
			    public void run()
			    {
			         for(int i=0;i<1000;i++){
			        	tc.increment();
			         }
			    }});  
			    t1.start();
			    t2.start();
			    try {
					t1.join();
					 t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			    
			    System.out.println(tc.count);

	}
	
	
}

