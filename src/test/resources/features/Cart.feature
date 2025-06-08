@carttest
Feature: Agregar productos al carro

  @addproductscart
  Scenario: Agregar productos al carrito de compras
    Given estoy en la pagina de inicio
    When ingreso las credenciales
    When agrego productos al carrito de compras
    Then verifico que los productos se agregaron correctamente
