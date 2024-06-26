package testCases;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pageObjects.NewsPage;
import testBase.BaseClass;

public class TC_002_CheckTitleTest extends BaseClass{
	
	//Validate the news title and tooltip are same or not
	@Test
	@Parameters({"Newsno"})
	public void checkTitle(String no)
	{
		logger.info("**** Starting TC_002_CheckTitleTest ****");
		np = new NewsPage(driver);
		BaseClass bc=new BaseClass();
		try 
		{
			int newsNum = Integer.parseInt(no);
			String toolTitle =hp.getToolTipTitle(newsNum);
			hp.clickEveryNews(newsNum);
			bc.screenShot("\\Title");
			String headerTitle= np.getNewsTitle();
			if(toolTitle.equals(headerTitle))
			{
				//System.out.println(headerTitle);
				//System.out.println(toolTitle);
				System.out.println("News Header and Tooltip displayed are same ");
			}
			else
			{
				System.out.println("News Header and Tooltip displayed are not same ");
			}
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_002_CheckTitleTest ****");
		
	}
}
