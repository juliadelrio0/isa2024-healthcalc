package modelo;

import hospital.Gender;

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
	
	public double calcularPesoIdeal(double altura, Gender genero) {
		double pesoIdeal = 0.0;
		if (genero == Gender.MALE) {
			pesoIdeal = altura - 100 - ((altura - 150) / 4);
		} else if (genero == Gender.FEMALE) {
			pesoIdeal = altura - 100 - ((altura - 150) / 2.5);
		}
		return pesoIdeal;
	}
	
	public double calcularTMB(double peso, double altura, int edad, Gender genero) {
		double tmb = 0.0;
		if (genero == Gender.MALE) {
			tmb = (10 * peso) + (6.25 * altura) - (5 * edad) + 5;
		} else if (genero == Gender.FEMALE) {
			tmb = (10 * peso) + (6.25 * altura) - (5 * edad) - 161;
		}
		return tmb;
	}

}