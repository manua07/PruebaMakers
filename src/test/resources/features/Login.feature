@logintest
Feature: Inicio sesion

  @logintestsuccess
  Scenario: Iniciar sesion correctamente
    Given estoy en la pagina de inicio
    When ingreso las credenciales
    Then se inicia sesion correctamente


  @logintestfail
  Scenario: Iniciar sesion con credenciales incorrectas
    Given estoy en la pagina de inicio
    When ingreso credenciales incorrectas
    Then no se inicia sesion


