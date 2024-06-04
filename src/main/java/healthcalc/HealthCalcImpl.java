package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, Gender gender) throws Exception {
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un número positivo.");
        } if (height >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("El valor de la altura es demasiado grande.");
        }
        switch (gender) {
            case MALE:
                float pesoIdealH = height - 100 - (height - 150) / 4f;
                return pesoIdealH;
            case FEMALE:
                float pesoIdealM = height - 100 - (height - 150) / 2.5f;
            default:
                throw new IllegalArgumentException("Género no válido.");
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, Gender gender, int age) throws Exception {
        if (weight <= 0) {
            throw new IllegalArgumentException("El peso debe ser positivo.");
        } if (weight >= Float.MAX_VALUE) {
            throw new IllegalArgumentException("El valor del peso es demasiado grande.");
        } if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un valor positivo.");
        } if (height >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("El valor de la altura proporcionada es demasiado grande.");
        } if (age <= 0) {
            throw new IllegalArgumentException("El valor de la edad no puede ser cero ni menor que cero.");
        } if (age >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("El valor de la edad es demasiado grande.");
        }
        switch (gender) {
            case MALE:
                float bmrH = 10*weight + 6.25f*height - 5*age + 5;
                return bmrH;
            case FEMALE:
                float bmrM = 10*weight + 6.25f*height - 5*age - 161;
            default:
                throw new IllegalArgumentException("Género no válido.");
        }
    }
}
