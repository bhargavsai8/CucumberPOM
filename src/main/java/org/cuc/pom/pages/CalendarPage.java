package org.cuc.pom.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.cuc.pom.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CalendarPage extends BaseClass {
	
	@FindBy(id="title")
	WebElement eventTitle;
	
	@FindBy(id="f_trigger_c_start")
	WebElement fromCalStart;
	
	@FindBy(id="fieldId_start")
	WebElement fromfield;
	
	@FindBy(id="fieldId_end")
	WebElement tofield;
	
	@FindBy(id="f_trigger_c_end")
	WebElement fromCalEnd;
	
	@FindBy(xpath="//input[@value='==ADD==>']")
	WebElement addButton;
	
	@FindBy(xpath="//input[@name='confirmed']")
	WebElement confirmedRadio;
	
	@FindBy(xpath="//input[@name='email_alert']")
	WebElement checkbox;
	
	@FindBy(xpath="//select[@name='reminder_minutes']")
	WebElement reminderDropdown;
	
	@FindBy(xpath="//input[@name='contact_lookup']//following-sibling::input[@value='Lookup']")
	WebElement contactsLookup;
	
	@FindBy(id="search")
	WebElement miniWindowSearch;
	
	@FindBy(xpath="//input[@id='search']//following-sibling::input")
	WebElement miniWindowButton;
	
	@FindBy(xpath="//form[@id='appForm']//descendant::table//descendant::tr//descendant::input[@value='Save']")
	WebElement saveButton;
	
	public CalendarPage()
	{
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyTitle(String title)
	{
		Assert.assertEquals(driver.getTitle(),title,"Title Matches");
	}

	
	public void createEvent(String title, String fromDate, String toDate, String assignedTo, String reminders,String contact)
	{
		eventTitle.sendKeys(title);
		
		JavascriptExecutor js1= ((JavascriptExecutor)driver);
		js1.executeScript("arguments[0].setAttribute('value','"+fromDate+"');", fromfield);
		
		JavascriptExecutor js2= ((JavascriptExecutor)driver);
		js2.executeScript("arguments[0].setAttribute('value','"+toDate+"');", tofield);
		
		Select assignedField = new Select(driver.findElement(By.xpath("//select[@name='assigned_to_user_id_src']")));
		assignedField.selectByVisibleText("bhargav sai");
		addButton.click();
		
		//selecting reminder field.
		List<WebElement> reminderValues = driver.findElements(By.xpath("//select[@name='reminder_minutes']//option"));
		for(int i = 0;i<reminderValues.size();i++)
		{
			if(reminderValues.get(i).getText().equalsIgnoreCase("30 Minutes"))
			{
				reminderValues.get(i).click();
			}
		}
		
		//Select a contact
		contactsLookup.click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		miniWindowSearch.sendKeys("test");
		miniWindowButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'test a')]")).click();
		
		driver.switchTo().window(parentWindow);
		
		driver.switchTo().frame("mainpanel");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='appForm']//descendant::table//descendant::tr//descendant::input[@value='Save']")));
		saveButton.click();
		
	}


}
	
	
