package modelo;

import hospital.CardiovascularMetrics;
import hospital.Gender;
import hospital.MetabolicMetrics;
import hospital.Person;

public class Modelo implements CardiovascularMetrics, MetabolicMetrics {

	private static Modelo instancia;

	private Modelo() {

	}

	public static Modelo getInstancia() {
		if (instancia == null) {
			instancia = new Modelo();
		}
		return instancia;
	}
	
	public double getIdealBodyWeight(Person person) throws Exception {
		double pesoIdeal = 0.0;
		switch (person.gender()) {
        case MALE:
            pesoIdeal = (person.height() - 100) - ((person.height() - 150) / 4d);
            break;
        case FEMALE:
            pesoIdeal = (person.height() - 100) - ((person.height() - 150) / 2.5d);
            break;
        default:
            throw new Exception("Género no válido");
		}
        return pesoIdeal;
	}
	
	public double basalMetabolicRate(Person person) throws Exception {
		double tmb = 0.0;
		switch (person.gender()) {
        case MALE:
            tmb = 10 * person.weight() + 6.25d * person.height() - 5 * person.age() + 5;
            break;
        case FEMALE:
            tmb = 10 * person.weight() + 6.25d * person.height() - 5 * person.age() - 161;
            break;
        default:
            throw new Exception("Género no válido");
		}
		return tmb;
	}

}