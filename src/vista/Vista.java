package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Vista {

	private JFrame frame;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	private JTextField textFieldEdad;
	private JComboBox<String> comboBoxGenero;
	private JTextField textFieldResPesoIdeal;
	private JTextField textFieldResTMB;
	private JButton btnPesoIdeal;
	private JButton btnTMB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					Modelo modelo = new Modelo();
					Controlador controlador = new Controlador(window, modelo);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("CALCULADORA DE SALUD");
		lbl1.setBounds(121, 12, 196, 21);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("INTRODUZCA LOS PAR\u00C1METROS NECESARIOS:");
		lbl2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lbl2.setBounds(20, 45, 380, 14);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("- Peso Ideal: G\u00E9nero y altura.");
		lbl3.setVerticalAlignment(SwingConstants.TOP);
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lbl3.setBounds(28, 63, 380, 21);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("- Tasa metab\u00F3lica basal (TMB): Altura, peso, edad y g\u00E9nero.");
		lbl4.setVerticalAlignment(SwingConstants.TOP);
		lbl4.setHorizontalAlignment(SwingConstants.LEFT);
		lbl4.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lbl4.setBounds(28, 80, 389, 21);
		frame.getContentPane().add(lbl4);
		
		JLabel lblAltura = new JLabel("Altura (cm):");
		lblAltura.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblAltura.setBounds(39, 120, 83, 14);
		frame.getContentPane().add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setVerticalAlignment(SwingConstants.TOP);
		lblPeso.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPeso.setBounds(39, 160, 83, 21);
		frame.getContentPane().add(lblPeso);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblEdad.setBounds(39, 200, 48, 14);
		frame.getContentPane().add(lblEdad);
		
		JLabel lblGenero = new JLabel("G\u00E9nero:");
		lblGenero.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblGenero.setBounds(39, 240, 58, 14);
		frame.getContentPane().add(lblGenero);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textFieldAltura.setBounds(174, 119, 96, 20);
		frame.getContentPane().add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(174, 160, 96, 20);
		frame.getContentPane().add(textFieldPeso);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(174, 199, 96, 20);
		frame.getContentPane().add(textFieldEdad);
		
		comboBoxGenero = new JComboBox<String>();
		comboBoxGenero.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxGenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino"}));
		comboBoxGenero.setBounds(174, 238, 96, 22);
		frame.getContentPane().add(comboBoxGenero);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCm.setBounds(275, 123, 48, 14);
		frame.getContentPane().add(lblCm);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblKg.setBounds(275, 163, 48, 18);
		frame.getContentPane().add(lblKg);
		
		btnPesoIdeal = new JButton("Calcular Peso Ideal");
		btnPesoIdeal.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnPesoIdeal.setBounds(35, 297, 157, 40);
		frame.getContentPane().add(btnPesoIdeal);
		
		btnTMB = new JButton("Calcular TMB");
		btnTMB.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnTMB.setBounds(35, 357, 157, 40);
		frame.getContentPane().add(btnTMB);
		
		textFieldResPesoIdeal = new JTextField();
		textFieldResPesoIdeal.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textFieldResPesoIdeal.setColumns(10);
		textFieldResPesoIdeal.setBounds(244, 309, 96, 20);
		frame.getContentPane().add(textFieldResPesoIdeal);
		
		textFieldResTMB = new JTextField();
		textFieldResTMB.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textFieldResTMB.setColumns(10);
		textFieldResTMB.setBounds(244, 369, 96, 20);
		frame.getContentPane().add(textFieldResTMB);
		
		JLabel lblKcal = new JLabel("kcal/d\u00EDa");
		lblKcal.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblKcal.setBounds(345, 373, 66, 14);
		frame.getContentPane().add(lblKcal);
		
		JLabel lblKg2 = new JLabel("kg");
		lblKg2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblKg2.setBounds(345, 311, 48, 21);
		frame.getContentPane().add(lblKg2);
		
	}
	
	public void addCalcularPesoIdealListener(ActionListener listener) {
		btnPesoIdeal.addActionListener(listener);
	}
	
	public void addCalcularTMBListener(ActionListener listener) {
		btnTMB.addActionListener(listener);
	}
	
	public String getAltura() {
		return textFieldAltura.getText();
	}
	
	public String getPeso() {
		return textFieldPeso.getText();
	}
	
	public String getEdad() {
		return textFieldEdad.getText();
	}
	
	public String getGenero() {
		return comboBoxGenero.getSelectedItem().toString();
	}
	
	public void setResultadoPesoIdeal(String resultado) {
		textFieldResPesoIdeal.setText(resultado);
	}
	
	public void setResultadoTMB(String resultado) {
		textFieldResTMB.setText(resultado);
	}
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(frame, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean validarAltura() {
		try {
			double altura = Double.parseDouble(getAltura());
			return altura > 0;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public boolean validarPeso() {
		try {
			double peso = Double.parseDouble(getPeso());
			return peso > 0;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public boolean validarEdad() {
		try {
			int edad = Integer.parseInt(getEdad());
			return edad > 0;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
