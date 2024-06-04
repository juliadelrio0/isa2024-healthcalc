package modelo;

import hospital.Gender;
import hospital.Person;

public class Modelo {

	private static Modelo instancia;

	private Modelo() {

	}

	public static Modelo getInstancia() {
		if (instancia == null) {
			instancia = new Modelo();
		}
		return instancia;
	}
	
	public double calcularPesoIdeal(Person person) {
		double pesoIdeal = 0.0;
		if (person.gender() == Gender.MALE) {
			pesoIdeal = person.height() - 100 - ((person.height() - 150) / 4);
		} else if (person.gender() == Gender.FEMALE) {
			pesoIdeal = person.height() - 100 - ((person.height() - 150) / 2.5);
		}
		return pesoIdeal;
	}
	
	public double calcularTMB(Person person) {
		double tmb = 0.0;
		if (person.gender() == Gender.MALE) {
			tmb = (10 * person.weight()) + (6.25 * person.height()) - (5 * person.age()) + 5;
		} else if (person.gender() == Gender.FEMALE) {
			tmb = (10 * person.weight()) + (6.25 * person.height()) - (5 * person.age()) - 161;
		}
		return tmb;
	}

}