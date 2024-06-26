package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_006_LinksActiveTest extends BaseClass{
	
	//To validate the links present in the newsletter are to be displayed in the console
	@Test
	public void checkingLinks()
	{
		BaseClass bc=new BaseClass();
		logger.info("**** Starting TC_006_LinksActiveTest ****");
		try {
			np.isLinksActive();
			bc.screenShot("\\Links");
			hp.clickBeCognizant();
			}
			catch(Exception e)
			{
				logger.error("test failed");
				Assert.fail("An exception occured:"+ e.getMessage());
			}
		logger.info("**** Finished TC_006_LinksActiveTest ****");
	}
	
}
