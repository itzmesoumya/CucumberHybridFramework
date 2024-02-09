package utils;

import java.time.LocalTime;

public class commonUtils {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
	
	public String getEmailWithTimeStamp() {
		
		LocalTime time = LocalTime.now();
		return "soumya"+time.toString().replace(" ","_").replace(":","_")+"@gmail.com";
	}

}
