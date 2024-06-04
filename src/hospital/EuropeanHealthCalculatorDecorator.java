package hospital;

public class EuropeanHealthCalculatorDecorator extends HealthCalculator {
	
	public int pesoIdeal(Gender genero, float altura) {
		return super.pesoIdeal(genero, altura);
	}
	
	public double bmr(Gender genero, int edad, float altura, int peso) {
		double bmr = super.bmr(genero, edad, altura, peso);
		System.out.println(String.format("La persona con altura %.2f metros y %d kg tiene un BMR de %.2f kcal/día.", altura, peso/1000, bmr));
		System.out.println(String.format("The person with height %.2f meters and %d kg has a BMR of %.2f kcal/day.", altura, peso/1000, bmr));
		return bmr;
	}

}