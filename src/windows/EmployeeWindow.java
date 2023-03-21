package windows;

import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import database.DBConnection;
import net.proteanit.sql.DbUtils;

public class EmployeeWindow extends JFrame {

	private Choice chosenId = new Choice();

	public EmployeeWindow() {
		this.setBackground(Color.black);
		setLayout(null);
		this.setLocation(200, 0);

		JLabel searchLabel = new JLabel("Search by ID:");
		searchLabel.setBounds(100, 0, 100, 100);
		this.add(searchLabel);

		chosenId.setBounds(200, 40, 100, 100);
		this.add(chosenId);

		try {
			DBConnection c = new DBConnection();
			ResultSet res = c.getStatement().executeQuery("select * from employee");
			while (res.next()) {
				chosenId.add(res.getString("id"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		JTable table = new JTable();

		try {
			DBConnection c = new DBConnection();
			ResultSet res = c.getStatement().executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(res));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 100, 900, 900);

		this.add(scroll);

		this.setSize(900, 900);
		this.setVisible(true);

	}
}
