package Ejercicios.UD22.Controller;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Model.Cliente;
import Ejercicios.UD22.View.ViewDB;
import Ejercicios.UD22.View.ViewUpdate;

public class ControllerCliente {
	
	private ConnectionSQL connection;
	
	public ControllerCliente(ConnectionSQL connection) {
		
		this.connection = connection;
	}
	
	public List<Cliente> listGetClientes(){
		
		return connection.getClientes();
		
	}
	
	public void insertCliente(Cliente cliente) {
		
	}
	
	public void updateCliente(int clienteId, String nombre, String apellido, String direccion, 
			int dni, Date fecha) {
		
		try {
			
	        String query = "UPDATE cliente SET nombre = ?, apellido = ?, direccion = ?, "
	        		+ "dni = ?, fecha = ? WHERE id = ?";
	        
		       PreparedStatement ps = connection.connection.prepareStatement(query);
		       
		        ps.setString(1, nombre);
		        ps.setString(2, apellido);
		        ps.setString(3, direccion);
		        ps.setInt(4, dni);
		        ps.setDate(5, fecha);
		        ps.setInt(6, clienteId);
		        
		        try {
			        ps.executeUpdate();

		        } catch (SQLException e) {
		        	System.out.println(e.getMessage());
		        }
			
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void deleteCliente(int idCliente) {
		
	}

}
