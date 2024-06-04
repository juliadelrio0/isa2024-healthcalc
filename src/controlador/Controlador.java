package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.Vista;
import hospital.Gender;
import hospital.PersonImpl;

public class Controlador {
	
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = Modelo.getInstancia();
		this.vista.addCalcularPesoIdealListener(new CalcularPesoIdealListener());
		this.vista.addCalcularTMBListener(new CalcularTMBListener());
	}
	
	class CalcularPesoIdealListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (vista.validarAltura()) {
				Gender genero = vista.getGenero();
				double altura = Double.parseDouble(vista.getAltura());
				PersonImpl person = new PersonImpl((float) altura, genero);
				double PesoIdeal;
				try {
					PesoIdeal = modelo.getIdealBodyWeight(person);
					vista.setResultadoPesoIdeal(String.format("%.2f", PesoIdeal));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
				Gender genero = vista.getGenero();
				PersonImpl person = new PersonImpl((float) peso, (float) altura, edad, genero);
				double tmb;
				try {
					tmb = modelo.basalMetabolicRate(person);
					vista.setResultadoTMB(String.format("%.2f", tmb));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				vista.mostrarError("Por favor, introduzca valores válidos para peso, altura y/o edad.");
			}
		}
	}

}