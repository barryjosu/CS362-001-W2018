package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		  

		  
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 assertTrue(appt.getValid());
		 
		 
		  
		 CalDay test = new CalDay();
		 GregorianCalendar cal = new GregorianCalendar(2018, 01, 15);
		 CalDay calday = new CalDay(cal);
		 
		 assertTrue(calday.isValid());
		 calday.addAppt(appt);
		 
		 calday.iterator();
		 
		 calday.toString();

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
