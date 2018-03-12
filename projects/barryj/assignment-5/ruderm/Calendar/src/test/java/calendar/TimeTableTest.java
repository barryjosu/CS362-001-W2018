package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		  
		LinkedList<Appt> listAppts = new LinkedList<Appt>();  
		
		/** the month the user is currently viewing **/
     	int thisMonth;
    	
    	/** the year the user is currently viewing **/
    	 int thisYear;
    	
    	/** todays date **/
    	int thisDay;
    	
		//get todays date
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		 int startHour=15;
		 int startMinute=30;
		 int startDay=thisDay+1;  	
		 int startMonth=thisMonth; 	
		 int startYear=thisYear; 	
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
         
         listAppts.add(appt);
          
      // create another appointment
         startHour=14;
		 startMinute=30;
		 startDay=thisDay;  	
		 startMonth=thisMonth; 	
		 startYear=thisYear; 	
		 title="Class";
		 description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
        
         listAppts.add(appt);
         // create another appointment
         startHour=13;
		 startMinute=30;
		 startDay=thisDay;		
		 startMonth=thisMonth;	
		 startYear=thisYear;	
		 title="Meeting Today";
		 description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         
         listAppts.add(appt);
         // create another appointment
         startHour=16;
		 startMinute=30;
		 startDay=thisDay+1;		
		 startMonth=thisMonth+1;	
		 startYear=thisYear;	
		 title="Visit";
		 description="Visiting my parents!";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         int[] recurDaysArr={2,3,4};
         appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt);
    
		//get a list of appointments for one day, which is today
		GregorianCalendar today = new GregorianCalendar(2015,1,1);
		GregorianCalendar tomorrow = new GregorianCalendar (2020, 11,1);
		
		TimeTable timeTable=new TimeTable();
        //Create a linked list of calendar days to return
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		
		LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(2));
		 
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();  
		
		/** the month the user is currently viewing **/
     	int thisMonth;
    	
    	/** the year the user is currently viewing **/
    	 int thisYear;
    	
    	/** todays date **/
    	int thisDay;
    	
		//get todays date
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		
		 int startHour=15;
		 int startMinute=30;
		 int startDay=thisDay+1;  	
		 int startMonth=thisMonth; 	
		 int startYear=thisYear; 	
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
         
         listAppts.add(appt);
          
      // create another appointment
         startHour=14;
		 startMinute=30;
		 startDay=thisDay;  	
		 startMonth=thisMonth; 	
		 startYear=thisYear; 	
		 title="Class";
		 description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
        
         listAppts.add(appt);
         // create another appointment
         startHour=13;
		 startMinute=30;
		 startDay=thisDay;		
		 startMonth=thisMonth;	
		 startYear=thisYear;	
		 title="Meeting Today";
		 description="Meeting with the students.";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         
         listAppts.add(appt);
         // create another appointment
         startHour=16;
		 startMinute=30;
		 startDay=thisDay+1;		
		 startMonth=thisMonth+1;	
		 startYear=thisYear;	
		 title="Visit";
		 description="Visiting my parents!";
		 //Construct a new Appointment object with the initial data	 
         appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         int[] recurDaysArr={2,3,4};
         appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt);
    
		//get a list of appointments for one day, which is today
		GregorianCalendar today = new GregorianCalendar(2015,1,1);
		GregorianCalendar tomorrow = new GregorianCalendar (2016, 11,1);
		
		TimeTable timeTable=new TimeTable();
        //Create a linked list of calendar days to return
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		
		LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(2));
		 
	 }

     @Test
	  public void test03()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=03;
		 int startYear=2018;
		 
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 
		 // add 30 appointments to linked list with years ranging from 2019 to 2049
		 for (int i = 1; i <= 30; i++) {
			 startYear++;
			 String title = "appointment " + Integer.toString(i) + " title";
			 String description = "appointment " + Integer.toString(i) + " description";
			 Appt appt = new Appt(startHour, startMinute, startDay, startMonth,
                     startYear, title, description);
			 listAppts.add(appt);
		 }
		 
		 
		 TimeTable table = new TimeTable();
		 GregorianCalendar firstDay = new GregorianCalendar(2018, 2, 15);
		 GregorianCalendar lastDay = new GregorianCalendar(2027, 4, 15);
		 
		 // get the first ten appointments from time table
		 LinkedList<CalDay> apptRange = table.getApptRange(listAppts, firstDay, lastDay);
		 
		 //assertEquals(10, apptRange.size());
		 
	 }
     
     @Test
	  public void test04()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=03;
		 int startYear=2018;
		 String title = "appointment 1 title";
		 String description = "appointment 1 description";
		 
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth,
                              startYear, title, description);
		 
		 Appt appt2 = new Appt(startHour+1, startMinute, startDay, startMonth,
                 startYear, title, description);
		 
		 Appt appt3 = new Appt(startHour+2, startMinute, startDay, startMonth,
                 startYear, title, description);
		 
		 Appt appt4 = new Appt(startHour+5, startMinute, startDay, startMonth,
                 startYear, title, description);
		 
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 
		 TimeTable table = new TimeTable();
		 
		 // can't remove appt from null list
		 assertNull(table.deleteAppt(null, appt));
		 // can't remove null appt from list
		 assertNull(table.deleteAppt(listAppts, null));
		 
		 // can't remove appt from empty list
		 assertNull(table.deleteAppt(listAppts, appt));
		 
		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 assertEquals(3, listAppts.size());
		 
		 // can't remove an appt that isn't there.
		 assertNull(table.deleteAppt(listAppts, appt4));
		 

		 LinkedList<Appt> newTable = table.deleteAppt(listAppts, appt2);
		 // can remove appt that is there.
		 assertEquals(2, newTable.size());
		 assertTrue(newTable.contains(appt)); 
		 assertTrue(newTable.contains(appt3));
		 assertFalse(newTable.contains(appt2));
		 
		 Appt invalid_appt = new Appt(-1, startMinute, startDay, startMonth,
                 startYear, title, description);
		 assertNull(table.deleteAppt(listAppts, invalid_appt));
	 }
     
}
