package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

	 @Test
	  public void randomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 try {
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				 //LinkedList<Appt> listAppts = new LinkedList<Appt>();
				 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				 long randomseed = System.currentTimeMillis();
				 Random random = new Random(randomseed);

				 int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 150);
				 int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 150);
				 int startDay = ValuesGenerator.RandInt(random);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);

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
				 Appt appt3 = null;
				 /*int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);*/
				 Calendar rightnow = Calendar.getInstance();
				 int thisMonth = rightnow.get(Calendar.MONTH) + 1;
				 int thisYear = rightnow.get(Calendar.YEAR);
				 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
				 //LinkedList<CalDay> calDays = ValuesGenerator.generateRandomCalDayLinkedList(random, thisYear, thisMonth, thisDay);
				 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
				 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
				 tomorrow.add(Calendar.DAY_OF_MONTH, 1);
				 calDays.add(new CalDay(today));
				 int num=ValuesGenerator.getRandomIntBetween(random, 0, 1);
				 LinkedList<Appt> listAppts = ValuesGenerator.generateRandomApptLinkedList(random, num);
				 TimeTable timeTable=new TimeTable();
				 if(listAppts==null){
				 	timeTable.deleteAppt(listAppts, appt);
				 }
				 else {
					 listAppts.add(appt);
					 listAppts.add(appt1);
					 listAppts.add(appt2);
					 listAppts.add(appt3);
					 timeTable.deleteAppt(listAppts, appt);
					 timeTable.deleteAppt(listAppts, appt1);
					 timeTable.deleteAppt(listAppts, appt2);
					 timeTable.deleteAppt(listAppts, appt3);
				 }
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0) {
					 System.out.println("elapsed time 1: " + elapsed + " of " + TestTimeout);
				 }
			 }
		 }
		 catch(Exception e){

		 }

		 System.out.println("Done testing...");
	 }

	@Test
	public void randomtest2()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				//LinkedList<Appt> listAppts = new LinkedList<Appt>();
				LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.getRandomIntBetween(random, -10, 150);
				int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, 150);
				int startDay = ValuesGenerator.RandInt(random);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);

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
				 /*int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);*/
				Calendar rightnow = Calendar.getInstance();
				int thisMonth = rightnow.get(Calendar.MONTH) + 1;
				int thisYear = rightnow.get(Calendar.YEAR);
				int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
				//LinkedList<CalDay> calDays = ValuesGenerator.generateRandomCalDayLinkedList(random, thisYear, thisMonth, thisDay);
				GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
				GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
				tomorrow.add(Calendar.DAY_OF_MONTH, 1);
				calDays.add(new CalDay(today));
				int num=ValuesGenerator.getRandomIntBetween(random, 0, 1);
				LinkedList<Appt> listAppts = ValuesGenerator.generateRandomApptLinkedList(random, num);
				TimeTable timeTable=new TimeTable();
				if(listAppts==null){
					timeTable.deleteAppt(listAppts, appt);
				}
				else {
					listAppts.add(appt);
					timeTable.deleteAppt(listAppts, appt);
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0) {
					System.out.println("elapsed time 7: " + elapsed + " of " + TestTimeout);
				}
			}
		}
		catch(Exception e){

		}

		System.out.println("Done testing...");
	}

	@Test
	public void randomtest1()  throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println(elapsed);
		System.out.println("Start testing...");

		try {
			if (elapsed < TestTimeout) {
				System.out.println("timeout");
			}
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				//LinkedList<Appt> listAppts = new LinkedList<Appt>();
				LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				long randomseed = System.currentTimeMillis();
				System.out.println(" Seed:" + randomseed);
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

				int startYear = ValuesGenerator.getRandomIntBetween(random, 2010, 2020);
				int startYear1 = ValuesGenerator.getRandomIntBetween(random, 2020, 2030);
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
						startYear1,
						title,
						description);
				Appt appt4 = new Appt(startHour1,
						startMinute1,
						startDay1,
						startMonth1,
						startYear,
						title,
						description);
				Calendar rightnow = Calendar.getInstance();
				Appt appt5 = new Appt (14, 30, rightnow.get(Calendar.DAY_OF_MONTH)+1,
						rightnow.get(Calendar.MONTH) + 1, 2018, title, description);
				 /*int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int thisYear = ValuesGenerator.RandInt(random);
				 int thisDay = ValuesGenerator.RandInt(random);*/
				int thisMonth = rightnow.get(Calendar.MONTH) + 1;
				int thisYear = rightnow.get(Calendar.YEAR);
				int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
				//LinkedList<CalDay> calDays = ValuesGenerator.generateRandomCalDayLinkedList(random, thisYear, thisMonth, thisDay);
				GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
				GregorianCalendar tomorrow = (GregorianCalendar) today.clone();
				GregorianCalendar yesterday = (GregorianCalendar) today.clone();
				tomorrow.add(Calendar.DAY_OF_MONTH, 3);
				yesterday.add(Calendar.DAY_OF_MONTH, -3);
				calDays.add(new CalDay(today));
				int num = 1;
				LinkedList<Appt> listAppts = ValuesGenerator.generateRandomApptLinkedList(random, num);
				TimeTable timeTable = new TimeTable();
				int recurBy = ValuesGenerator.getRandomIntBetween(random, 1, 3);
				int recurIncrement = ValuesGenerator.getRandomIntBetween(random, 1, 100);
				int recurNumber = ValuesGenerator.getRandomIntBetween(random,-1, 30);
				int[] recurDays = ValuesGenerator.generateRandomArray(random, 7);
				appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
				appt3.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
				appt4.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
				appt5.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
					listAppts.add(appt);
					listAppts.add(appt1);
					listAppts.add(appt2);
					listAppts.add(appt3);
					listAppts.add(appt4);
					listAppts.add(appt5);
					timeTable.getApptRange(listAppts, today, tomorrow);
					try{
						timeTable.getApptRange(listAppts, today, yesterday);
					}
					catch(DateOutOfRangeException e){

					}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0) {
					System.out.println("elapsed time 5: " + elapsed + " of " + TestTimeout);
				}
			}
		} catch (Exception e) {

		}

		System.out.println("Done testing...");
	}

	
}