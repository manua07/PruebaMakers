package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Cart_PO extends Base_PO {

    // Metodo Constructor
    public Cart_PO() {
        super();
    }

    //Boton Producto1
    private @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement btn_Product1;

    //Boton Producto2
    private @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement btn_Product2;

    //Boton Carrito de compras
    private @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement btn_Cart;

    //Descripcion Producto1
    private @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElement description_Product1;

     //Descripcion Producto2
    private @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    WebElement description_Product2; 


    public void agregarProductosAlCarrito() {
      btn_Product1.click();
      btn_Product2.click();
      btn_Cart.click();
    }

     public void verificarProductosAgregadosAlCarro() {
      String producto1 = description_Product1.getText();
        Assert.assertEquals(producto1, "Sauce Labs Backpack");

      String producto2 = description_Product2.getText();
        Assert.assertEquals(producto2, "Sauce Labs Bike Light");

    }

}
