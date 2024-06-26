package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_004_ShareOptionTest extends BaseClass {

	//To validate the shareOptions are print in the console
	@Test
	public void validateShareOption()
	{
		
		logger.info("**** Starting TC_004_ShareOptionTest ****");
		BaseClass bc=new BaseClass();
		try {
		np.clickShareButton();
		bc.screenShot("\\shareButton");
		System.out.println("The Share Options are \n"+np.getShareOptions());
		bc.screenShot("\\shareOptions");
		np.clickShareButton();
		
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Starting TC_004_ShareOptionTest ****");
	}
}
