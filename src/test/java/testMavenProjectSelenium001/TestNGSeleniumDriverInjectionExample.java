package testMavenProjectSelenium001;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
@ContextConfiguration(locations = { "/driver_context.xml" })
public class TestNGSeleniumDriverInjectionExample extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebDriver driver;
     
    @BeforeClass
    public void printBrowserUsed() {
    	driver = new FirefoxDriver();
        System.out.println("Driver used is: " + driver);
    }
 
    @Test
    public void searchTestNGInGoogle() {
        final String searchKey = "TestNG";
        System.out.println("Search " + searchKey + " in google");
        driver.navigate().to("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        System.out.println("Enter " + searchKey);
        element.sendKeys(searchKey);
        System.out.println("submit");
        element.submit();
       
        System.out.println("Got " + searchKey + " results");
    }
 
    @AfterSuite
    public void quitDriver() throws Exception {
        driver.quit();
    }
}