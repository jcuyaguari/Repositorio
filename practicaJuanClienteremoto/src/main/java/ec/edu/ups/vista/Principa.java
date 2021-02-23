package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.modelo.Consultorio;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.negocios.HospitalOnRemoto;
import ec.edu.ups.utilidades.Conexionsrv;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Principa extends JFrame {
	
	public Conexionsrv co;
			
	private JPanel contentPane;
	private JTextField txtNumConsult;
	private JTextField txtPiso;
	private JTable jtableMedicos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principa frame = new Principa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principa() {
		co = new Conexionsrv();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNumConsult = new JTextField();
		txtNumConsult.setBounds(237, 13, 116, 22);
		contentPane.add(txtNumConsult);
		txtNumConsult.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Num Consultorio");
		lblNewLabel.setBounds(80, 16, 106, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblDireccionHospital = new JLabel("Piso");
		lblDireccionHospital.setBounds(80, 67, 106, 16);
		contentPane.add(lblDireccionHospital);
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(237, 64, 116, 22);
		contentPane.add(txtPiso);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					List<Medico>listamedico = new ArrayList<Medico>();
					HospitalOnRemoto hospitalremoto = co.intanciarONRemoto();
					Consultorio c = new Consultorio();
					
					c.setNumeroConsultorio(txtNumConsult.getText());
					c.setPiso(Integer.parseInt(txtPiso.getText()));
					
					for (int i = 0; i < jtableMedicos.getRowCount(); i++) {
						try {
						Medico m = new Medico();
						m.setCedula(jtableMedicos.getValueAt(i, 0).toString());
						m.setNombre(jtableMedicos.getValueAt(i, 1).toString());
						m.setEspecialidad(jtableMedicos.getValueAt(i, 2).toString());
						listamedico.add(m);
						c.setListaMedicos(listamedico);
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					
					hospitalremoto.guardarHospital(c);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		});
		btnGuardar.setBounds(271, 256, 97, 25);
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 124, 487, 98);
		contentPane.add(scrollPane);
		
		jtableMedicos = new JTable();
		scrollPane.setViewportView(jtableMedicos);
		jtableMedicos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Cedula", "nombre", "Especialidad"
			}
		));
	}
}
