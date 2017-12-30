package org.cuc.pom.pages;

import org.cuc.pom.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class HomePage extends BaseClass{


	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//td[contains(text(),'User: bhargav sai')]")
	WebElement usernametext;
	
	@FindBy(xpath="//a[@title='New Event']")
	WebElement newEventLink;
	
	@FindBy(xpath="//a[text()='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[text()='New Company']")
	WebElement newCompany;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@title='New Task']")
	WebElement newTask;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateUsername()
	{
		return usernametext.isDisplayed();
	}
	
	
	public TasksPage clickOnTasks() throws FindFailed
	{
		Screen scr = new Screen();
		Pattern p = new Pattern(System.getProperty("user.dir")+"//src//main//resources//TasksLink.png");
		scr.wait(p,2000);
		scr.click();
		
		return new TasksPage();
		
		
	}
	
	public void clickOnNewTasks()
	{
		Actions action = new Actions(driver);
		action.moveToElement(tasksLink)
		.build()
		.perform();
		
		newTask.click();
		
	}
	

	public CalendarPage clickCalendarLink()
	{
		calendarLink.click();
		return new CalendarPage();
	}
	
	
	public void clickOnNewEvent()
	{
		Actions action = new Actions(driver);
		action.moveToElement(calendarLink).build().perform();
		newEventLink.click();
	}
}
