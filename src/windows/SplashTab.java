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

public class SplashTab extends JFrame implements ActionListener{

	SplashTab() {
		getContentPane().setBackground(Color.black);
		setLayout(null);

		setSize(1000, 800);
		setVisible(true);
		this.setLocation(300, 0);
		

		JLabel label = new JLabel("Employee Management System");
		label.setBounds(200, 100, 1200, 60);
		label.setForeground(Color.white);
		label.setFont(new Font("serif", Font.PLAIN, 50));
		this.add(label);
		

		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
		Image icon2 = icon1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);
		JLabel background = new JLabel(icon3);
		background.setBounds(100, 50, 800, 800);
		this.add(background);

		JButton enterButton = new JButton("CONTINUE");
		enterButton.setBounds(550, 400, 200, 100);
		enterButton.setBackground(Color.white);
		enterButton.addActionListener(this);
		background.add(enterButton);
		
		this.repaint();
		

		
	}


	 public void actionPerformed(ActionEvent ae) {
	        setVisible(false);
	        new Login();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SplashTab();
	}

}
