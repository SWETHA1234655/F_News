package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_005_NewsLetterTest extends BaseClass{
	
	//To validate the Paragragh present in the newsletter are to be print in console
	@Test
	public void getNewsLetter() throws InterruptedException
	{
		BaseClass bc=new BaseClass();
		logger.info("**** Starting TC_005_NewsLetterTest ****");
		
		try {
			System.out.println("\nThe News Contents are \n"+np.getParagraph());
			bc.screenShot("\\Paragraph");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_005_NewsLetterTest ****");
	}
}
