package Ejercicios.UD22.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.View.ViewConnect;
import Ejercicios.UD22.View.ViewDB;

public class ControllerConnect {
	
	private JButton btnSi;
	private JButton btnNo;
	private ViewConnect vc;
	private ConnectionSQL connection;
	private String DB;
	ViewDB viewDB = new ViewDB();

	public ControllerConnect(ViewConnect vc) {

		this.vc = vc;

		String ip = "jdbc:mysql://localhost:33060";
		String user = "root";
		String pass = "password";
	    connection = new ConnectionSQL(ip, user, pass);
		
		DB = JOptionPane.showInputDialog(null, "Name your DB:");
		
        String queryDB = "CREATE DATABASE IF NOT EXISTS " + DB;
        Statement st;
		try {
			
			st = connection.connection.createStatement();
			st.executeUpdate(queryDB);
			
			String ip2 = "jdbc:mysql://localhost:33060/" + DB;
			connection.connect(ip2, user, pass);
			
			String tableName = "Cliente";
			String tableSentence = "id INT AUTO_INCREMENT, nombre VARCHAR(255), "
					+ "apellido VARCHAR(255), direccion VARCHAR(255), "
					+ "dni INT, fecha DATE, PRIMARY KEY (id)\";";
			
			connection.createTable(tableName, tableSentence);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		vc.btnSi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (connection.connect(ip, user, pass)) {
					
		            JOptionPane.showMessageDialog(null, "Connected to DB");
		            vc.setVisible(false);
		            
		            viewDB.setVisible(true);
		            viewDB.showCliente(connection.getClientes());
		            
				} else {
					
		            JOptionPane.showMessageDialog(null, "ERROR connecting to DB");

				}
			}
		});
		
		vc.btnNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				connection.disconnect();
				
	            JOptionPane.showMessageDialog(null, "Disconnected from DB");

			}
		});

	}
}
