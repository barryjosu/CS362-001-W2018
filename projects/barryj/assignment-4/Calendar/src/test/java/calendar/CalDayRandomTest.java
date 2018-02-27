package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 try {
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed = System.currentTimeMillis();
				 Random random = new Random(randomseed);

				 int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 150);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 150);
				 int startDay = ValuesGenerator.RandInt(random);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);

				 int startHour1 = ValuesGenerator.getRandomIntBetween(random, 1, 22);
				 int startMinute1 = ValuesGenerator.getRandomIntBetween(random, 1, 58);
				 int startDay1 = ValuesGenerator.RandInt(random);
				 int startMonth1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);

				 int startHour2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
				 int startMinute2 = ValuesGenerator.getRandomIntBetween(random, -15, 150);
				 int startDay2 = ValuesGenerator.RandInt(random);
				 int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);


				 int startYear = ValuesGenerator.RandInt(random);
				 String title = "Birthday Party";
				 String description = "This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);
				 Appt appt1 = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);
				 Appt appt2 = new Appt(startHour2,
						 startMinute2,
						 startDay2,
						 startMonth2,
						 startYear,
						 title,
						 description);
				 Appt appt3 = new Appt(startHour1,
						 startMinute1,
						 startDay1,
						 startMonth1,
						 startYear,
						 title,
						 description);
				 int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);
				 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
				 CalDay cal = new CalDay(today);
				 cal.addAppt(appt);
				 cal.addAppt(appt1);
				 cal.addAppt(appt2);
				 cal.addAppt(appt3);
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			 }

		 }
		 catch(Exception e){

		 }
	 }


}