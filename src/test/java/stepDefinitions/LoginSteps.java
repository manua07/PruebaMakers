package stepDefinitions;

import static driver.DriverFactory.cleanupDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;
import utils.Constants_Vars;



public class LoginSteps extends Base_PO {

    private Login_PO loginPo;


    public LoginSteps(Login_PO loginPo) {
        this.loginPo = loginPo;

    }


    @Given("estoy en la pagina de inicio")
    public void estoy_en_la_pagina_de_inicio() {
        loginPo.navigateToUrl(Constants_Vars.URL);

    }

    @When("ingreso las credenciales")
    public void ingreso_mis_credenciales() {
        loginPo.login();

    }

    @When("ingreso credenciales incorrectas")
    public void ingreso_credenciales_incorrectas() {
        loginPo.loginCredencialesIncorrectas();
    }


    @Then("se inicia sesion correctamente")
    public void inicio_sesion_correcto() {
        loginPo.validarInicioSesion();

    }

    @Then("no se inicia sesion")
    public void no_inicio_sesion_correcto() {
        loginPo.validarNoInicioSesion();

    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
