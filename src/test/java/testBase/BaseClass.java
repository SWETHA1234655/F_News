package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.NewsPage;
import utilities.ExcelOutputFile;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public Properties p;
	public static HomePage hp;
	public static NewsPage np;
	public String exfile=System.getProperty("user.dir") + "\\excel\\outputfile.xlsx";

	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) throws IOException
	{
		//To read a properties file
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		//To load the properties file
		p.load(file);
		
		//Loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		//choose the browser to run the test cases
		switch(browser.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("No Browsers matching");
		return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//To get a url in properties file
		driver.get(p.getProperty("appURL"));
		//maximize the window
		driver.manage().window().maximize();
		
		ExcelOutputFile.createExcel();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	//This method is used to take a screenshot for all the details
	public void screenShot(String testName) throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		File targetFile=new File("C:\\Users\\2318570\\eclipse-workspace\\Featured_News-master\\screenshots"+testName+".png");
		
		FileUtils.copyFile(sourceFile, targetFile);
		
	
	}
}
