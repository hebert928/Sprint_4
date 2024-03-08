package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private static final String URL = "https://qa-scooter.praktikum-services.ru";
    private By firstOrderButton = By.className("Button_Button__ra12g");
    private By secondOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get(URL);
    }

    public void clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
    }

    public void clickSecondOrderButton() {
        WebElement element = driver.findElement(secondOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickAccordionItemButton(int index) {
        WebElement element = findAccordionItemElement(index);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();

    }

    public void checkExpandedAccordionItemPanel(int index) {
        String expand = findAccordionItemElement(index).getAttribute("aria-expanded");
        assertEquals("true", expand);
    }

    public String getTextAccordionItem(int index) {
        String text = driver.findElement(By.xpath(".//div[@aria-labelledby='accordion__heading-"+index+"']/p")).getText();
        return text;
    }

    private WebElement findAccordionItemElement(int index) {
        return driver.findElement(By.id("accordion__heading-"+index));
    }
}
