package hospital;

public interface HealthStats {
	
	float alturaMedia();
	float pesoMedio();
	float edadMedia();
	float bmrMedio() throws Exception;
	int numSexoH();
	int numSexoM();
	int numTotalPacientes();

}