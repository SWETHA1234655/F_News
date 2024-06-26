package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_003_AuthorInfoTest extends BaseClass{
	
	
	//To validate the author is hovered or not
	@Test
	public void validateAuthorInfoDisplay()
	{
		logger.info("**** Starting TC_003_AuthorInfoTest ****");
		BaseClass bc=new BaseClass();
		try {
			Thread.sleep(5000);
			np.hoverAuthorDetails();
			bc.screenShot("\\Author");
			System.out.println("Associate details are displayed in pop up : "+np.isPersonalCardDisplayed());
			System.out.println();
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_003_AuthorInfoTest ****");
	}
}
