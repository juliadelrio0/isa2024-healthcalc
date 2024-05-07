package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
	
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = new Modelo();
		this.vista.addCalcularPesoIdealListener(new CalcularPesoIdealListener());
		this.vista.addCalcularTMBListener(new CalcularTMBListener());
	}
	
	class CalcularPesoIdealListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (vista.validarAltura()) {
				String genero = vista.getGenero();
				double altura = Double.parseDouble(vista.getAltura());
				double PesoIdeal = modelo.calcularPesoIdeal(altura, genero);
				vista.setResultadoPesoIdeal(String.format("%.2f", PesoIdeal, null));
			} else {
				vista.mostrarError("Por favor, introduzca valores válidos para peso y/o altura.");
			}
		}
	}
	
	class CalcularTMBListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (vista.validarAltura() && vista.validarPeso() && vista.validarEdad()) {
				double peso = Double.parseDouble(vista.getPeso());
				double altura = Double.parseDouble(vista.getAltura());
				int edad = Integer.parseInt(vista.getEdad());
				String genero = vista.getGenero();
				double tmb = modelo.calcularTMB(peso, altura, edad, genero);
				vista.setResultadoTMB(String.format("%.2f", tmb));
			} else {
				vista.mostrarError("Por favor, introduzca valores válidos para peso, altura y/o edad.");
			}
		}
	}

}
