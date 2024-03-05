package pages;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HomePageTest {

    private WebDriver driver;
    private final String id;
    private final String checkedText;


    public HomePageTest(String id, String checkedText) {
        this.id = id;
        this.checkedText = checkedText;

    }

    @Parameterized.Parameters
    public static Object[] [] getTestData() {
        return new Object[][] {
                {"accordion__heading-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"accordion__heading-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkedFAQList(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAccordionItemButton(id);
        objHomePage.checkExpandedAccordionItemPanel(id);
        String actual = objHomePage.getTextAccordionItem(id);
        assertEquals(checkedText, actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
