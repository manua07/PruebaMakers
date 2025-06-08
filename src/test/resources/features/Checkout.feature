@checkouttest
Feature: Completar proceso de compra

  @completecheckout
  Scenario: Completar checkout
    Given estoy en la pagina de inicio
    When ingreso las credenciales
    When agrego productos al carrito de compras
    When ingreso informacion de checkout '<FirstName>' '<LastName>' '<PostalCode>'
    Then verifico que se realizo la orden correctamente

      Examples:
      | FirstName  | LastName  | PostalCode | 
      | Andrea      | Giraldo   | 1234      |

      
