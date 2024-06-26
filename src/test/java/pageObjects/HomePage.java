package pageObjects;

import java.time.Duration;
import java.util.List;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

import utilities.ExcelOutputFile;

public class HomePage extends BasePage {
	
	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	Actions act=new Actions(driver);
	//Locators
	@FindBy(xpath="//div[@data-automation-id='HeroPatternElement']")
	List<WebElement> featuredNews;
	
	@FindBy(xpath="//span[text()='be.cognizant']")
	WebElement beCognizant;
	
	@FindBy(xpath="//button[@id='O365_MainLink_Me']")
	WebElement UserButton;
	
	@FindBy(xpath="//div[@data-automation-id='HeroPatternElement']")
	List<WebElement> featuredTitle; 
	
	@FindBy(xpath="//div[@class='mectrl_accountDetails']/div[1]")
	WebElement UserInfo1;
	
	@FindBy(xpath="//div[@class='mectrl_accountDetails']/div[2]")
	WebElement UserInfo2;
	
	//Actions
	
	public List<WebElement> featuredNews()
	{
		return featuredNews;
	}
	
	//check the tooltip in the title text
	public String getToolTipTitle(int no)
	{
		int newsnum = no-1;
	    return featuredTitle.get(newsnum).getText();
//		String str=featuredTitle.get(newsnum).getAttribute("title");
//		return str;
	}
	
	//click the every news which is based on the news index
	public void clickEveryNews(int id) 
	{	
		int newsnum = id-1;
		featuredNews.get(newsnum).click();
		
	}
	
	//click the Becognizant
	public void clickBeCognizant()
	{
		
		beCognizant.click();
		
	}
	
	//find the user button and return it
	public void UserButton() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(UserButton));
		act.moveToElement(UserButton).perform();
		
		act.click().perform();
		Thread.sleep(2000);
		act.doubleClick().perform();
		Thread.sleep(2000);
		
		
	}
	
	//Get the user name and return it
	public WebElement UserInfo1()
	{
		wait.until(ExpectedConditions.visibilityOf(UserInfo1));
		return UserInfo1;
	}
	//Get the user mail and return it
	public WebElement UserInfo2()
	{
		wait.until(ExpectedConditions.visibilityOf(UserInfo2));
		return UserInfo2;
	}
	


}
