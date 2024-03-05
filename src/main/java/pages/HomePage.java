package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By firstOrderButton = By.className("Button_Button__ra12g");
    private By secondOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
    }

    public void clickSecondOrderButton() {
        WebElement element = driver.findElement(secondOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickAccordionItemButton(String id) {
        WebElement element = driver.findElement(By.id(id));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id(id)).click();

    }

    public void checkExpandedAccordionItemPanel(String id) {
        String expand = driver.findElement(By.id(id)).getAttribute("aria-expanded");
        assertEquals("true", expand);
    }

    public String getTextAccordionItem(String id) {
        String text = driver.findElement(By.xpath(".//div[@aria-labelledby='"+id+"']/p")).getText();
        return text;
    }
}
