package hospital;

import modelo.Modelo;

public class HealthCalculator implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthCalculator() {
		this.modelo = Modelo.getInstancia();
	}
	
	@Override
	public double bmr(char genero, int edad, float altura, int peso) {
		return modelo.calcularTMB(peso/1000, altura*100, edad, (genero == 'M') ? "Masculino" : "Femenino");
	}
	@Override
	public int pesoIdeal(char genero, float altura) {
		return (int) modelo.calcularPesoIdeal(altura*100, (genero == 'M') ? "Masculino" : "Feminino");
	}

}
