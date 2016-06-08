
import java.sql.Date;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;



public class DBConnect {

	private java.sql.Connection con;
	private ResultSet rs;
	


	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/intern","root","1234");


			con.createStatement();

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
	

	public void addScore(Scorecard scorecard) {
		String query = "insert into onebiopsscorecard(employee_id, year, month, full_name, team, total_tickets, cwte2e, cwtdisputed, missed_tickets, fyr, controllable_miss, call_registration, csat, qa, external_escalation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1, scorecard.getId());
			preparedStatement.setInt(2, scorecard.getMonth());
			preparedStatement.setInt(3, scorecard.getYear());
			preparedStatement.setString(4, scorecard.getFullname());
			preparedStatement.setString(5, scorecard.getTeam());
			preparedStatement.setInt(6, scorecard.getTotalTickets());
			preparedStatement.setDouble(7, scorecard.getCwtE2E());
			preparedStatement.setDouble(8, scorecard.getCwtDisputed());
			preparedStatement.setInt(9, scorecard.getMissedTickets());
			preparedStatement.setInt(10, scorecard.getFyr());
			preparedStatement.setInt(11, scorecard.getControllableMiss());
			preparedStatement.setDouble(12, scorecard.getCallRegistration());
			preparedStatement.setDouble(13, scorecard.getCsat());
			preparedStatement.setDouble(14, scorecard.getQa());
			preparedStatement.setInt(15, scorecard.getExternalEscalation());
			
			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public ArrayList<String> getEmployeeData(String colName) {
		
		String column = null;;
		if(colName.equals("id")){
			column = "employee_id";
		}
		else if(colName.equals("firstname")){
			column = "first_name";
		}
		else if(colName.equals("lastname")){
			column = "last_name";
		}
		else if(colName.equals("nickname")){
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
	
	public void loadCSV(String csvpath){
		
		String query = "LOAD DATA INFILE '" + csvpath + "' INTO TABLE intern.employee";

	
	}
	
	
	
	
	


}