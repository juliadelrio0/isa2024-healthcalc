package modelo;

public class Modelo {
	
	public double calcularPesoIdeal(double altura, String genero) {
		double pesoIdeal = 0.0;
		if (genero.equals("Masculino")) {
			pesoIdeal = altura - 100 - ((altura - 150) / 4);
		} else if (genero.equals("Femenino")) {
			pesoIdeal = altura - 100 - ((altura - 150) / 2.5);
		}
		return pesoIdeal;
	}
	
	public double calcularTMB(double peso, double altura, int edad, String genero) {
		double tmb = 0.0;
		if (genero.equals("Masculino")) {
			tmb = (10 * peso) + (6.25 * altura) - (5 * edad) + 5;
		} else if (genero.equals("Femenino")) {
			tmb = (10 * peso) + (6.25 * altura) - (5 * edad) - 161;
		}
		return tmb;
	}

}
