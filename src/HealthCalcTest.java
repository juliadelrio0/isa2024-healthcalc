import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hospital.Gender;
import hospital.HealthCalculator;
import hospital.Person;
import hospital.PersonImpl;
import modelo.Modelo;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

    private final Modelo calc = Modelo.getInstancia();

    // Tests mÈtodo 'Modelo.getIdealBodyWeight'
    
    @Test
    @DisplayName("Test Altura Negativa")
    public void testAlturaNegativa() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.getIdealBodyWeight(new PersonImpl(-8, Gender.MALE)),
        "La altura no puede ser un n˙mero negativo.");
    }

    @Test
    @DisplayName("Test Altura Cero")
    public void testAlturaCero() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.getIdealBodyWeight(new PersonImpl(0, Gender.MALE)),
        "La altura no puede ser cero.");
    }

    @Test
    @DisplayName("Test Peso Ideal Negativo")
    public void testPesoIdealNegativo() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.getIdealBodyWeight(new PersonImpl(0, 50, 0, Gender.MALE)),
        "El peso tiene que ser un valor positivo.");
    }

    @Test
    @DisplayName("Test Altura M·xima Permitida")
    public void testAlturaMaximaPermitida() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.getIdealBodyWeight(new PersonImpl(0, Integer.MAX_VALUE, 0, Gender.MALE)),
        "El valor de altura introducido es demasiado grande.");
    }

    @Test
    @DisplayName("Test GÈnero No V·lido")
    public void testGeneroNoValido() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.getIdealBodyWeight(new PersonImpl(0, 180, 0, null)),
        "Los valores posibles de gÈnero son: MALE o FEMALE.");
    }

    @Test
    @DisplayName("Test Peso Ideal Hombre")
    public void testPesoIdealHombre() throws Exception {
        int altura = 180;
        Gender genero = Gender.MALE;
        float pesoIdeal = altura - 100 - (altura - 150) / 4f;
        assertEquals(pesoIdeal, calc.getIdealBodyWeight(new PersonImpl(0, altura, 0, genero)),
        "El c·lculo no es correcto.");
    }

    @Test
    @DisplayName("Test Peso Ideal Mujer")
    public void testPesoIdealMujer() throws Exception {
        int altura = 190;
        Gender genero = Gender.FEMALE;
        float pesoIdeal = altura - 100 - (altura - 150) / 2.5f;
        assertEquals(pesoIdeal, calc.getIdealBodyWeight(new PersonImpl(0, altura, 0, genero)),
        "El c·lculo no es correcto.");
    }

    // Tests mÈtodo 'Modelo.basalMetabolicRate'
    
    @Test
    @DisplayName("Test Altura Negativa")
    public void testAlturaNegativa2() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.basalMetabolicRate(new PersonImpl(70, -10, 21, Gender.FEMALE)),
        "La altura debe ser un n˙mero positivo.");
    }

    @Test
    @DisplayName("Test Altura Cero")
    public void testAlturaCero2() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.basalMetabolicRate(new PersonImpl(70, 0, 21, Gender.FEMALE)),
        "La altura no puede valer cero.");
    }

    @Test
    @DisplayName("Test Peso Negativo")
    public void testPesoNegativo() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.basalMetabolicRate(new PersonImpl(-1, 163, 21, Gender.FEMALE)),
        "El valor del peso debe ser positivo.");
    }

    @Test
    @DisplayName("Test Edad Negativa")
    public void testEdadNegativa() {
        assertThrows(IllegalArgumentException.class,
        () -> calc.basalMetabolicRate(new PersonImpl(70, 163, -1, Gender.FEMALE)),
        "La edad debe ser un n˙mero positivo.");
    }

    @Test
	@DisplayName("Test Peso Cero")
	public void testPesoCero() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(0, 163, 21, Gender.FEMALE)),
		"El peso no puede ser cero.");
	}

	@Test
	@DisplayName("Test Edad Cero")
	public void testEdadCero() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(70, 163, 0, Gender.FEMALE)),
		"La edad no puede valer cero.");
	}

	@Test
	@DisplayName("Test Altura M·xima Permitida")
	public void testAlturaMaximaPermitida2() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(70, Integer.MAX_VALUE, 21, Gender.FEMALE)),
		"El valor de la altura es demasiado grande.");
	}

	@Test
	@DisplayName("Test Peso M√°ximo Permitido")
	public void testPesoMaximoPermitido() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(Float.MAX_VALUE, 163, 21, Gender.FEMALE)),
		"El valor del peso es demasiado grande.");
	}

	@Test
	@DisplayName("Test Edad M√°xima Permitida")
	public void testEdadMaximaPermitida() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(70, 163, Integer.MAX_VALUE, Gender.FEMALE)),
		"El valor de la edad es demasiado grande.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Negativo Hombre")
	public void testMetabolismoBasalNegativoHombre() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(1, 1, 30, Gender.MALE)),
		"El metabolismo basal es cero o menor que cero.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Negativo Mujer")
	public void testMetabolismoBasalNegativoMujer() {
		assertThrows(IllegalArgumentException.class,
		() -> calc.basalMetabolicRate(new PersonImpl(1, 1, 45, Gender.FEMALE)),
		"El metabolismo basal es cero o menor que cero.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Mujer")
	public void testMetabolismoBasalMujer() throws Exception {
		int altura = 180;
		float peso = 60;
		int edad = 20;
		Gender genero = Gender.FEMALE;
		float basalMetabolic = 10 * peso + 6.25f * altura - 5 * edad - 161;
		assertEquals(basalMetabolic, calc.basalMetabolicRate(new PersonImpl(peso, altura, edad, genero)),
		"El c√°lculo del metabolismo basal de esta mujer no es correcto.");
	}

	@Test
	@DisplayName("Test Metabolismo Basal Hombre")
	public void testMetabolismoBasalHombre() throws Exception {
		int altura = 180;
		float peso = 60;
		int edad = 20;
		Gender genero = Gender.MALE;
		float basalMetabolic = 10 * peso + 6.25f * altura - 5 * edad + 5;
		assertEquals(basalMetabolic, calc.basalMetabolicRate(new PersonImpl(peso, altura, edad, genero)),
		"El c√°lculo del metabolismo basal de este hombre no es correcto.");
	}

}
