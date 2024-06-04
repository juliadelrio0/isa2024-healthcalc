package hospital;

import modelo.Modelo;

public class HealthCalculator implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthCalculator() {
		this.modelo = Modelo.getInstancia();
	}
	
	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) {
		return modelo.calcularTMB(peso/1000, altura*100, edad, genero);
	}
	@Override
	public int pesoIdeal(Gender genero, float altura) {
		return (int) modelo.calcularPesoIdeal(altura*100, genero);
	}

}