package ec.edu.ups.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.negocio.LibrosONRemoto;
import ec.edu.ups.utilidades.conexionRemoto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jboss.as.controller.operations.global.ListOperations.ListAddHandler;
import org.jboss.as.server.operations.SystemPropertyValueWriteAttributeHandler.SysPropValue;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtanio;
	private JTextField txtNombre;
	private JTable table;
	JComboBox cmbAutor = new JComboBox();
	
	private JScrollPane scrollPane;
	private JTextField txtxBus;
	private JLabel lblRe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					conexionRemoto cr = new conexionRemoto();
					LibrosONRemoto contactoEJBCliente = cr.intanciarEJBTelRemoto();
					Vista frame = new Vista();
					frame.setVisible(true);
					
					
//					Libro l = new Libro();
//					l.setAniopublicacion("12/02/1998");
//					l.setCodigo("42");
//					l.setNombre("Vuelta al mundo en 80 dias");
//					
//					ArrayList<Detalle> libroDet = new ArrayList<Detalle>();
//					for (int i = 0; i < 2; i++) {
//						Detalle det= new Detalle();
//						det.setVolumen("Volumen 1");
//						det.setLibro(l);
//						libroDet.add(det);
//					}
//					
//					contactoEJBCliente.guardarLibro(libroDet);
					
					//List <Detalle> listaLe=ejbLocal.getDetalles(123);
//					for (Libro detalle : contactoEJBCliente.getDetalles("20")) {
//						System.out.println("libro es: "+detalle.getNombre() +" -Anio " + detalle.getAniopublicacion());
//					}
					
				
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	void cargarTabla() {
		conexionRemoto cr = new conexionRemoto();
		LibrosONRemoto contactoEJBCliente;
		try {
			contactoEJBCliente = cr.intanciarEJBTelRemoto();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			ArrayList<Autor> lista = (ArrayList<Autor>) contactoEJBCliente.getAutoresAll();
			TableColumn columna =table.getColumnModel().getColumn(0);
			for (Autor autor : lista) {
				System.out.println("aqui----->" +autor.getNombre());
				cmbAutor.addItem(""+autor.getId()+"-"+autor.getNombre().toString());
				columna.setCellEditor(new DefaultCellEditor(cmbAutor));
				model.addRow(new Object[] {cmbAutor});
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}
	
	void cargarCombo() {
		//cmbAutor.addItem(item);
	}
	
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(128, 55, 197, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtanio = new JTextField();
		txtanio.setColumns(10);
		txtanio.setBounds(128, 90, 197, 22);
		contentPane.add(txtanio);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(128, 125, 197, 22);
		contentPane.add(txtNombre);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(12, 58, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnioPublicacion = new JLabel("Anio Publicacion");
		lblAnioPublicacion.setBounds(12, 90, 97, 22);
		contentPane.add(lblAnioPublicacion);
		
		JLabel lblNombreLibro = new JLabel("Nombre Libro");
		lblNombreLibro.setBounds(12, 129, 77, 16);
		contentPane.add(lblNombreLibro);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 198, 468, 95);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Autor"
			}
		));
		
		JButton btnGuardar = new JButton("ok");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionRemoto cr = new conexionRemoto();
				LibrosONRemoto contactoEJBCliente;
				try {
					contactoEJBCliente = cr.intanciarEJBTelRemoto();
					Libro l = new Libro();
					l.setAniopublicacion(txtanio.getText());
					l.setCodigo(txtCodigo.getText());
					l.setNombre(txtNombre.getText());
					
					ArrayList<Detalle> libroDet = new ArrayList<Detalle>();
					for (int i = 0; i < table.getRowCount(); i++) {
						if ( table.getValueAt(i, 0) != null) {
							try {
								String aux= (String) table.getValueAt(i, 0);
								if(aux!=null) {
									String aux_id= aux.substring(0, aux.indexOf('-'));
									//System.out.println(">>>>" + aux);
									Detalle det= new Detalle();
									det.setVolumen("Volumen 1");
									det.setFk_autor(Integer.valueOf(aux_id));
									det.setLibro(l);
									libroDet.add(det);
								}
							} catch (Exception e2) {
								System.out.println("no entro >>>> ");
							}
						
							
						
					  }
						else {
							System.out.println("no entro >>>> ");
						}
					}
//					for (Detalle detalle : libroDet) {
//						System.out.println(">>>>>> FK Autor "+detalle.getFk_autor()+" NOmbre Libro "+detalle.getLibro().getNombre());
//					}
					
					contactoEJBCliente.guardarLibro(libroDet);
					System.out.println("Se guardo con exito!!!!!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
				
				
			}
		});
		btnGuardar.setBounds(228, 369, 97, 25);
		contentPane.add(btnGuardar);
		
		
		cmbAutor.setBounds(400, 90, 129, 22);
		
		contentPane.add(cmbAutor);
		
		txtxBus = new JTextField();
		txtxBus.setBounds(700, 68, 116, 22);
		contentPane.add(txtxBus);
		txtxBus.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setBounds(630, 71, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionRemoto cr = new conexionRemoto();
				LibrosONRemoto contactoEJBCliente;
				try {
					contactoEJBCliente = cr.intanciarEJBTelRemoto();
					for (Libro detalle : contactoEJBCliente.getDetalles(txtxBus.getText())) {
						lblRe.setText("libro es: "+detalle.getNombre() +" -Anio " + detalle.getAniopublicacion() + "-Autor "+detalle.getDetalle().get(0).getFk_autor());
						System.out.println("libro es: "+detalle.getNombre() +" -Anio " + detalle.getAniopublicacion()+ " Autor "+detalle.getDetalle().get(0).getFk_autor()+" - "+detalle.getDetalle().get(1).getFk_autor());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(719, 146, 97, 25);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(612, 224, 291, 148);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblRe = new JLabel("..");
		lblRe.setBounds(12, 13, 267, 122);
		panel.add(lblRe);
		lblRe.setBackground(new Color(128, 128, 128));
		
		
		cargarTabla();
		
		
	}
}
