package pages;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderPageTest {
    private WebDriver driver;
    private final String name;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public OrderPageTest(
            String name,
            String secondName,
            String address,
            String metro,
            String phone,
            String date,
            String period,
            String color,
            String comment) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[] [] getTestData() {
        return new Object[][] {
                {
                        "Василий",
                        "Тёркин",
                        "Фрунзенская набережная 46",
                        "Фрунзенская",
                        "89045678735",
                        "09.03.2024",
                        "сутки",
                        "чёрный жемчуг",
                        "не звонить в домофон"
                },
                {
                        "Анна София",
                        "Эбер",
                        "3-я Фрунзенская улица, 12",
                        "Спортивная",
                        "+79045683425",
                        "15.03.2024",
                        "двое суток",
                        "серая безысходность",
                        "код домофона 123"
                },
        };
    }
    @Test
    public void firstCheckMakeOrder() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickFirstOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillAboutClientForm(name, secondName, address, metro, phone);
        objOrderPage.fillAboutLeaseForm(date, period, color, comment);
        objOrderPage.clickYesButton();
        boolean actual = objOrderPage.checkOrderPopupEnabled();
        assertEquals(true, actual);

    }

    @Test
    public void secondCheckMakeOrder() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickSecondOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillAboutClientForm(name, secondName, address, metro, phone);
        objOrderPage.fillAboutLeaseForm(date, period, color, comment);
        objOrderPage.clickYesButton();
        boolean actual = objOrderPage.checkOrderPopupEnabled();
        assertEquals(true, actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}