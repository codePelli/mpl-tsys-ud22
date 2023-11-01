package Ejercicios.UD22.Controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Model.Cliente;
import Ejercicios.UD22.View.ViewDB;

public class ControllerCliente {
	
	private ConnectionSQL connection;
	private ViewDB viewDB;
	
	public ControllerCliente(ConnectionSQL connection) {
		
		this.connection = connection;
		this.viewDB = viewDB;
	}
	
	public List<Cliente> listGetClientes(){
		
		return connection.getClientes();
		
	}
	
	public void insertCliente(Cliente cliente) {
		
	}
	
	public void updateCliente(Cliente cliente) {
		
	}
	
	public void deleteCliente(int idCliente) {
		
	}
	
	public void showCliente() {
		
		List<Cliente> clientes = listGetClientes();
        viewDB.showCliente(clientes);
	}

}
