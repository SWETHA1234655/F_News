package testCases;

import java.time.Duration;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

import testBase.BaseClass;
import utilities.ExcelOutputFile;



public class TC_001_UserInfoTest extends BaseClass{
	
	//To verify the user information is displayed in a console or not
	@Test
	public void verifyUserInfoDisplay()
	{
		logger.info("**** Starting TC_001_UserInfoTest  ****");
		hp = new HomePage(driver);
		BaseClass bc= new BaseClass();
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			    try
				   {
			    	
			    	 hp.UserButton();
			    	 bc.screenShot("\\userClick");
				    
				    	String name=hp.UserInfo1().getText();
				    	System.out.println(name);
				    	
				    	String mail=hp.UserInfo2().getText();
				    	System.out.println(mail);
				    	
				    	ExcelOutputFile.setCellData(exfile,"profile",1,0,name);
				    	ExcelOutputFile.setCellData(exfile,"profile",1,1,mail);
				    	
					  
				     }
				   
				   catch(Exception e)
				    {
					   e.printStackTrace();
				    }
			 
		}
		catch(Exception e )
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_001_UserInfoTest  ****");
	}
}
