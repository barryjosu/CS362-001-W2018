package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=23;
		 int startMinute=29;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(23, appt.getStartHour());
		 assertEquals(29, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription()); 
	 }
//add more unit tests as you needed

	 @Test
	  public void test03()  throws Throwable  {
		 int startHour=21;
		 int startMinute=50;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(50, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 
	 @Test
	  public void test04()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 
	 @Test
	  public void test05()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=29;
		 int startMonth=02;
		 int startYear=400;
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
	// assertions
		 assertTrue(appt.getValid());   
         assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(29, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(400, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }
	
		 @Test
	  public void test06()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=02;
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
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());  
				 
		 appt.setStartHour(15);
		 appt.setStartMinute(20);
		 appt.setStartDay(10);
		 appt.setStartMonth(01);
		 appt.setStartYear(2016);
		 appt.setTitle(null);
		 appt.setTitle("Mom's Birthday Party");
		 appt.setDescription(null);
		 appt.setDescription("This is my Mom's birthday party!");
		 
		 int test[]=new int [2];
		 test[0] = 10;
		 test[1] = 11;
		 appt.setRecurrence(null, 10, 10, 10);
		 appt.setRecurrence(test, 10, 10, 10);
		 
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(15, appt.getStartHour());
		 assertEquals(20, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2016, appt.getStartYear());
		 assertEquals("Mom's Birthday Party", appt.getTitle());
		 assertEquals("This is my Mom's birthday party!", appt.getDescription());  
		 assertEquals(appt.getRecurNumber(), 10);
		 assertEquals(appt.getRecurBy(), 10);
		 assertEquals(appt.getRecurDays(), test);
		 assertEquals(appt.getRecurIncrement(), 10);
		 assertEquals(appt.isRecurring(), true);
	 }
	 
	 @Test
	  public void test07()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 
		 int startHour2=21;
		 int startMinute2=30;
		 int startDay2=15;
		 int startMonth2=01;
		 int startYear2=2018;
		 String title2="Birthday Party";
		 String description2="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt2 = new Appt(startHour2,
		          startMinute2 ,
		          startDay2 ,
		          startMonth2 ,
		          startYear2 ,
		          title2,
		         description2);
	// assertions
		 assertTrue(appt2.getValid());
		 assertEquals(21, appt2.getStartHour());
		 assertEquals(30, appt2.getStartMinute());
		 assertEquals(15, appt2.getStartDay());
		 assertEquals(01, appt2.getStartMonth());
		 assertEquals(2018, appt2.getStartYear());
		 assertEquals("Birthday Party", appt2.getTitle());
		 assertEquals("This is my birthday party.", appt2.getDescription());

		 assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
		 
		 assertEquals(0, appt.compareTo(appt2));
	 }
     
     
}
