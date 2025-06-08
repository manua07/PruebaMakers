package stepDefinitions;

import static driver.DriverFactory.cleanupDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cart_PO;

public class CartSteps {

     private Cart_PO cartPo;


    public CartSteps(Cart_PO cartPo) {
        this.cartPo = cartPo;

    }

    @When("agrego productos al carrito de compras")
    public void agrego_productos_carrito_compras() {
        cartPo.agregarProductosAlCarrito();
    }

    @Then("verifico que los productos se agregaron correctamente")
    public void verifico_productos_en_carro() {
        cartPo.verificarProductosAgregadosAlCarro();

    }

    @After
    public void tearDown() {
        cleanupDriver();
    }

}
