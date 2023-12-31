package Ejercicios.UD22.Controller.Video;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public void insertVideo(Video video) {
		
		try {
			
			String query = "INSERT INTO video (title, director, cli_id) "
					+ "VALUES (?, ?, ?)";
			
	        PreparedStatement ps = connection.connection.prepareStatement(query);
	        
	        ps.setString(1, video.getTitle());
	        ps.setString(2, video.getDirector());
	        ps.setInt(3, video.getCli_id());
	        ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR UPDATING DATA
	public void updateVideo(int id, String title, String director, int cli_id) {
		
		try {
			
	        String query = "UPDATE video SET title = ?, director = ?, cli_id = ? WHERE id = ?";
	        
		       PreparedStatement ps = connection.connection.prepareStatement(query);
		       
		        ps.setString(1, title);
		        ps.setString(2, director);
		        ps.setInt(3, cli_id);
		        ps.setInt(4, id);
		        
		        ps.executeUpdate();
			
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	//FUNCTION TO SEND THE QUERY TO DB FOR DELETING DATA
	public void deleteVideo(int id) {
		
		try {
			
			String query = "DELETE FROM video WHERE id = ?";
			
			PreparedStatement ps = connection.connection.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
