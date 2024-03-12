# HEALTH CALCULATOR JULIA DEL RÍO

## Tests método 'HealthCalcImpl.idealWeight'

A continuación, inserto una enumerción de los casos de prueba que he considerado convenientes realizar para comprobar el correcto funcionamiento del método idealWeight.

1. **Test Altura Negativa**: Comprueba que el sistema actúa correctamente al introducirse una altura negativa.
2. **Test Altura Cero**: Se comprueba que se lanza una excepción al introducir una altura igual a cero.
3. **Test Peso Ideal Negativo**: El sistema debe rechazar un cálculo de peso ideal negativo.
4. **Test Altura Máxima Permitida**: El sistema lanza una excepción cuando la altura excede el límite máximo permitido por el tipo de dato.
5. **Test Género No Válido**: El sistema lanza una excepción para entradas de género que no sean "H" (hombre) o "M" (mujer).
6. **Test Peso Ideal Hombre**: Comprueba el cálculo correcto del peso ideal basándose en la fórmula para el género masculino y confirmando que el resultado coincide con el esperado.
7. **Test Peso Ideal Mujer**: Este test sirve para lo mismo que el anterior solo que ahora estudiamos el caso del género femenino.

## Tests método 'HealthCalcImpl.basalMetabolicRate'

En este otro apartado, se incluye otra lista de los casos de prueba para comprobar el funcionamiento del método basalMetabolicRate.

1. **Test Altura Negativa**: Verifica que se lanza una excepción al introducir una altura negativa.
2. **Test Altura Cero**: Se comprueba que la aplicación lanza una excepción al encontrar una altura igual a cero.
3. **Test Peso Negativo**: El sistema debe rechazar correctamente un valor de peso negativo.
4. **Test Edad Negativa**: Parecida a la anterior, pero en este caso lanza la excepción si se introduce una edad negativa.
5. **Test Peso Cero**: El sistema lanza una excepción al recibir un valor de peso igual a cero.
6. **Test Edad Cero**: El sistema debe reaccionar igual que en el test anterior, pero esta vez al encontrarse con una edad igual a cero.
7. **Test Altura Máxima Permitida**: Se comprueba que la aplicación lanza una excepción cuando la altura excede el límite máximo permitido por el tipo de dato.
8. **Test Peso Máximo Permitido**: Al igual que en el test anterior, se comprueba que la aplicación lanza una excepción cuando el valor del peso excede el límite máximo permitido por el tipo de dato.
9. **Test Edad Máxima Permitida**: Este otro también comprueba que se lanza una excepción cuando la edad supera el límite según el tipo de dato.
10. **Test Metabolismo Basal Negativo Hombre**: Con este test nos aseguramos de que el sistema rechaza un cálculo que resulte negativo en el caso del génro masculino.
11. **Test Metabolismo Basal Negativo Mujer**: Con este test nos aseguramos de que el sistema rechaza un cálculo que resulte negativo en el caso del género femenino.
12. **Test Género No Válido**: El sistema lanza una excepción para entradas de género que no sean "H" (hombre) o "M" (mujer).
13. **Test Metabolismo Basal Mujer**: Cálculo correcto del metabolismo basal para una mujer.
14. **Test Metabolismo Basal Hombre**: Cálculo correcto del metabolismo basal para un hombre.

## Resultado de los test

Por último, añado una captura de mi consola en la que se puede observar que todos los test mencionados anteriormente se ejecutaron correctamente.

!["Resultado de los tests"](/resultadoTests.png)