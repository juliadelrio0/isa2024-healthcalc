package healthcalc;

public interface HealthCalc {
	
	public float idealWeight(int height, Gender gender) throws Exception;

	public float basalMetabolicRate(float weight, int height, Gender gender, int age) throws Exception;
}
