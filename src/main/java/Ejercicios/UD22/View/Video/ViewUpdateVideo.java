package Ejercicios.UD22.View.Video;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ejercicios.UD22.Connection.ConnectionSQL;
import Ejercicios.UD22.Controller.Cliente.ControllerCliente;
import Ejercicios.UD22.Controller.Video.ControllerVideo;
import Ejercicios.UD22.View.Cliente.ViewCliente;

public class ViewUpdateVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ControllerVideo controllerVideo;
	
	private JTextField tfId;
	private JTextField tfTit;
	private JTextField tfDir;
	private JTextField tfCli_id;
	private JButton btnUpdate;

	/**
	 * Create the frame.
	 */
	public ViewUpdateVideo(int id, ControllerVideo controllerVideo, ConnectionSQL connection, 
			ViewVideo viewVideo) {
		
		this.controllerVideo = new ControllerVideo(connection);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(10, 21, 31, 24);
		contentPane.add(lblId);
		
		JLabel lblTitle = new JLabel("title:");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setBounds(10, 53, 61, 24);
		contentPane.add(lblTitle);
		
		JLabel lblDir = new JLabel("director:");
		lblDir.setHorizontalAlignment(SwingConstants.LEFT);
		lblDir.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDir.setBounds(10, 88, 61, 24);
		contentPane.add(lblDir);
		
		JLabel lblCli = new JLabel("cli_id:");
		lblCli.setHorizontalAlignment(SwingConstants.LEFT);
		lblCli.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCli.setBounds(10, 123, 61, 24);
		contentPane.add(lblCli);
		
		tfId = new JTextField();
		tfId.setBounds(74, 23, 350, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfTit = new JTextField();
		tfTit.setColumns(10);
		tfTit.setBounds(74, 53, 350, 20);
		contentPane.add(tfTit);
		
		tfDir = new JTextField();
		tfDir.setColumns(10);
		tfDir.setBounds(74, 88, 350, 20);
		contentPane.add(tfDir);
		
		tfCli_id = new JTextField();
		tfCli_id.setColumns(10);
		tfCli_id.setBounds(74, 125, 350, 20);
		contentPane.add(tfCli_id);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setBounds(177, 226, 96, 24);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					updateFields();
					JOptionPane.showMessageDialog(null, "Video updated");
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
		
		int id = getId();
		String title = getTitle();
		String director = getDirector();
		int cli_id = getCli_id();
		
		controllerVideo.updateVideo(id, title, director, cli_id);
	}

	public int getId() {
		// TODO Auto-generated method stub
		return Integer.parseInt(tfId.getText());
	}

	public int getCli_id() {
		// TODO Auto-generated method stub
		return Integer.parseInt(tfCli_id.getText());
	}

	public String getDirector() {
		// TODO Auto-generated method stub
		return tfDir.getText();
	}
	
	public String getTitle() {
		// TODO Auto-generated method stub
		return tfTit.getText();
	}

}
