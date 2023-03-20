package windows;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddEmployee extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField designation;
	private JTextField name;
	private JTextField city;
	private JTextField country;
	private JLabel nameLabel;
	private JLabel fNameLabel;
	private JLabel cityLabel;
	private JLabel lblCountry;
	private JTextField email;
	private JLabel emailLabel;
	private JTextField salary;
	private JTextField phoneNumber;
	private JTextField adress;
	private JLabel adressLabel;
	private JLabel lblPhoneNumber;
	private JLabel lblSalary;
	private JLabel birthLabel;
	private JTextField birthDate;
	private JButton addBtn;
	private JTextField coutry;
	private JButton backBtn;
	private JLabel idLabel;
	private JLabel id;
	private JLabel experienceLabel;
	private JComboBox level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 528);
		this.setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel topLabel = new JLabel("Enter details");
		topLabel.setBounds(390, 10, 165, 52);
		topLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
		contentPane.add(topLabel);

		name = new JTextField();
		name.setBounds(122, 85, 193, 22);
		contentPane.add(name);

		fname = new JTextField();
		fname.setBounds(122, 126, 193, 22);
		contentPane.add(fname);
		fname.setColumns(10);

		city = new JTextField();
		city.setBounds(122, 221, 193, 22);
		contentPane.add(city);

		country = new JTextField();
		country.setBounds(122, 268, 193, 22);
		contentPane.add(country);

		nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		nameLabel.setBounds(52, 90, 60, 13);
		contentPane.add(nameLabel);

		fNameLabel = new JLabel("Father's Name:");
		fNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		fNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		fNameLabel.setBounds(10, 130, 102, 13);
		contentPane.add(fNameLabel);

		cityLabel = new JLabel("City:");
		cityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cityLabel.setFont(new Font("Arial", Font.BOLD, 12));
		cityLabel.setBounds(10, 227, 102, 13);
		contentPane.add(cityLabel);

		lblCountry = new JLabel("Country:");
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setFont(new Font("Arial", Font.BOLD, 12));
		lblCountry.setBounds(22, 274, 102, 13);
		contentPane.add(lblCountry);

		email = new JTextField();
		email.setBounds(122, 317, 193, 22);
		contentPane.add(email);

		emailLabel = new JLabel("E-mail:");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		emailLabel.setBounds(10, 323, 102, 13);
		contentPane.add(emailLabel);

		salary = new JTextField();
		salary.setBounds(522, 221, 193, 22);
		contentPane.add(salary);

		phoneNumber = new JTextField();
		phoneNumber.setBounds(522, 124, 193, 22);
		contentPane.add(phoneNumber);

		adress = new JTextField();
		adress.setBounds(522, 172, 193, 22);
		contentPane.add(adress);

		adressLabel = new JLabel("Adress:");
		adressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		adressLabel.setFont(new Font("Arial", Font.BOLD, 12));
		adressLabel.setBounds(410, 178, 102, 13);
		contentPane.add(adressLabel);

		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 12));
		lblPhoneNumber.setBounds(410, 130, 102, 13);
		contentPane.add(lblPhoneNumber);

		lblSalary = new JLabel("Salary:");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Arial", Font.BOLD, 12));
		lblSalary.setBounds(410, 227, 102, 13);
		contentPane.add(lblSalary);

		birthLabel = new JLabel("Birth Date:");
		birthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		birthLabel.setFont(new Font("Arial", Font.BOLD, 12));
		birthLabel.setBounds(22, 178, 102, 13);
		contentPane.add(birthLabel);

		JLabel pattern = new JLabel("(MM/dd/yyyy)");
		pattern.setHorizontalAlignment(SwingConstants.CENTER);
		pattern.setBounds(32, 190, 102, 13);
		contentPane.add(pattern);

		birthDate = new JTextField();
		birthDate.setBounds(122, 175, 193, 19);
		contentPane.add(birthDate);
		birthDate.setColumns(10);

		addBtn = new JButton("Add");
		addBtn.setBounds(465, 388, 183, 52);
		addBtn.addActionListener(this);

		contentPane.add(addBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(265, 388, 157, 52);
		backBtn.addActionListener(this);
		contentPane.add(backBtn);

		designation = new JTextField();
		designation.setBounds(522, 268, 193, 22);
		contentPane.add(designation);

		JLabel designationLabel = new JLabel("Designation:");
		designationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		designationLabel.setFont(new Font("Arial", Font.BOLD, 12));
		designationLabel.setBounds(410, 274, 102, 13);
		contentPane.add(designationLabel);

		idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		idLabel.setBounds(148, 357, 45, 28);
		contentPane.add(idLabel);

		id = new JLabel("\"\"");
		id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		id.setBounds(195, 367, 45, 13);
		contentPane.add(id);

		experienceLabel = new JLabel("Level of experience:");
		experienceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		experienceLabel.setFont(new Font("Arial", Font.BOLD, 12));
		experienceLabel.setBounds(366, 321, 146, 13);
		contentPane.add(experienceLabel);

		level = new JComboBox();
		level.setModel(new DefaultComboBoxModel(
				new String[] { "Entry-level", "Intermediate", "Mid-level", "Senior or executive-level" }));
		level.setBounds(546, 317, 169, 21);
		contentPane.add(level);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) {
			String nname, ffname, bbirthDate, ddesignation, ccity, ccountry, eemail, iid, ssalary, aadress, llevel;
			nname = name.getText();
			ffname = fname.getText();
			bbirthDate = birthDate.getText();
			ddesignation = designation.getText();
			ccity = city.getText();
			ccountry = country.getText();
			eemail = email.getText();
			iid = id.getText();
			ssalary = salary.getText();
			aadress = adress.getText();
			iid = id.getText();
			llevel = level.getSelectedItem().toString();

			String emailRegex = "";
			Pattern p = Pattern.compile(emailRegex);
			Matcher m = p.matcher(eemail);
			
			
			
			

		} else if (e.getSource() == backBtn) {
			this.dispose();
			MainWindow m = new MainWindow();
			m.setVisible(true);
		}
	}
}
