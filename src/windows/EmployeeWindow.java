package windows;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.DBConnection;
import net.proteanit.sql.DbUtils;

public class EmployeeWindow extends JFrame implements ActionListener {

	private Choice chosenId = new Choice();
	private JButton show;
	private JButton remove;
	private JButton back;
	private JButton print;
	private JTable table;
	private JButton update;

	public EmployeeWindow() {
		setLayout(null);
		this.setLocation(200, 0);
		this.getContentPane().setBackground(Color.black);

		JLabel searchLabel = new JLabel("Search by ID:");
		searchLabel.setBounds(100, 0, 100, 100);
		searchLabel.setForeground(Color.white);
		this.add(searchLabel);

		chosenId.setBounds(200, 40, 100, 100);
		this.add(chosenId);

		show = new JButton("Search");
		show.setBounds(100, 70, 80, 20);
		show.addActionListener(this);
		this.add(show);

		remove = new JButton("Remove");
		remove.setBounds(200, 70, 95, 20);
		remove.addActionListener(this);
		this.add(remove);

		print = new JButton("Print");
		print.setBounds(300, 70, 80, 20);
		print.addActionListener(this);
		this.add(print);

		update = new JButton("Update");
		update.setBounds(400, 70, 80, 20);
		update.addActionListener(this);
		this.add(update);
		
		back = new JButton("Back");
		back.setBounds(1000, 70, 80, 20);
		back.addActionListener(this);
		this.add(back);

		try {
			DBConnection c = new DBConnection();
			ResultSet res = c.getStatement().executeQuery("select * from employee");
			while (res.next()) {
				chosenId.add(res.getString("id"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		table = new JTable();

		try {
			DBConnection c = new DBConnection();
			ResultSet res = c.getStatement().executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(res));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 100, 1200, 1200);

		this.add(scroll);

		this.setSize(1200, 1200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == show) {
			String query = "select *from employee where id= '" + chosenId.getSelectedItem() + "';";
			try {
				DBConnection c = new DBConnection();
				ResultSet res = c.getStatement().executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(res));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == remove) {
			String query = "delete from employee where id= ?";
			try {
				DBConnection c = new DBConnection();
				PreparedStatement stmt = c.getConnection().prepareStatement(query);
				stmt.setString(1, chosenId.getSelectedItem().toString());
				int rowsDeleted = stmt.executeUpdate();
				this.dispose();
				new EmployeeWindow();
				if (rowsDeleted > 0) {
					System.out.println("Record deleted successfully!");
				} else {
					System.out.println("Record not found.");
				}
				// Update your table accordingly
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == print) {
			try {
				table.print();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == update) {
			this.dispose();
			try {
				new UpdateEmployee(chosenId.getSelectedItem().toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			this.dispose();
			new MainWindow();
		}
	}
}
