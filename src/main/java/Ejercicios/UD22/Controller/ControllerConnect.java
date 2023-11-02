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
import Ejercicios.UD22.View.ViewUpdate;

public class ControllerConnect {
	
	private JButton btnSi;
	private JButton btnNo;
	private ViewConnect vc;
	public ConnectionSQL connection;
	private String DB;
	
	ViewDB viewDB;


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
				
			String tableName = "cliente";
			String tableSentence = "id INT AUTO_INCREMENT, nombre VARCHAR(255), "
					+ "apellido VARCHAR(255), direccion VARCHAR(255), "
					+ "dni INT, fecha DATE, PRIMARY KEY (id)";
			
			connection.createTable(tableName, tableSentence);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		vc.btnSi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            JOptionPane.showMessageDialog(null, "Connected to DB");
	            vc.setVisible(false);
	            viewDB = new ViewDB(connection);
	            
	            viewDB.setVisible(true);
	            viewDB.showCliente(connection.getClientes());
			}
		});
		
		/*vc.btnNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				connection.disconnect();
	            vc.setVisible(false);
	            JOptionPane.showMessageDialog(null, "Disconnected from DB");

			}
		});*/

	}
}
