package stepDefinitions;

import static driver.DriverFactory.cleanupDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Checkout_PO;

public class CheckoutSteps {

    private Checkout_PO checkout_PO;


    public CheckoutSteps(Checkout_PO checkout_PO) {
        this.checkout_PO = checkout_PO;

    }

    @When("ingreso informacion de checkout {string} {string} {string}")
    public void ingreso_informacion_checkout(String FirstName, String LastName, String PostalCode) {
        checkout_PO.ingreso_informacion_para_completar_checkout(FirstName, LastName, PostalCode);
    }

    @Then("verifico que se realizo la orden correctamente")
    public void verifico_orden_correctamente() {
        checkout_PO.validarOrdenEnviada();
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }

}
