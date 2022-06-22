package com.crm.comcast.genericutilities;

import java.util.Date;
import java.util.Random;

/**
 * it's Contains java specific libraries like getRandomnumber & getsystemDate
 * @author indir
 *
 */
public class JavaUtility {
	/**
	 * it is used to generate random numbers with in the Range
	 * @return
	 */
	public int getRandomNumber(){
		Random random = new Random();
		int rndnum = random.nextInt();
		return rndnum;
	}
	/**
	 * its used to get the system date and time in IST Format
	 * @return
	 */
	public String getSystemDateAndTimeInISTFormat() {
		Date date = new Date();
		return date.toString();
	}
	/**
	 * its used to get the current system date based on YYYY+DD+MM
	 * @return
	 */
	public String getSystemDateAndTimeInFormat(){
		Date date = new Date();
		String dateAndTime = date.toString();
	
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalformat = YYYY+" "+DD+" "+MM;
		return finalformat;
		
	}
}

