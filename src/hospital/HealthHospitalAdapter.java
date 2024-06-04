package hospital;

import modelo.Modelo;

public class HealthHospitalAdapter implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthHospitalAdapter() {
		modelo = Modelo.getInstancia();
	}
	
	public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
		float alturaCM = altura*100;
		float pesoKG = peso/1000;
		return modelo.basalMetabolicRate(new PersonImpl(pesoKG, alturaCM, edad, genero));
	}
	
	public int pesoIdeal(Gender genero, float altura) throws Exception {
		float alturaCM = altura*100;
		return (int) modelo.getIdealBodyWeight(new PersonImpl(alturaCM, genero));
	}

}