package hospital;

import modelo.Modelo;

public class HealthCalculator implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthCalculator() {
		this.modelo = Modelo.getInstancia();
	}
	
	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
		PersonImpl person = new PersonImpl((float) altura*100, (float) peso/1000, edad, genero);
		return modelo.basalMetabolicRate(person);
	}
	@Override
	public int pesoIdeal(Gender genero, float altura) throws Exception {
		PersonImpl person = new PersonImpl((float) altura*100, genero);
		return (int) modelo.getIdealBodyWeight(person);
	}

}