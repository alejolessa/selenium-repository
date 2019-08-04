package tests;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class SeleniumTestSuite {
		
	public WebDriver driver;
	
	@BeforeSuite
    public void beforeSuite() {
        // Download chromedriver http://chromedriver.chromium.org/downloads
        // http://chromedriver.chromium.org/getting-started
		System.setProperty("webdriver.chrome.driver","C:/Users/Alejo/Documents/chromedriver.exe");

        driver = new ChromeDriver();
    }	
	
        @AfterClass
        public void after() {
           if (driver != null)
                driver.quit();
        }       
    

}
    
