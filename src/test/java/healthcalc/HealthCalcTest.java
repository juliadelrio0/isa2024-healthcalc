package healthcalc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl calc = new HealthCalcImpl();

	// Tests método 'HealthCalcImpl.idealBodyWeight'
	
	@Test
	@DisplayName("Test Altura Negativa")
	public void testAlturaNegativa() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.idealWeight(-8, 'h'),
		"La altura no puede ser un número negativo.");
	}

	@Test
	@DisplayName("Test Altura Cero")
	public void testAlturaCero() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.idealWeight(0, 'h'),
		"La altura no puede ser cero.");
	}

	@Test
	@DisplayName("Test Peso Ideal Negativo")
	public void testPesoIdealNegativo() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.idealWeight(50, 'h'),
		"El peso tiene que ser un valor positivo.");
	}

	@Test
	@DisplayName("Test Altura Máxima Permitida")
	public void testAlturaMaximaPermitida() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.idealWeight(Integer.MAX_VALUE, 'h'),
		"El valor de altura introducido es demasiado gande.");
	}

	@Test
	@DisplayName("Test Género No Válido")
	public void testGeneroNoValido() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.idealWeight(180, 'w'),
		"Los valores posibles de género son: 'h' (hombre) o 'm' (mujer).");
	}

	@Test
	@DisplayName("Test Peso Ideal Hombre")
	public void testPesoIdealHombre() throws Exception {
		int altura = 180;
		char genero = 'h';
		float pesoIdeal = altura - 100 - (altura-150) / 4f;
		assertEquals(pesoIdeal, calc.idealWeight(altura, genero),
		"El cálculo no es correcto.");
	}

	@Test
	@DisplayName("Test Peso Ideal Mujer")
	public void testPesoIdealMujer() throws Exception {
		int altura = 190;
		char genero = 'm';
		float pesoIdeal = altura - 100 - (altura-150) / 2.5f;
		assertEquals(pesoIdeal, calc.idealWeight(altura, genero),
		"El cálculo no es correcto.");
	}

	// Tests método 'HealthCalcImpl.basalMetabolicRate'
	
	@Test
	@DisplayName("Test Altura Negativa")
	public void testAlturaNegativa2() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, -10, 'm', 21),
		"La altura debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test Altura Cero")
	public void testAlturaCero2() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, 0, 'm', 21),
		"La altura no puede valer cero.");
	}

	@Test
	@DisplayName("Test Peso Negativo")
	public void testPesoNegativo() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(-1, 163, 'm', 21),
		"El valor del peso debe ser positivo.");
	}

	@Test
	@DisplayName("Test Edad Negativa")
	public void testEdadNegativa() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, 163, 'm', -1),
		"La edad debe ser un número positivo.");
	}

	@Test
	@DisplayName("Test Peso Cero")
	public void testPesoCero() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(0, 163, 'm', 21),
		"El peso no puede ser cero.");
	}

	@Test
	@DisplayName("Test Edad Cero")
	public void testEdadCero() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, 163, 'm', 0),
		"La edad no puede valer cero.");
	}

	@Test
	@DisplayName("Test Altura Máxima Permitida")
	public void testAlturaMaximaPermitida2() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, Integer.MAX_VALUE, 'm', 21),
		"El valor de la altura es demasiado grande.");
	}

	@Test
	@DisplayName("Test Peso Máximo Permitido")
	public void testPesoMaximoPermitido() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(Float.MAX_VALUE, 163, 'm', 21),
		"El valor del peso es demasiado grande.");
	}

	@Test
	@DisplayName("Test Edad Máxima Permitida")
	public void testEdadMaximaPermitida() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, 163, 'm', Integer.MAX_VALUE),
		"El valor de la edad es demasiado grande.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Negativo Hombre")
	public void testMetabolismoBasalNegativoHombre() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(1, 1, 'h', 30),
		"El metabolismo basal es cero o menor que cero.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Negativo Mujer")
	public void testMetabolismoBasalNegativoMujer() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(1, 1, 'm', 45),
		"El metabolismo basal es cero o menor que cero.");
	}

	@Test
	@DisplayName("Test Género No Válido")
	public void testGeneroNoValido2() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(70, 163, 'w', 21),
		"Los valores posibles para el género son: 'h' (hombre) o 'm' (mujer).");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Mujer")
	public void testMetabolismoBasalMujer() throws Exception {
		int altura = 180;
		float peso = 60;
		int edad = 20;
		char genero = 'm';
		float basalMetabolic = 10 * peso + 6.25f * altura - 5 * edad - 161;
		assertEquals(basalMetabolic, calc.basalMetabolicRate(peso, altura, genero, edad),
		"El cálculo del metabolismo basal de esta mujer no es correcto.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Hombre")
	public void testMetabolismoBasalHombre() throws Exception {
		int altura = 180;
		float peso = 60;
		int edad = 20;
		char genero = 'h';
		float basalMetabolic = 10 * peso + 6.25f * altura - 5 * edad + 5;
		assertEquals(basalMetabolic, calc.basalMetabolicRate(peso, altura, genero, edad),
		"El cálculo del metabolismo basal de este hombre no es correcto.");
	}

}
