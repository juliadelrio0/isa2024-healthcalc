package hospital;

import modelo.Modelo;

public class HealthCalculator implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthCalculator() {
		this.modelo = Modelo.getInstancia();
	}
	
	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) {
		PersonImpl person = new PersonImpl((float) altura*100, (float) peso/1000, edad, genero);
		return modelo.calcularTMB(person);
	}
	@Override
	public int pesoIdeal(Gender genero, float altura) {
		PersonImpl person = new PersonImpl((float) altura*100, genero);
		return (int) modelo.calcularPesoIdeal(person);
	}

}