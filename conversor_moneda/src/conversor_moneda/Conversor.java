package conversor_moneda;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversor {

	private JFrame frame;
	private JTextField txt;
	private JLabel lbl2;
	private JComboBox cmb;
	private JLabel lbl;
	
	public enum Moneda{
		Pesos_Dolar,
		Pesos_Euro,
		Pesos_Libra,
		Dolar_Pesos,
		Euro_Pesos,
		Libra_Pesos,
	}
	
	public double dolar = 605;
	public double euro = 544.02;
	public double libra = 364.93;
	
	public double valorimput = 0.00;
	public void Convertir() {
		if (Validar(txt.getText())) {
			
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch(moneda) {
			case Pesos_Dolar:
				PesosAMoneda(dolar);
				break;
			case Pesos_Euro:
				PesosAMoneda(euro);
				break;
			case Pesos_Libra:
				PesosAMoneda(libra);
				break;
			case Dolar_Pesos:
				MonedaAPesos(dolar);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
		}

		 }
		}
	
	public void PesosAMoneda(double moneda) {
		double res = valorimput / moneda;
		lbl.setText(Redondear(res));
	}
	
	public void MonedaAPesos (double moneda) {
		double res = valorimput * moneda;
		lbl.setText(Redondear(res));
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x>0);
			valorimput = x;
			return true;
			
		}catch(NumberFormatException e) {
			lbl.setText("Solamente Numeros");
			return false;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
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
	public Conversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn = new JButton("Convertir");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Convertir();
			}
		});
		btn.setBounds(167, 187, 89, 23);
		frame.getContentPane().add(btn);
		
		txt = new JTextField();
		txt.setBounds(51, 83, 139, 20);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		lbl = new JLabel("00.00");
		lbl.setBounds(210, 86, 46, 14);
		frame.getContentPane().add(lbl);
		
		cmb = new JComboBox<Moneda>();
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(51, 128, 139, 22);
		frame.getContentPane().add(cmb);
		
	
		
		lbl2 = new JLabel("Moneda");
		lbl2.setBounds(210, 132, 46, 14);
		frame.getContentPane().add(lbl2);
		
		JLabel lblNewLabel = new JLabel("CONVERSOR REYNOSO");
		lblNewLabel.setFont(new Font("Felix Titling", Font.BOLD, 11));
		lblNewLabel.setBounds(155, 22, 170, 30);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\FLIA REYNOSO QUISPE\\Downloads\\68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f564961774a343445383279546a773d3d2d3439333339373332342e31346635653963316661323831303.jfif"));
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
