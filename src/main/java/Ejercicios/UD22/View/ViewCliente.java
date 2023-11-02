package Ejercicios.UD22.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Controller.ControllerCliente;
import Ejercicios.UD22.Model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ViewCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnDelete;
	private JButton btnUpdate;
	
	private ControllerCliente controllerCliente;
	private ViewCliente viewCliente;
	private ConnectionSQL connection;
	private ViewInsert viewInsert;

	/**
	 * Create the frame.
	 * @param connection 
	 */
	public ViewCliente(ConnectionSQL connection) {
		
		this.connection = connection;
		this.controllerCliente = new ControllerCliente(connection);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(341, 11, 66, 26);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 53, 730, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBounds(628, 12, 99, 25);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        viewInsert = new ViewInsert(controllerCliente, ViewCliente.this);
				viewInsert.setVisible(true);
			}
		});
	}
	
	//FUNCTION TO SHOW CLIENTES ON MAIN WINDOW
	public void showCliente(List<Cliente> cli) {

        if(cli.isEmpty()) {
        	
        	JOptionPane.showMessageDialog(contentPane, "No CLIENTE to show");
        	
        } else {
        	
            panel.removeAll();
            panel.revalidate();
        	
        	int y = 8;
        	int yy = 10;
        	
        	for (Cliente cliente : cli) {
        		
                JLabel lblCliente = new JLabel("ID: " + cliente.getId() + ", nombre: " + cliente.getNombre()
                		+ ", apellido: " + cliente.getApellido() + ", direccion: " + cliente.getDireccion()
                		+ ", dni: " + cliente.getDni() + ", fecha: " + cliente.getFecha());
                
                panel.add(lblCliente);
                lblCliente.setBounds(10, y, 500, 30);
                
                //BUTTON UPDATE FOR EACH CLIENTE
        		btnUpdate = new JButton("UPDATE");
        		btnUpdate.setBounds(550, yy, 80, 23);
        		btnUpdate.setBackground(Color.YELLOW);
                btnUpdate.setName("btnUpd" + cliente.getId());
        		btnUpdate.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        				int clienteId = cliente.getId();
        				ControllerCliente controllerCliente = new ControllerCliente(connection);
        				
        				ViewUpdate viewUpdate = new ViewUpdate(clienteId, controllerCliente, connection, viewCliente);
        				viewUpdate.setVisible(true);
        			}
        		});
        		
                panel.add(btnUpdate);

        		//BUTTON DELETE FOR EACH CLIENTE
        		btnDelete = new JButton("DELETE");
        		btnDelete.setBounds(635, yy, 80, 23);
        		btnDelete.setBackground(Color.RED);
                btnDelete.setName("btnDel" + cliente.getId());
        		btnDelete.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				        				
        				int del = JOptionPane.showConfirmDialog(null, "Do you want to delete this cliente?", "Confirm",
        						JOptionPane.YES_NO_OPTION);
        				
        				if (del == JOptionPane.YES_OPTION) {
        					
    						int clienteId = cliente.getId();						
    						controllerCliente.deleteCliente(clienteId);
    						
    				        panel.remove(lblCliente);
                            panel.remove(btnDelete);
                            panel.revalidate();
                            panel.repaint();
            			}
        			}
        		
        		});
        		
                panel.add(btnDelete);
                
                y = y + 30;
                yy = yy + 30;
                
        	}
        }
        
        panel.revalidate();
        panel.repaint();
	}
}
