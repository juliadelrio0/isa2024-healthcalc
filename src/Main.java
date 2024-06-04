import hospital.AmericanHealthCalculatorDecorator;
import hospital.EuropeanHealthCalculatorDecorator;
import hospital.Gender;
import hospital.HealthCalculator;
import hospital.HealthHospital;
import hospital.HealthHospitalAdapter;
import hospital.HealthStats;
import hospital.HealthStatsProxy;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// APARTADO A
		
		System.out.println("APARTADO A");
		
		HealthHospital adapter = new HealthHospitalAdapter();
				
		double tmb1 = adapter.bmr(Gender.FEMALE, 30, 1.75f, 75000);
		int pesoIdeal1 = adapter.pesoIdeal(Gender.FEMALE, 1.75f);
		System.out.println("Paciente 1:");
		System.out.println("    TMB: " + tmb1 + " kcal/día");
		System.out.println("    Peso ideal: " + pesoIdeal1 + " kg");
		
		double tmb2 = adapter.bmr(Gender.FEMALE, 21, 1.62f, 70000);
		int pesoIdeal2 = adapter.pesoIdeal(Gender.FEMALE, 1.62f);
		System.out.println("Paciente 2:");
		System.out.println("    TMB: " + tmb2 + " kcal/día");
		System.out.println("    Peso ideal: " + pesoIdeal2 + " kg");
		
		double tmb3 = adapter.bmr(Gender.MALE, 55, 1.81f, 95000);
		int pesoIdeal3 = adapter.pesoIdeal(Gender.MALE, 1.81f);
		System.out.println("Paciente 3:");
		System.out.println("    TMB: " + tmb3 + " kcal/día");
		System.out.println("    Peso ideal: " + pesoIdeal3 + " kg");
			
		
		// APARTADO B
		
		System.out.println("\nAPARTADO B");

		HealthStatsProxy proxy = new HealthStatsProxy();
		
		proxy.agregarPaciente(Gender.FEMALE, 1.75f, 30, 75000);
		proxy.agregarPaciente(Gender.FEMALE, 1.62f, 21, 70000);
		proxy.agregarPaciente(Gender.MALE, 1.81f, 55, 95000);
		
		System.out.println("Cálculo de las medias de todos los datos:");
		System.out.println("    Altura media: " + proxy.alturaMedia() + " m");
		System.out.println("    TMB medio: " + proxy.bmrMedio() + " kcal/día");
		System.out.println("    Edad media: " + proxy.edadMedia());
		System.out.println("    Número de pacientes de sexo masculino: " + proxy.numSexoH());
		System.out.println("    Número de pacientes de sexo femenino: " + proxy.numSexoM());
		System.out.println("    Número total de pacientes: " + proxy.numTotalPacientes());
		System.out.println("    Peso medio: " + proxy.pesoMedio() + " kg");
        
        
        // APARTADO C
        
		System.out.println("\nAPARTADO C");
		
		HealthHospital europeanCalculator = new EuropeanHealthCalculatorDecorator();
		HealthHospital americanCalculator = new AmericanHealthCalculatorDecorator();
		
		double bmrEuropeo = europeanCalculator.bmr(Gender.FEMALE, 21, 1.62f, 70000);
		double bmrAmericano = americanCalculator.bmr(Gender.FEMALE, 21, 5.74f, 154);
		
	}
}