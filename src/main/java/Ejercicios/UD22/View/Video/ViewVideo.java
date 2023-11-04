package Ejercicios.UD22.View.Video;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Controller.Cliente.ControllerCliente;
import Ejercicios.UD22.Controller.Video.ControllerVideo;
import Ejercicios.UD22.Model.Cliente;
import Ejercicios.UD22.Model.Video;

public class ViewVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnDelete;
	private JButton btnUpdate;
	
	private ControllerVideo controllerVideo;
	private ViewVideo viewVideo;
	private ConnectionSQL connection;
	private ViewInsertVideo viewInsert;

	/**
	 * Create the frame.
	 */
	public ViewVideo(ConnectionSQL connection) {
		
		this.connection = connection;
		this.controllerVideo = new ControllerVideo(connection);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIDEOS");
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
				
		        viewInsert = new ViewInsertVideo(controllerVideo, ViewVideo.this);
				viewInsert.setVisible(true);
			}
		});
	}
	
	//FUNCTION TO SHOW CLIENTES ON MAIN WINDOW
	public void showVideo(List<Video> vid) {

        if(vid.isEmpty()) {
        	
        	JOptionPane.showMessageDialog(contentPane, "No VIDEO to show");
        	
        } else {
        	
            panel.removeAll();
            panel.revalidate();
        	
        	int y = 8;
        	int yy = 10;
        	
        	for (Video video : vid) {
        		
                JLabel lblVideo = new JLabel("ID: " + video.getId() + ", title: " + video.getTitle()
                		+ ", director: " + video.getDirector() + ", cli_id: " + video.getCli_id());
                
                panel.add(lblVideo);
                lblVideo.setBounds(10, y, 500, 30);
                
                //BUTTON UPDATE FOR EACH CLIENTE
        		btnUpdate = new JButton("UPDATE");
        		btnUpdate.setBounds(550, yy, 80, 23);
        		btnUpdate.setBackground(Color.YELLOW);
                btnUpdate.setName("btnUpd" + video.getId());
        		btnUpdate.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        				int videoId = video.getId();
        				ControllerVideo controllerVideo = new ControllerVideo(connection);
        				
        				//ViewUpdateVideo viewUpdateVideo = new ViewUpdateVideo(videoId, controllerVideo, connection, viewVideo);
        				//viewUpdateVideo.setVisible(true);
        			}
        		});
        		
                panel.add(btnUpdate);

        		//BUTTON DELETE FOR EACH CLIENTE
        		btnDelete = new JButton("DELETE");
        		btnDelete.setBounds(635, yy, 80, 23);
        		btnDelete.setBackground(Color.RED);
                btnDelete.setName("btnDel" + video.getId());
        		btnDelete.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				        				
        				int del = JOptionPane.showConfirmDialog(null, "Do you want to delete this cliente?", "Confirm",
        						JOptionPane.YES_NO_OPTION);
        				
        				if (del == JOptionPane.YES_OPTION) {
        					
    						int videoId = video.getId();						
    						controllerVideo.deleteVideo(videoId);
    						
    				        panel.remove(lblVideo);
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
