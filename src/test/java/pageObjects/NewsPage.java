package pageObjects;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends BasePage{
	//constructor
	public NewsPage(WebDriver driver) {
		super(driver);
		
	}
	//Include explicit wait for to wait the condition to meet.
	WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//create a Actions class
	Actions act = new Actions(driver);
	//create a javascriptExecutor
	JavascriptExecutor jse =(JavascriptExecutor)driver;
	
	//Locators
	@FindBy(xpath="//div[@data-automation-id='TitleTextId']")
	WebElement title;
	
	@FindBy(xpath="//div[@data-automation-id='textBox']//p")
	List<WebElement> paragraphs;
	
	@FindBy(xpath="//div[@data-automation-id='textBox']//a")
	List<WebElement> links;
	
	@FindBy(xpath="//div[@data-automation-id='personaDetails']")
	WebElement author;
	
	@FindBy(xpath="//div[@id='LivePersonaCardRootElement']")
	WebElement personalCard;
	
	@FindBy(xpath="//button[@data-automation-id='shareButton']")
	WebElement shareButton;
	
	@FindBy(xpath="//span[text()='Share page']/ancestor::ul")
	WebElement shareOptions;
	
	@FindBy(xpath="//span[contains(text(),'liked this')]")
	WebElement totalLikes;
	
	@FindBy(xpath="//span[contains(text(),'Views')]")
	WebElement totalViews;
	
	@FindBy(xpath="//*[@data-automation-id=\"contentScrollRegion\"]") 
	public WebElement scroll;
	
	//This method is display the active link present in the newsletter
	public void isLinksActive() throws IOException
	{
	
	
		for(WebElement link:links) {
			System.out.println("NewsletterLinks :"+link.getAttribute("href"));		}
	}
	
	//This method is to display the total likes in the particular news
	public String getTotalLikes() throws InterruptedException
	{
		title.click();
		act.sendKeys(Keys.END).perform();
		jse.executeScript("arguments[0].scrollTop += 12000;",scroll);
		Thread.sleep(6000);
		String likes[] = totalLikes.getText().split(" ");
		return likes[0];
	}
	
	//This method is to display the total views in the particular news
	public String getTotalViews() throws InterruptedException
	{
		

		act.sendKeys(Keys.END).perform();
		jse.executeScript("arguments[0].scrollTop += 12000;",scroll);
		Thread.sleep(6000);
		String views[]= totalViews.getText().split(" ");
		return views[0];
	}
	
	//This method is to display the share options list
	public String getShareOptions()
	{
		return shareOptions.getText();
		
	}
	
	//This method is to click the share button
	public void clickShareButton()
	{
		shareButton.click();
	}
	
	//This method is to display the title of the particular news
	public String getNewsTitle()
	{
		return title.getText();
	}
	
	//This method is to display the paragraph in the particular news
	public String getParagraph()
	{

		String paragraph = "";
		for(WebElement para:paragraphs)
		{
			paragraph+=para.getText()+"\n";
		}
		return paragraph;
	}
	//This method is to check the author field is hovered or not
	public void hoverAuthorDetails()
	{
		try {
			if(author.isDisplayed())
			{
				act.moveToElement(author).perform();
				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Author not found");
		}
	}
	//This method is to check whether the page is displayed or not
	public boolean isPersonalCardDisplayed()
	{
		try {
			if(personalCard.isDisplayed())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("No Personal Card Displayed");
		}
		return false;
	}
}
