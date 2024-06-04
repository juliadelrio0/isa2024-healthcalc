package hospital;

import modelo.Modelo;

public class HealthHospitalAdapter implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthHospitalAdapter() {
		modelo = Modelo.getInstancia();
	}
	
	public double bmr(Gender genero, int edad, float altura, int peso) {
		float alturaCM = altura*100;
		float pesoKG = peso/1000;
		return modelo.calcularTMB(pesoKG, alturaCM, edad, genero);
	}
	
	public int pesoIdeal(Gender genero, float altura) {
		float alturaCM = altura*100;
		return (int) modelo.calcularPesoIdeal(alturaCM, genero);
	}

}