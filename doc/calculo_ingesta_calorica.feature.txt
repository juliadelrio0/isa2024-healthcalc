Feature: Cálculo de ingesta calórica diaria recomendada

  Scenario: Cálculo de ingesta calórica para un hombre
    Given que soy un hombre de 30 años, peso 80 kg y mido 175 cm
    When ingreso estos datos en la calculadora
    Then debo recibir un resultado que estime mi ingesta calórica diaria recomendada

  Scenario: Cálculo de ingesta calórica para una mujer
    Given que soy una mujer de 25 años, peso 60 kg y mido 160 cm
    When ingreso estos datos en la calculadora
    Then debo recibir un resultado que estime mi ingesta calórica diaria recomendada

  Scenario: Altura negativa
    Given intento calcular mi ingesta calórica diaria recomendada y proporciono una altura negativa
    Then la calculadora debe mostrar un mensaje de error indicando que la altura no puede ser negativa

  Scenario: Peso negativo
    Given intento calcular mi ingesta calórica diaria recomendada y proporciono un peso negativo
    Then la calculadora debe mostrar un mensaje de error indicando que el peso no puede ser negativo

  Scenario: Edad negativa
    Given intento calcular mi ingesta calórica diaria recomendada y proporciono una edad negativa
    Then la calculadora debe mostrar un mensaje de error indicando que la edad no puede ser negativa
