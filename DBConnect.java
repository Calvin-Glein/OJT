
import java.io.File;
import java.sql.Date;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

public class DBConnect {

	private java.sql.Connection con;
	private ResultSet rs;

	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/intern", "root", "1234");

			con.createStatement();

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	// public void addScore(Scorecard scorecard) {
	// String query = "insert into scorecard(employee_id, year, month,
	// full_name, team, total_tickets, cwte2e, cwtdisputed, missed_tickets, fyr,
	// controllable_miss, call_registration, csat, qa, external_escalation)
	// VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	//
	// try {
	// PreparedStatement preparedStatement = (PreparedStatement)
	// con.prepareStatement(query);
	// preparedStatement.setInt(1, scorecard.getId());
	// preparedStatement.setInt(2, scorecard.getYear());
	// preparedStatement.setInt(3, scorecard.getMonth());
	// preparedStatement.setString(4, scorecard.getFullname());
	// preparedStatement.setString(5, scorecard.getTeam());
	// preparedStatement.setInt(6, scorecard.getTotalTickets());
	// preparedStatement.setDouble(7, scorecard.getCwtE2E());
	// preparedStatement.setDouble(8, scorecard.getCwtDisputed());
	// preparedStatement.setInt(9, scorecard.getMissedTickets());
	// preparedStatement.setInt(10, scorecard.getFyr());
	// preparedStatement.setInt(11, scorecard.getControllableMiss());
	// preparedStatement.setDouble(12, scorecard.getCallRegistration());
	//// preparedStatement.setDouble(13, scorecard.getCsat());
	//// preparedStatement.setDouble(14, scorecard.getQa());
	//// preparedStatement.setInt(15, scorecard.getExternalEscalation());
	//
	// preparedStatement.executeUpdate();
	//
	// } catch (Exception ex) {
	// System.out.println(ex);
	// }
	// }

	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	public void addScore(Scorecard scorecard) {
		String query = "insert into scorecard(date, name, team, total_tickets, e2e, disputed, missed_tickets, fyr, controllable_miss, call_registration) VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setDate(1, convertJavaDateToSqlDate(scorecard.getDate()));
			preparedStatement.setString(2, scorecard.getFullname());
			preparedStatement.setString(3, scorecard.getTeam());
			preparedStatement.setInt(4, scorecard.getTotalTickets());
			preparedStatement.setDouble(5, scorecard.getCwtE2E());
			preparedStatement.setDouble(6, scorecard.getCwtDisputed());
			preparedStatement.setInt(7, scorecard.getMissedTickets());
			preparedStatement.setInt(8, scorecard.getFyr());
			preparedStatement.setInt(9, scorecard.getControllableMiss());
			preparedStatement.setDouble(10, scorecard.getCallRegistration());
			// preparedStatement.setDouble(13, scorecard.getCsat());
			// preparedStatement.setDouble(14, scorecard.getQa());
			// preparedStatement.setInt(15, scorecard.getExternalEscalation());

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		query = "insert into csat(date, name, csat) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setDate(1, convertJavaDateToSqlDate(scorecard.getDate()));
			preparedStatement.setString(2, scorecard.getFullname());
			preparedStatement.setDouble(3, scorecard.getCsat());

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		query = "insert into escalation(date, name, escalation) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setDate(1, convertJavaDateToSqlDate(scorecard.getDate()));
			preparedStatement.setString(2, scorecard.getFullname());
			preparedStatement.setInt(3, scorecard.getExternalEscalation());

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		query = "insert into qa(date, name, qa) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setDate(1, convertJavaDateToSqlDate(scorecard.getDate()));
			preparedStatement.setString(2, scorecard.getFullname());
			preparedStatement.setDouble(3, scorecard.getQa());

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		JOptionPane.showMessageDialog(null, "Data for " + scorecard.getFullname() + " added.");

	}

	public ArrayList<String> getEmployeeData(String colName) {

		String column = null;
		;
		if (colName.equals("id")) {
			column = "employee_id";
		} else if (colName.equals("firstname")) {
			column = "first_name";
		} else if (colName.equals("lastname")) {
			column = "last_name";
		} else if (colName.equals("nickname")) {
			column = "nick_name";
		}
		String query = "SELECT " + column + " as 'employeeInfo' from employee";
		ArrayList<String> arr_employeeInformation = new ArrayList<String>();
		arr_employeeInformation.add("Select");

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				arr_employeeInformation.add(rs.getString("employeeInfo"));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return arr_employeeInformation;
	}

	public ArrayList<String> getEmployeeFullName() {

		String query = "SELECT full_name from employee";

		ArrayList<String> arr_employeeInformation = new ArrayList<String>();
		arr_employeeInformation.add("Select");

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				arr_employeeInformation.add(rs.getString("full_name"));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return arr_employeeInformation;
	}

	public int getID(String fullname) {

		int id = -1;

		String query = "SELECT employee_id from employee where full_name = ?";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, fullname);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				id = rs.getInt("employee_id");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return id;
	}

	public void loadCSVScorecard(File path) {

		String query = "LOAD DATA LOCAL INFILE ? INTO TABLE intern.scorecard FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' "
				+ "IGNORE 1 LINES  (@date, name, team, total_tickets, e2e, disputed, missed_tickets, fyr, controllable_miss, call_registration) SET date = "
				+ "STR_TO_DATE(@date, '%m/%d/%Y')";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, path.getPath());

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + path.getPath());

		} catch (Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "Please select the right file with .csv format");

		}

	}

	public void loadCSVEmployee(File path) {

		String query = "LOAD DATA LOCAL INFILE ? INTO TABLE intern.employee FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n'";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, path.getPath());

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + path.getPath());

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please select the right file with .csv format");

		}
	}

	public void loadCSVQA(File path) {

		String query = "LOAD DATA LOCAL INFILE ? INTO TABLE intern.qa FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' "
				+ "IGNORE 1 LINES  (@date, name, qa	) SET date = STR_TO_DATE(@date, '%m/%d/%Y')";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, path.getPath());

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + path.getPath());

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please select the right file with .csv format");

		}
	}

	public void loadCSVCSAT(File path) {

		String query = "LOAD DATA LOCAL INFILE ? INTO TABLE intern.csat FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' "
				+ "IGNORE 1 LINES  (@date, name, csat) SET date = STR_TO_DATE(@date, '%m/%d/%Y')";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, path.getPath());

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + path.getPath());

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please select the right file with .csv format");

		}
	}

	public void loadCSVEscalation(File path) {

		String query = "LOAD DATA LOCAL INFILE ? INTO TABLE intern.escalation FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' "
				+ "IGNORE 1 LINES  (@date, name, escalation) SET date = STR_TO_DATE(@date, '%m/%d/%Y')";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, path.getPath());

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Added " + path.getPath());

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please select the right file with .csv format");

		}
	}

	public void sync() {

		String query = "DROP TABLE `intern`.`final_scorecard`;";
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Files synced");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Oops, something went wrong with dropping \"final_scorecard\" table");
		}
		
		
		query = " create table final_scorecard AS SELECT s.date, s.name, s.team, s.total_tickets, s.e2e, s.disputed, s.missed_tickets, s.fyr, s.controllable_miss, "
				+ "s.call_registration, c.csat, q.qa, e.escalation FROM csat c, scorecard s, qa q, escalation e where UPPER(TRIM(c.name)) = "
				+ "UPPER(TRIM(s.name)) && UPPER(TRIM(s.name)) =UPPER(TRIM(q.name)) &&  UPPER(TRIM(s.name)) =UPPER(TRIM(e.name))  && "
				+ "month(s.date) = month(c.date) && month(s.date) = month(q.date) && month(s.date) = month(e.date) group by year(s.date), "
				+ "month(s.date), day(s.date), name, s.date;";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Files synced");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Oops, something went wrong with syncing/creating the \"final_scorecard\" table ");
		}
	}

}