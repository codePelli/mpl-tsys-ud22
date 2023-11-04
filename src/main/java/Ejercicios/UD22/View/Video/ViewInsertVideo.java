package Ejercicios.UD22.View.Video;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Ejercicios.UD22.Controller.Cliente.ControllerCliente;
import Ejercicios.UD22.Controller.Video.ControllerVideo;
import Ejercicios.UD22.Model.Video;
import Ejercicios.UD22.View.Cliente.ViewCliente;

public class ViewInsertVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfDirector;
	private JTextField tfClienteId;
	
	private ViewVideo viewVideo;
	private ControllerVideo controllerVideo;

	/**
	 * Create the frame.
	 * @param viewCiente 
	 */
	public ViewInsertVideo(ControllerVideo controllerVideo, ViewVideo viewVideo) {
		
		this.controllerVideo = controllerVideo;
		this.viewVideo = viewVideo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("title:");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setBounds(10, 53, 61, 24);
		contentPane.add(lblTitle);
		
		JLabel lbDirector = new JLabel("director:");
		lbDirector.setHorizontalAlignment(SwingConstants.LEFT);
		lbDirector.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbDirector.setBounds(10, 88, 61, 24);
		contentPane.add(lbDirector);
		
		JLabel lblClienteId = new JLabel("clienteId:");
		lblClienteId.setHorizontalAlignment(SwingConstants.LEFT);
		lblClienteId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClienteId.setBounds(10, 123, 61, 24);
		contentPane.add(lblClienteId);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(74, 53, 350, 20);
		contentPane.add(tfTitle);
		
		tfDirector = new JTextField();
		tfDirector.setColumns(10);
		tfDirector.setBounds(74, 88, 350, 20);
		contentPane.add(tfDirector);
		
		tfClienteId = new JTextField();
		tfClienteId.setColumns(10);
		tfClienteId.setBounds(74, 125, 350, 20);
		contentPane.add(tfClienteId);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(Color.GREEN);
		btnInsert.setBounds(177, 226, 96, 24);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = getTitleVideo();
				String director = getDirector();
				int cli_id = getCli_id();
				
				Video video = new Video(title, director, cli_id);
				
				controllerVideo.insertVideo(video);
				
				JOptionPane.showMessageDialog(null, "Video created");
				
				viewVideo.showVideo(controllerVideo.listGetVideos());
				dispose();
			}
		});
	}
	
	public String getTitleVideo() {
		
		return tfTitle.getText();
	}
	
	public String getDirector() {
		
		return tfDirector.getText();
	}
	
	public int getCli_id() {
		
		return Integer.parseInt(tfClienteId.getText());
	}
}
