package com.example.jbs;

import com.example.jbs.*;
/**
 * Hello world!
 *
 */

public class App 
{
	private static MainRunnable mainRunnable;
	private static Thread mainThread;
	
    public static void main( String[] args )
    {
    	System.out.println( "Please use start stop as background service." );
    	start();
    }
    
    public static void start() {
    	mainRunnable = new MainRunnable();
    	mainThread = new Thread(mainRunnable);
    	mainThread.start();
    }
    
    public static void stop() {    	
    	mainThread.interrupt();
    	mainThread = null;    	
    }
}
