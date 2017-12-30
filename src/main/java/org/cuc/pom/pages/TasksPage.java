package org.cuc.pom.pages;


import org.cuc.pom.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TasksPage extends BaseClass {
	
	@FindBy(id="title")
	WebElement taskTitle;
	
	@FindBy(id = "fieldId_deadline")
	WebElement calendarField;
	
	@FindBy(xpath="//form[@id='taskForm']//descendant::table//descendant::tr//descendant::input[@value='Save']")
	WebElement saveButton;

	public TasksPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createTask(String title, String deadline, String status)
	{
		taskTitle.sendKeys(title);
		
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+deadline+"')", calendarField);
		
		Select selStatus = new Select(driver.findElement(By.xpath("//select[@name='status']")));
		selStatus.selectByValue(status);
		
		saveButton.click();
	}
}
