package org.chen2lei.core.test;

import java.nio.charset.Charset;



public class MainTest {

	public static void main(String[] args) {
		String myStr = "??????";
	    System.out.println(myStr); 
	    byte[] bs = myStr.getBytes();
	    for (byte b : bs){
	    	System.out.println(b);
	    	
	    }
	}

}
