package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageScooter {

    private WebDriver driver;

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    private By subHeader = By.className("Home_SubHeader__zwi_E");
    //локаторы для кнопок с вопросами
    private By accordionButton_0 = By.id("accordion__heading-0");
    private By accordionButton_1 = By.id("accordion__heading-1");
    private By accordionButton_2 = By.id("accordion__heading-2");
    private By accordionButton_3 = By.id("accordion__heading-3");
    private By accordionButton_4 = By.id("accordion__heading-4");
    private By accordionButton_5 = By.id("accordion__heading-5");
    private By accordionButton_6 = By.id("accordion__heading-6");
    private By accordionButton_7 = By.id("accordion__heading-7");

    //локаторы текстов под кнопками с вопросами
    private By accordionPanel_0 = By.id("accordion__panel-0");

    private By accordionPanel_1 = By.id("accordion__panel-1");

    private By accordionPanel_2 = By.id("accordion__panel-2");

    private By accordionPanel_3 = By.id("accordion__panel-3");

    private By accordionPanel_4 = By.id("accordion__panel-4");

    private By accordionPanel_5 = By.id("accordion__panel-5");

    private By accordionPanel_6 = By.id("accordion__panel-6");

    private By accordionPanel_7 = By.id("accordion__panel-7");

    public HomePageScooter(WebDriver driver) {

        this.driver = driver;
    }

    public HomePageScooter open() {
        driver.get(url);
        return this;
    }

    //метод для прокрутки страницы
    public void scrollPageDown() {
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //методы для нажатия на стрелочку
    public void clickOnFirstButtonWithQuestion(){

        driver.findElement(accordionButton_0).click();

    }


    public void clickOnSecondButtonWithQuestion(){

        driver.findElement(accordionButton_1).click();

    }

    public void clickOnThirdButtonWithQuestion(){

        driver.findElement(accordionButton_2).click();

    }

    public void clickOnFourthButtonWithQuestion(){

        driver.findElement(accordionButton_3).click();

    }

    public void clickOnFivethButtonWithQuestion(){

        driver.findElement(accordionButton_4).click();

    }

    public void clickOnSixthButtonWithQuestion(){

        driver.findElement(accordionButton_5).click();

    }

    public void clickOnSeventhButtonWithQuestion(){

        driver.findElement(accordionButton_6).click();

    }

    public void clickOnEighthButtonWithQuestion(){

        driver.findElement(accordionButton_7).click();

    }

    //Методы для получения текста под кнопками
    public String textPannelFirst(){
        return driver.findElement(By.id("accordion__panel-0")).getText();

    }

    public String textPannelSecond(){
        return driver.findElement(By.id("accordion__panel-1")).getText();
    }

    public String textPannelThird(){
        return driver.findElement(By.id("accordion__panel-2")).getText();
    }

    public String textPannelFourth(){
        return driver.findElement(By.id("accordion__panel-3")).getText();
    }

    public String textPannelFiveth(){
        return driver.findElement(By.id("accordion__panel-4")).getText();
    }

    public String textPannelSixth(){
        return driver.findElement(By.id("accordion__panel-5")).getText();
    }

    public String textPannelSeventh(){
        return driver.findElement(By.id("accordion__panel-6")).getText();
    }

    public String textPannelEighth(){
        return driver.findElement(By.id("accordion__panel-7")).getText();
    }



}
