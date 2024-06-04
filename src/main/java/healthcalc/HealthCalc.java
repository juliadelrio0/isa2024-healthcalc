package healthcalc;

public interface HealthCalc {
	
	public float idealWeight(int height, char gender) throws Exception;

	public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception;
}
