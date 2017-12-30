package org.cuc.pom.utility;

import org.cuc.pom.baseclass.BaseClass;

public class TestUtil extends BaseClass{
	
	public static int pageloadTimeout=30;
	public static int implicityTimeout=10;
	
	
	public static void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
}
