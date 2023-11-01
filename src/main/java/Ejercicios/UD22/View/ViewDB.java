package Ejercicios.UD22.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class ViewDB extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnDelete;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDB frame = new ViewDB();
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
	public ViewDB() {
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
	}
	
	public void showCliente(List<Cliente> cli) {

        if(cli.isEmpty()) {
        	
        	JOptionPane.showMessageDialog(contentPane, "No CLIENTE to show");
        } else {
        	
        	int y = 8;
        	int yy = 10;
        	
        	for (Cliente cliente : cli) {
        		
                JLabel lblCliente = new JLabel("ID: " + cliente.getId() + ", nombre: " + cliente.getNombre()
                		+ ", apellido: " + cliente.getApellido() + ", direccion: " + cliente.getDireccion()
                		+ ", dni: " + cliente.getDni() + ", fecha: " + cliente.getFecha());
                
                panel.add(lblCliente);
                lblCliente.setBounds(10, y, 500, 30);
                
                //BUTTON UPDATE
        		btnUpdate = new JButton("UPDATE");
        		btnUpdate.setBounds(550, yy, 80, 23);
        		btnUpdate.setBackground(Color.YELLOW);
                btnUpdate.setName("btnUpd" + cliente.getId());
        		btnUpdate.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        			}
        		});
        		
                panel.add(btnUpdate);

        		//BUTTON DELETE
        		btnDelete = new JButton("DELETE");
        		btnDelete.setBounds(635, yy, 80, 23);
        		btnDelete.setBackground(Color.RED);
                btnDelete.setName("btnDel" + cliente.getId());
        		btnDelete.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
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
