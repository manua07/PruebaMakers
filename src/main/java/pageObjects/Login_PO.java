package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.Constants_Vars;

public class Login_PO extends Base_PO {

    // Metodo Constructor
    public Login_PO() {
        super();
    }

    //Boton Menu
    private @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement btn_Menu; 

    //User Email
    private @FindBy(xpath = "//input[@id='user-name']")
    WebElement input_User_Email;

    //Input User Password
    private @FindBy(xpath = "//input[@id='password']")
    WebElement input_User_Pwd;

    //Localizador Mensaje Login Incorrecto
    private @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement msj_inicio_sesion;

    //Boton Iniciar Sesion
    private @FindBy(xpath = "//input[@id='login-button']")
    WebElement btn_Iniciar_Sesion;

    
    public void goToLoginPageSwag () {
        navigateToUrl(Constants_Vars.URL);
    }

    public void login() {
        sendKeys(input_User_Email, Constants_Vars.USER_EMAIL);
        sendKeys(input_User_Pwd, Constants_Vars.USER_PASSWORD);
        waitForWebElementAndClick(btn_Iniciar_Sesion);
    }

      public void loginCredencialesIncorrectas() {
        sendKeys(input_User_Email, Constants_Vars.USER_EMAIL_INCORRECTO);
        sendKeys(input_User_Pwd, Constants_Vars.USER_PASSWORD_INCORRECTO);
        waitForWebElementAndClick(btn_Iniciar_Sesion);
    }


    public void validarInicioSesion() {
        Assert.assertTrue(btn_Menu.isDisplayed(), "Open Menu");
    }

     public void validarNoInicioSesion() {
        String mensaje = msj_inicio_sesion.getText();
        Assert.assertEquals(mensaje, "Epic sadface: Username and password do not match any user in this service");
    }

}
