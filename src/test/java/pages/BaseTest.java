package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

   @Before
   public void init() {
       driver = new ChromeDriver();
   }

    @After
    public void teardown() {
        driver.quit();
    }
}
