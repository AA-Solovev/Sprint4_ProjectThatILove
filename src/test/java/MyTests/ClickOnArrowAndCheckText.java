package MyTests;

import PageObject.HomePageScooter;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.is;

public class ClickOnArrowAndCheckText {
    private WebDriver driver;

    @Before
    public void setUp() {
        //выбор драйвера для браузера
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    //тесты для проверки текста после нажатия на стрелочкии
    @Test
    public void checkQuestions1(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnFirstButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelFirst();
        String expectedQuestionText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        MatcherAssert.assertThat(actualQuestionText,  is(expectedQuestionText));

    }

    @Test
    public void checkQuestions2(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnSecondButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelSecond();
        String expectedQuestionText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions3(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnThirdButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelThird();
        String expectedQuestionText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions4(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnFourthButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelFourth();
        String expectedQuestionText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions5(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnFivethButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelFiveth();
        String expectedQuestionText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions6(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnSixthButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelSixth();
        String expectedQuestionText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions7(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnSeventhButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelSeventh();
        String expectedQuestionText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions8(){


        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.clickOnEighthButtonWithQuestion();
        String actualQuestionText = objHomePage.textPannelEighth();
        String expectedQuestionText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @After
    public void teardown() {
//         Закрытие браузер
        driver.quit();
    }


}