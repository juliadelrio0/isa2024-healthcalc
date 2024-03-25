Feature: Cálculo del Índice de Masa Corporal (IMC)

  Scenario: Cálculo del IMC para un hombre
    Given que soy un hombre de 35 años, peso 80 kg y mido 175 cm
    When ingreso estos datos en la calculadora
    Then debo recibir un resultado que estime mi IMC

  Scenario: Cálculo del IMC para una mujer
    Given que soy una mujer de 28 años, peso 60 kg y mido 160 cm
    When ingreso estos datos en la calculadora
    Then debo recibir un resultado que estime mi IMC

  Scenario: Altura negativa
    Given intento calcular mi IMC y proporciono una altura negativa
    Then la calculadora debe mostrar un mensaje de error indicando que la altura no puede ser negativa
