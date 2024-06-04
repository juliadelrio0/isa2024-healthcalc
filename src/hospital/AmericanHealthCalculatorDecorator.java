package hospital;

public class AmericanHealthCalculatorDecorator extends HealthCalculator {
	
	public int pesoIdeal(Gender genero, float altura) {
		return super.pesoIdeal(genero, altura);
	}
	
	public double bmr(Gender genero, int edad, float altura, int peso) {
		float alturaM = altura*0.3048f;
		int pesoKG = (int) (peso*0.453592);
		double bmr = super.bmr(genero, edad, alturaM, pesoKG);
		System.out.println(String.format("La persona con altura %.2f pies y %d libras tiene un BMR de %.2f kcal/día.", altura, peso, bmr));
		System.out.println(String.format("The person with height %.2f feet and %d pounds has a BMR of %.2f kcal/day.", altura, peso, bmr));
        return bmr;
	}

}