package com.rmi.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import com.rmi.interfaces.ServerInterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegUser extends javax.swing.JFrame {

	private JFrame frame;
	private JTextField txtRegName;
	private Home home;
	private final ServerInterface server;
	private RegUser regUser;

	public RegUser getRegUser() {
		return regUser;
	}

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// RegUser window = new RegUser();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	public ServerInterface getServer() {
		return server;
	}

	/**
	 * Create the application.
	 */
	public RegUser(ServerInterface server) {
		setType(Type.NORMAL);
		setResizable(false);
		setSize(428, 300);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
		});
		this.server = server;
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("RMI Power Chat");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(12, 12, 426, 38);
		getContentPane().add(lblNewLabel);

		txtRegName = new JTextField();
		txtRegName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtRegName.getText();
				try {
					home = new Home(getServer(), name, getRegUser());
					home.setVisible(true);
					regUser.setVisible(false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtRegName.setBounds(178, 108, 114, 19);
		getContentPane().add(txtRegName);
		txtRegName.setColumns(10);

		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = txtRegName.getText();
				try {
					home = new Home(getServer(), name, getRegUser());
					home.setVisible(true);
					regUser.setVisible(false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(178, 168, 117, 25);
		getContentPane().add(btnRegister);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.regUser = this;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
