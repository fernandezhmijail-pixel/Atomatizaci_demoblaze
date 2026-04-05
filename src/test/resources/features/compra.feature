Feature: Flujo de compra en Demoblaze

  Scenario: Compra exitosa de dos productos
    Given que el usuario ingresa a Demoblaze
    When agrega dos productos al carrito "Phones"
    And visualiza el carrito
    And completa el formulario de compra
    Then finaliza la compra exitosamente