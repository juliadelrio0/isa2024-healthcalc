package hospital;

import modelo.Modelo;

public class HealthHospitalAdapter implements HealthHospital {
	
	private Modelo modelo;
	
	public HealthHospitalAdapter() {
		modelo = Modelo.getInstancia();
	}
	
	public double bmr(char genero, int edad, float altura, int peso) {
		float alturaCM = altura*100;
		float pesoKG = peso/1000;
		String generoStr = (genero == 'M') ? "Masculino" : "Femenino";
		return modelo.calcularTMB(pesoKG, alturaCM, edad, generoStr);
	}
	
	public int pesoIdeal(char genero, float altura) {
		float alturaCM = altura*100;
		String generoStr = (genero == 'M') ? "Masculino" : "Femenino";
		return (int) modelo.calcularPesoIdeal(alturaCM, generoStr);
	}

}
