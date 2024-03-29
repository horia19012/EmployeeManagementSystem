package windows;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton addBtn;
	private JButton viewBtn;

	public MainWindow() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/main.jpg"));
		Image icon2 = icon1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JLabel background = new JLabel(icon3);
		background.setBounds(0, 0, 900, 600);

		JLabel topLabel = new JLabel("Option Menu");
		topLabel.setFont(new Font("serif", Font.PLAIN, 40));
		topLabel.setBounds(50, 10, 300, 100);
		background.add(topLabel);

		addBtn = new JButton("Add Employee");
		addBtn.setBounds(100, 100, 200, 60);
		background.add(addBtn);
		addBtn.addActionListener(this);

		viewBtn = new JButton("View Employees");
		viewBtn.setBounds(100, 200, 200, 60);
		background.add(viewBtn);
		viewBtn.addActionListener(this);

		getContentPane().add(background);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) {
			this.dispose();
			new AddEmployee();
		} else if (e.getSource() == viewBtn) {
			this.dispose();
			new EmployeeWindow();
		}
	}

}
