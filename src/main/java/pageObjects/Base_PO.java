package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import utils.Constants_Vars;


public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    /**
     * Navega hacia una url especifica
     *
     * @param url - Url a la que se quiere navegar
     **/
    public void navigateToUrl (String url)  {
        getDriver().get(url);
    }


    /**
     * Accion de mandar valores a un elemento By
     *
     * @param by - selector de cualquier tipo (Xpath, ClassName, etc...)
     * @param textToType - texto que se desea escribir
     **/

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    /**
     * Accion de mandar valores a un WebElement
     *
     * @param element - Webelement con el que se quiere interactuar
     * @param textToType - texto que se desea escribir
     **/
    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }
    public void clearAndsendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        element.sendKeys(textToType);
    }

    /**
     * Espera por un elemento hasta que sea clickeable, y luego hace click
     *
     * @param by - selector de cualquier tipo (Xpath, ClassName, etc...)
     **/
    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    /**
     * Espera por un elemento hasta que sea clickeable, y luego hace click
     *
     * @param element - Webelement al que haremos click
     **/
    public void  waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Constants_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Espera por un elemento hasta que sea clickeable
     *
     * @param timeoutInSeconds tiempo máximo en segundos que se esperará por el elemento
     * @param element          elemento que se desea esperar a que sea clickeable
     * @return
     */
    public void waitForElementClickeable (WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementClickeable (By by, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void esperaImplicita (int tiempo) throws InterruptedException {
        Thread.sleep(tiempo);
    }

}