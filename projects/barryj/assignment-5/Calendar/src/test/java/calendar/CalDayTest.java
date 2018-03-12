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
         assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription()); 
		 
		 
		  
		 CalDay test = new CalDay();
		 GregorianCalendar cal = new GregorianCalendar(2018, 01, 15);
         
		 CalDay calday = new CalDay(cal);		 
		 assertTrue(calday.isValid());
         
		 calday.addAppt(appt);
		 
		 assertEquals(calday.toString(), "	 --- 1/15/2018 --- \n --- -------- Appointments ------------ --- \n	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n \n");

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
