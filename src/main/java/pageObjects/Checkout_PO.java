package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import driver.DriverFactory;

public class Checkout_PO extends Base_PO {

// Metodo Constructor
    public Checkout_PO() {
        super();
    }

    //Boton Checkout
    private @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement btn_Checkout;

    //Input Primer Nombre
    private @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement input_First_Name;

    //Input Apellido
    private @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement input_Last_Name; 

    //Input Codigo Postal
    private @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement input_Postal_Code;

    //Boton Continar
    private @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement btn_Continue;

    //Boton Finalizar
    private @FindBy(xpath = "//*[@id=\"finish\"]")
    WebElement btn_Finish;

    //Localizador Mensaje Envio de Orden
    private @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement msj_envio_de_orden;

    public void ingreso_informacion_para_completar_checkout(String FirstName, String LastName, String PostalCode) {
      DriverFactory.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
      btn_Checkout.click();
      input_First_Name.click();
      sendKeys(input_First_Name, FirstName);
      input_Last_Name.click();
      sendKeys(input_Last_Name, LastName);
      input_Postal_Code.click();
      sendKeys(input_Postal_Code, PostalCode);
      waitForWebElementAndClick(btn_Continue);
    }

    public void validarOrdenEnviada() {
        waitForWebElementAndClick(btn_Finish);
        String mensajeOrden = msj_envio_de_orden.getText();
        Assert.assertEquals(mensajeOrden, "Thank you for your order!");
    }
}
