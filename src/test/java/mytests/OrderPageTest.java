package mytests;

import pageobject.OrderPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.containsString;

public class OrderPageTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void createOrder1() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.open();
        objOrderPage.clickCookieButton();
// клик на кнопку "Заказать"-------------------------------
        objOrderPage.clickTopOrderButton();
// заполнение первой страницы заказа
        objOrderPage.fillFirstPage(
                "Олег",
                "Ли",
                "Светлая 15, 54",
                "+79173232323");
// заполнение второй страницы заказа
        objOrderPage.fillSecondPage(
                "Домофон не работает");
// подтверждение оформления заказа
        objOrderPage.clickYesButton();
        String actualOrderText = objOrderPage.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @Test
    public void createOrder2() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.open();
        objOrderPage.clickCookieButton();
// Скролл вниз
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
// Оформление заказа через нижнюю кнопку --------------------------
        objOrderPage.clickBottomOrderButton();
        objOrderPage.fillFirstPage(
                "Олег",
                "Ко",
                "Темная 22, 5",
                "+79171212312");
        objOrderPage.fillSecondPage(
                "Communication is disabled");
        objOrderPage.clickYesButton();
        String actualOrderText = objOrderPage.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}