package MyTests;

import PageObject.OrderElements;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;


public class OrderElementsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test

    public void createOrder1() {



        OrderElements objOrderElements = new OrderElements(driver);
        objOrderElements.open();
        objOrderElements.clickCookieButton();
// клик на кнопку "Заказать"-------------------------------
        objOrderElements.clickTopOrderButton();
// заполнение первой страницы заказа
        objOrderElements.fillFirstPage(
                "Олег",
                "Ли",
                "Светлая 15, 54",
                "+79173232323");
// заполнение второй страницы заказа
        objOrderElements.fillSecondPage(
                "Домофон не работает");
// подтверждение оформления заказа
        objOrderElements.clickYesButton();
        String actualOrderText = objOrderElements.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }
    @Test

    public void createOrder2() {
        OrderElements objOrderElements = new OrderElements(driver);
        objOrderElements.open();
        objOrderElements.clickCookieButton();
// Скролл вниз
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
// Оформление заказа через нижнюю кнопку --------------------------
        objOrderElements.clickBottomOrderButton();
        objOrderElements.fillFirstPage(
                "Олег",
                "Ко",
                "Темная 22, 5",
                "+79171212312");
        objOrderElements.fillSecondPage(
                "Communication is disabled");
        objOrderElements.clickYesButton();
        String actualOrderText = objOrderElements.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }

}