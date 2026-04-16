Feature: Flujo de compra en Demoblaze

  Scenario Outline: Compra exitosa de dos productos por categoria
    Given que el usuario ingresa a Demoblaze
    When agrega el producto "<categoria>" de la categoria "<producto>" al carrito
    And visualiza el carrito
    And completa el formulario de compra
    Then finaliza la compra exitosamente

    Examples:
      | categoria | producto |
      | Phones    | Samsung galaxy s6 |
      | Laptops   | Sony vaio i5 |
      | Monitors  | Apple monitor 24 |