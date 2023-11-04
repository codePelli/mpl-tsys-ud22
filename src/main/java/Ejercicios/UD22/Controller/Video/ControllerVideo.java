package Ejercicios.UD22.Controller.Video;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Model.Cliente;
import Ejercicios.UD22.Model.Video;

public class ControllerVideo {
	
	private ConnectionSQL connection;
	
	public ControllerVideo(ConnectionSQL connection) {
		
		this.connection = connection;
	}
	
	public List<Video> listGetVideos(){
		
		return connection.getVideo();
		
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR INSERTING DATA
	public void insertVideo(Video videos) {
		
		try {
			
			String query = "INSERT INTO video (title, director, cli_id) "
					+ "VALUES (?, ?, ?)";
			
	        PreparedStatement ps = connection.connection.prepareStatement(query);
	        
	        ps.setString(1, videos.getTitle());
	        ps.setString(2, videos.getDirector());
	        ps.setInt(3, videos.getCli_id());
	        ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR UPDATING DATA
	public void updateVideos(String title, String director, int clienteId, int videoId) {
		
		try {
			
	        String query = "UPDATE video SET title = ?, director = ?, cli_id = ?, WHERE id = ?";
	        
		       PreparedStatement ps = connection.connection.prepareStatement(query);
		       
		        ps.setString(1, title);
		        ps.setString(2, director);
		        ps.setInt(3, clienteId);
		        ps.setInt(4, videoId);
		        
		        ps.executeUpdate();
			
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR DELETING DATA
	public void deleteVideos(int videoId) {
		
		try {
			
			String query = "DELETE FROM video WHERE id = ?";
			
			PreparedStatement ps = connection.connection.prepareStatement(query);
			
			ps.setInt(1, videoId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}

	public void deleteVideo(int videoId) {
		
		try {
			
			String query = "DELETE FROM video WHERE id = ?";
			
			PreparedStatement ps = connection.connection.prepareStatement(query);
			
			ps.setInt(1, videoId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
