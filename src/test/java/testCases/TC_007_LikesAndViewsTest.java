package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_007_LikesAndViewsTest extends BaseClass{
	
	//To validate the likes and views are displayed in the console
	@Test
	public void getTotalLikesAndViews() throws InterruptedException
	{
		BaseClass bc=new BaseClass();
		logger.info("**** Starting TC_007_LikesAndViewsTest ****");
		try {
		Thread.sleep(3000);
		
		System.out.println("\nTotal Likes: "+np.getTotalLikes());
		bc.screenShot("\\Likes");
		System.out.println("\nTotal Views: "+np.getTotalViews());
		bc.screenShot("\\views");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_007_LikesAndViewsTest ****");
	}
}
