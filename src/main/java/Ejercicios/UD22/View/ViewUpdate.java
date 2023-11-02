package Ejercicios.UD22.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Controller.ControllerCliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfAdress;
	private JTextField tfDni;
	private JTextField tfDate;
	private JButton btnUpdate;
	
	private ControllerCliente controllerCliente ;

	/**
	 * Create the frame.
	 */
	public ViewUpdate(int clienteId, ControllerCliente controllerCliente, ConnectionSQL connection, 
			ViewDB viewDB) {
		
		this.controllerCliente = new ControllerCliente(connection);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 21, 31, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 53, 61, 24);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(10, 88, 61, 24);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 123, 61, 24);
		contentPane.add(lblDireccion);
		
		JLabel lblDni = new JLabel("dni:");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setBounds(10, 158, 61, 24);
		contentPane.add(lblDni);
		
		JLabel lblFecha = new JLabel("fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(10, 193, 61, 24);
		contentPane.add(lblFecha);
		
		tfId = new JTextField();
		tfId.setBounds(74, 23, 350, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(74, 53, 350, 20);
		contentPane.add(tfName);
		
		tfSurname = new JTextField();
		tfSurname.setColumns(10);
		tfSurname.setBounds(74, 88, 350, 20);
		contentPane.add(tfSurname);
		
		tfAdress = new JTextField();
		tfAdress.setColumns(10);
		tfAdress.setBounds(74, 125, 350, 20);
		contentPane.add(tfAdress);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(74, 160, 350, 20);
		contentPane.add(tfDni);
		
		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(74, 195, 350, 20);
		contentPane.add(tfDate);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setBounds(177, 226, 96, 24);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					updateFields();
					JOptionPane.showMessageDialog(null, "Cliente updated");
					dispose();
					
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
	//FUNCTION TO GET DATA FROM TEXTFIELD AND UPDATE THEM
	public void updateFields() throws SQLException, ParseException {
		
		int clienteId = getClienteId();
		String nombre = getNombre();
		String apellido = getApellido();
		String direccion = getDireccion();
		int dni = getDni();
		Date fecha = getFecha();
		
		controllerCliente.updateCliente(clienteId, nombre, apellido, direccion, dni, fecha);
	}
	
	public int getClienteId() throws SQLException {
		
		return Integer.parseInt(tfId.getText());
	}
	
	public String getNombre() {
		
		return tfName.getText();
	}
	
	public String getApellido() {
		
		return tfSurname.getText();
	}
	
	public String getDireccion() {
		
		return tfAdress.getText();
	}
	
	public int getDni() {
		
		return Integer.parseInt(tfDni.getText());
	}
	
	public Date getFecha() throws ParseException {
		
	    String dateText = tfDate.getText();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date parsedDate = dateFormat.parse(dateText);
	    
	    return new Date(parsedDate.getTime());
	}
	
}
