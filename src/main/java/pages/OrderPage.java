package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class OrderPage {

    private WebDriver driver;

    private static final String URL = "https://qa-scooter.praktikum-services.ru/order";
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By leasePeriodField = By.className("Dropdown-arrow");
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By orderPopup = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(URL, currentUrl);
    }

    public void fillFirstNameField(String name) {
        driver.findElement(firstNameField).sendKeys(name);
    }

    public void fillSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    public void fillAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void fillMetroStationField(String metro) {
        driver.findElement(metroStationField).click();
        WebElement element = driver.findElement(By.xpath(".//div[@class='Order_Text__2broi' and text()='" + metro +"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void fillPhoneNumberField(String phone) {
        driver.findElement(phoneNumberField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void fillLeasePeriodField(String period) {
        driver.findElement(leasePeriodField).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + period +"']")).click();
    }

    public void chooseColor(String color) {
        driver.findElement(By.xpath(".//label[@class='Checkbox_Label__3wxSf' and text()='" + color + "']/input")).click();
    }

    public void fillCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

     public boolean checkOrderPopupEnabled() {
        return driver.findElement(orderPopup).isEnabled();
     }

     public void fillAboutClientForm(String name, String secondName, String address, String metro, String phone) {
         fillFirstNameField(name);
         fillSecondNameField(secondName);
         fillAddressField(address);
         fillMetroStationField(metro);
         fillPhoneNumberField(phone);
         clickNextButton();
     }

     public void fillAboutLeaseForm(String date, String period, String color, String comment) {
         fillDateField(date);
         fillLeasePeriodField(period);
         chooseColor(color);
         fillCommentField(comment);
         clickOrderButton();
     }
}


