package org.cuc.pom.stepdefinition;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.cuc.pom.baseclass.BaseClass;
import org.cuc.pom.pages.CalendarPage;
import org.cuc.pom.pages.HomePage;
import org.cuc.pom.pages.LoginPage;
import org.cuc.pom.pages.TasksPage;
import org.cuc.pom.utility.LogTest;
import org.cuc.pom.utility.TestUtil;
import org.sikuli.script.FindFailed;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomepageStepDef extends BaseClass{ //extending baseclass will automatically execute baseclass constructor

	LoginPage login;
	HomePage home;
	TestUtil test;
	TasksPage task;
	CalendarPage calendar;

	@Before("@SystemTesting")
	public void initAll()
	{
		System.out.println("Before");
	}
	
	
	@After("@SystemTesting")
	public void quitAll()
	{
		System.out.println("After");
	}
	
@Given("^user navigates to FreeCRM webpage$")
public void user_navigates_to_FreeCRM_webpage(){
	LogTest.info("Initiating the Class");
	init();
	

}

@Then("^user logs into the application$")
public void user_logs_into_the_application()  {
	LogTest.startTest("Log into Application");
	login = new LoginPage();
	home=login.login(prop.getProperty("username"),prop.getProperty("password"));
	LogTest.endTest("Log into Application");

}

@Then("^user enters homepage$")
public void user_enters_homepage()  {
	TestUtil.switchToFrame();
	
	
}

@Then("^user validates the homepage username$")
public void user_validates_the_homepage_username() {
	LogTest.info("Validating the Username");
	Assert.assertTrue(home.validateUsername());
}

@Then("^user closes the browser$")
public void user_closes_the_browser() {
	LogTest.info("Closing the Browser");
	driver.quit();
  
}


@Then("^user clicks on New Deals link$")
public void user_clicks_on_New_Deals_link() throws FindFailed {
   
	task = home.clickOnTasks();
	home.clickOnNewTasks();
	
}

@Then("^user enters \"(.*)\" and \"(.*)\" and \"(.*)\" details$")
public void user_enters_deal_details(String title1, String deadline1, String status1) {
    System.out.println(title1+" "+deadline1+""+status1);
	task.createTask(title1, deadline1, status1);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
}


@Then("^user clicks on Calendar link$")
public void user_clicks_on_Calendar_link(DataTable list) 
{
	List<List<String>> calendarListTest = list.raw();
	System.out.println(calendarListTest.get(0).get(0)+" "+calendarListTest.get(0).get(1)+" "+calendarListTest.get(0).get(2));
	System.out.println(calendarListTest.get(1).get(0)+" "+calendarListTest.get(1).get(1)+" "+calendarListTest.get(1).get(2));
	 
	//TestUtil.switchToFrame();
	calendar = home.clickCalendarLink();
	LogTest.info("Clicked on Calendar link");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
}

@Then("^user enters event details$")
public void user_enters_event_details(DataTable mapTable)  
{
	//TestUtil.switchToFrame();
	 for(Map<String,String> data: mapTable.asMaps(String.class, String.class))
	{
		 home.clickOnNewEvent();
		 LogTest.info("Clicked on New Event link");
		 
		 calendar.createEvent(data.get("Title"),data.get("FromDate"),data.get("ToDate"),data.get("AssignedTo"), data.get("Reminder"), data.get("Contact"));
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
	}
	
}

}
