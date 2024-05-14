package hospital;

import java.util.ArrayList;
import java.util.List;
import modelo.Modelo;

public class HealthStatsProxy implements HealthStats {
	
	private Modelo modelo;
	private List<String> generos;
	private List<Float> alturas;
	private List<Integer> edades;
	private List<Integer> pesos;
	
	public HealthStatsProxy() {
		modelo = Modelo.getInstancia();
		generos = new ArrayList<>();
		alturas = new ArrayList<>();
		edades = new ArrayList<>();
		pesos = new ArrayList<>();
	}
	
	public float alturaMedia() {
		float suma = 0;
		for (Float altura : alturas) {
			suma += altura;
		}
		return suma/alturas.size();
	}
	
	public float pesoMedio() {
		float suma = 0;
		for (Integer peso : pesos) {
			suma += peso;
		}
		suma = suma/1000;
		return suma/pesos.size();
	}
	
	public float edadMedia() {
		float suma = 0;
		for (Integer edad : edades) {
			suma += edad;
		}
		return suma/edades.size();
	}
	
	public float bmrMedio() {
		float suma = 0;
		for (int i = 0; i < generos.size(); i++) {
			suma += modelo.calcularTMB(pesos.get(i)/1000, alturas.get(i)*100, edades.get(i), generos.get(i));
		}
		return suma/generos.size();
	}
	
	public int numSexoH() {
		int cont = 0;
		for (String genero : generos) {
			if (genero.equals("Masculino")) {
				cont++;
			}
		}
		return cont;
	}
	
	public int numSexoM() {
		int cont = 0;
		for (String genero : generos) {
			if (genero.equals("Femenino")) {
				cont++;
			}
		}
		return cont;
	}
	
	public int numTotalPacientes() {
		return generos.size();
	}
	
	public void agregarPaciente(String genero, float altura, int edad, int peso) {
		generos.add(genero);
		alturas.add(altura);
		edades.add(edad);
		pesos.add(peso);
	}
	
}