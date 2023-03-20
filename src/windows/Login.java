package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import database.DBConnection;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Login();
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 657, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.black);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		username = new JTextField();
		username.setBounds(161, 69, 205, 25);
		contentPane.add(username);
		username.setColumns(10);

		JLabel usernameLabel = new JLabel("USERNAME: ");
		usernameLabel.setForeground(new Color(255, 128, 64));
		usernameLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		usernameLabel.setBounds(70, 67, 81, 32);
		contentPane.add(usernameLabel);

		password = new JTextField();
		password.setBounds(161, 114, 205, 25);
		contentPane.add(password);
		password.setColumns(10);

		JLabel passwordLabel = new JLabel("PASSWORD: ");
		passwordLabel.setForeground(new Color(255, 128, 64));
		passwordLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		passwordLabel.setBounds(70, 120, 81, 19);
		contentPane.add(passwordLabel);

		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.jpg"));
		Image icon2 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);

		JLabel imageLabel = new JLabel(icon3);
		imageLabel.setBounds(399, 69, 205, 194);
		contentPane.add(imageLabel);

		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(255, 128, 64));
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBounds(253, 157, 113, 46);
		loginButton.addActionListener(this);
		contentPane.add(loginButton);
		contentPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String uname = username.getText();
			String pass = password.getText();
			System.out.println(uname +" "+pass);
			DBConnection c = new DBConnection();
			String query = "select * from login where username = '" + uname + "' and password = '" + pass + "'";
			System.out.println(query);
			ResultSet resSet=c.getStatement().executeQuery(query);
			if(resSet.next()) {
				this.setVisible(false);
				
			}else {
				JOptionPane.showMessageDialog(null, "Invalid username or password!");
				this.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
