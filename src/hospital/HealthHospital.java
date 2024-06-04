package hospital;

public interface HealthHospital {
    public double bmr(Gender genero, int edad, float altura, int peso);
    public int pesoIdeal(Gender genero, float altura);
}
