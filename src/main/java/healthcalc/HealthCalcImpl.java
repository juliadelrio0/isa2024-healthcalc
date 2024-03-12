package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser un número positivo.");
        } if (height >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("El valor de la altura es demasiado grande.");
        } if (Character.toLowerCase(gender) != 'h' && Character.toLowerCase(gender) != 'm') {
            throw new IllegalArgumentException("Los valores posibles de género son: 'h' (hombre) o 'm' (mujer).");
        } if (Character.toLowerCase(gender) == 'h') {
            float pesoIdeal = height - 100 - (height -150) / 4f;
            if (pesoIdeal > 0) {
                return pesoIdeal;
            } else {
                throw new IllegalArgumentException("El género debe ser 'h' para hombre o 'm' para mujer.");
            }
        } else {
            float pesoIdeal = height - 100 - (height - 150) / 2.5f;
            if (pesoIdeal > 0) {
                return pesoIdeal;
            } else {
                throw new IllegalArgumentException("El peso ideal es erróneo puesto que es cero o menor que cero.");
            }
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
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
        } if (Character.toLowerCase(gender) != 'h' && Character.toLowerCase(gender) != 'm') {
            throw new IllegalArgumentException("El género debe ser 'h' para hombre o 'm' para mujer.");
        } if (Character.toLowerCase(gender) == 'h') {
            float basalMetabolic = 10 * weight + 6.25f * height - 5 * age + 5;
            if (basalMetabolic > 0) {
                return basalMetabolic;
            } else {
                throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
            }
        } else {
            float basalMetabolic = 10 * weight + 6.25f * height - 5 * age -161;
            if (basalMetabolic > 0) {
                return basalMetabolic;
            } else {
                throw new IllegalArgumentException("El metabolismo basal es cero o menor que cero.");
            }
        }
    }

}
