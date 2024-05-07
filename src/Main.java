import java.awt.EventQueue;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modelo modelo = new Modelo();
					Vista vista = new Vista();
					Controlador controlador = new Controlador(vista, modelo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}