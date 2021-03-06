import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class GUI{

	private JFrame frame = new JFrame("OneBIOPS Scorecard");

	private JPanel manualPanel = new JPanel();
	private JPanel automaticPanel = new JPanel();

	private JScrollPane rightScrollPane = new JScrollPane(automaticPanel);
	private JScrollPane leftScrollPane = new JScrollPane(manualPanel);
	private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
	private final JLabel lblManualInput = new JLabel("Manual Input");
	private final JLabel lblEmployeeId = new JLabel("Employee ID");
	private final JLabel lblMonth = new JLabel("Month");
	private final JLabel lblFullname = new JLabel("Fullname (last first)");
	private final JLabel lblTeam = new JLabel("Team");
	private final JLabel lblTotalTickets = new JLabel("Total Tickets");
	private final JLabel lblCWTE2E = new JLabel("%CWT (E2E)");
	private final JLabel lblCWTDisputed = new JLabel("%CWT (Disputed)");
	private final JLabel lblMissedTickets = new JLabel("Missed Tickets");
	private final JLabel lblFyr = new JLabel("FYR");
	private final JLabel lblControllableMis = new JLabel("Controllable Mis");
	private final JLabel lblCallRegistration = new JLabel("Call Registration");
	private final JLabel lblCSAT = new JLabel("CSAT");
	private final JLabel lblQA = new JLabel("QA");
	private final JLabel lblExternalEscalation = new JLabel("External Escalation");
	private JTextField txtEmployeeID = new JTextField();
	private JComboBox cmbMonth;
	private JComboBox cmbYear = new JComboBox();
	private JComboBox cmbTeam = new JComboBox();
	private final JTextField txtFullname = new JTextField();

	private final JTextField txtTotalTickets = new JTextField();
	private final JTextField txtE2E = new JTextField();
	private final JTextField txtDisputed = new JTextField();
	private final JTextField txtMissedTickets = new JTextField();
	private final JTextField txtFYR = new JTextField();
	private final JTextField txtControllableMis = new JTextField();
	private final JTextField txtCallRegistration = new JTextField();
	private final JTextField txtCSAT = new JTextField();
	private final JTextField txtQA = new JTextField();
	private final JTextField txtExternalEscalation = new JTextField();
	private final JButton btnEnter = new JButton("ENTER");
	private final JLabel lblYear = new JLabel("Year");

	private DBConnect db = new DBConnect();
	
	private Controller controller;
	private final JLabel lblAutomaticSync = new JLabel("Automatic Sync");
	private final JButton btnSelectEmployeeCSVFile = new JButton("Select employee (.csv)  file to sync");
	private final JButton btnSelectScorecardCSVFile = new JButton("Select scorecard (.csv) file to sync");
	private final JButton btnSelectCsatcsvFile = new JButton("Select csat (.csv) file to sync");
	private final JButton btnSelectQacsv = new JButton("Select qa (.csv) file to sync");
	private final JButton btnSelectEscalationcsv = new JButton("Select escalation (.csv) file to sync");
	private final JButton btnSync = new JButton("SYNC");

	public GUI() {
		automaticPanel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][]"));
		lblAutomaticSync.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		automaticPanel.add(lblAutomaticSync, "cell 0 1");
		
		automaticPanel.add(btnSelectEmployeeCSVFile, "cell 1 4");
		
		automaticPanel.add(btnSelectScorecardCSVFile, "cell 1 5");
		
		automaticPanel.add(btnSelectCsatcsvFile, "cell 1 6,growx");
		
		automaticPanel.add(btnSelectQacsv, "cell 1 7,growx");
		
		automaticPanel.add(btnSelectEscalationcsv, "cell 1 8");
		
		automaticPanel.add(btnSync, "cell 1 9,growx");
		manualPanel.setLayout(
				new MigLayout("", "[46px][][grow]", "[14px][][][][][][][][][][][][][][][][][][][][][][][][]"));

		ArrayList<String> arr_teams = new ArrayList<>();

		arr_teams.add("ASIA");
		arr_teams.add("EMEA");
		arr_teams.add("NALA");

		ArrayList<Integer> arr_year = new ArrayList<>();

		for (int i = 2000; i <= 2006; i++) {
			arr_year.add(i);
		}

		ArrayList<Integer> arr_month = new ArrayList<>();

		for (int i = 1; i <= 12; i++) {
			arr_month.add(i);
		}

		cmbTeam = new JComboBox(arr_teams.toArray());
		AutoCompleteDecorator.decorate(this.cmbTeam);

		lblManualInput.setFont(new Font("Tahoma", Font.BOLD, 20));

		manualPanel.add(lblManualInput, "cell 0 1 2 3,alignx left,aligny center");

		manualPanel.add(lblFullname, "cell 1 6,alignx trailing");
		AutoCompleteDecorator.decorate(txtFullname, db.getEmployeeFullName(), true);
		txtFullname.setColumns(10);

		manualPanel.add(txtFullname, "cell 2 6,growx");

		manualPanel.add(lblEmployeeId, "cell 1 7,alignx trailing");
		txtEmployeeID.setEnabled(false);

		manualPanel.add(txtEmployeeID, "cell 2 7,growx");

		manualPanel.add(lblMonth, "cell 1 8,alignx trailing");

		cmbMonth = new JComboBox(arr_month.toArray());

		AutoCompleteDecorator.decorate(this.cmbMonth);

		manualPanel.add(cmbMonth, "cell 2 8,growx");

		manualPanel.add(lblYear, "cell 1 9,alignx trailing");

		cmbYear = new JComboBox(arr_year.toArray());
		AutoCompleteDecorator.decorate(this.cmbYear);

		manualPanel.add(cmbYear, "cell 2 9,growx");

		manualPanel.add(lblTeam, "cell 1 10,alignx trailing");

		manualPanel.add(cmbTeam, "cell 2 10,growx");

		manualPanel.add(lblTotalTickets, "cell 1 11,alignx trailing");
		txtTotalTickets.setColumns(10);

		manualPanel.add(txtTotalTickets, "cell 2 11,growx,aligny top");

		manualPanel.add(lblCWTE2E, "cell 1 12,alignx trailing");
		txtE2E.setColumns(10);

		manualPanel.add(txtE2E, "cell 2 12,growx,aligny top");

		System.out.println(arr_teams.toString());

		manualPanel.add(lblCWTDisputed, "cell 1 13,alignx trailing");
		txtDisputed.setColumns(10);

		manualPanel.add(txtDisputed, "cell 2 13,growx,aligny top");

		manualPanel.add(lblMissedTickets, "cell 1 14,alignx trailing");
		txtMissedTickets.setColumns(10);

		manualPanel.add(txtMissedTickets, "cell 2 14,growx,aligny top");

		manualPanel.add(lblFyr, "cell 1 15,alignx trailing");
		txtFYR.setText("");
		txtFYR.setColumns(10);

		manualPanel.add(txtFYR, "cell 2 15,growx");

		manualPanel.add(lblControllableMis, "cell 1 16,alignx trailing");
		txtControllableMis.setText("");
		txtControllableMis.setColumns(10);

		manualPanel.add(txtControllableMis, "cell 2 16,growx,aligny top");

		manualPanel.add(lblCallRegistration, "cell 1 17,alignx trailing");
		txtCallRegistration.setColumns(10);

		manualPanel.add(txtCallRegistration, "cell 2 17,growx");

		manualPanel.add(lblCSAT, "cell 1 18,alignx trailing");
		txtCSAT.setText("");
		txtCSAT.setColumns(10);

		manualPanel.add(txtCSAT, "cell 2 18,growx,aligny top");

		manualPanel.add(lblQA, "cell 1 19,alignx trailing");
		txtQA.setColumns(10);

		manualPanel.add(txtQA, "cell 2 19,growx");

		manualPanel.add(lblExternalEscalation, "cell 1 20,alignx trailing");
		txtExternalEscalation.setText("");
		txtExternalEscalation.setColumns(10);

		manualPanel.add(txtExternalEscalation, "cell 2 20,growx,aligny top");

		manualPanel.add(btnEnter, "cell 2 21,growx");


		frame.getContentPane().setLayout(new BorderLayout());

		splitPane.setEnabled(false);
		splitPane.setResizeWeight(.15d);

		System.out.println("hello world");

		rightScrollPane.setPreferredSize(new Dimension(500, 800));
		leftScrollPane.setPreferredSize(new Dimension(500, 800));

		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		
		
		txtFullname.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			public void removeUpdate(DocumentEvent e) {
				changed();
			}

			public void insertUpdate(DocumentEvent e) {
				changed();
			}
			
			public void changed() {
				txtEmployeeID.setText(Integer.toString(db.getID(txtFullname.getText())));
			}
			
		});
		
	}
	

	
	public int getEmployeeID(){
		return Integer.parseInt(txtEmployeeID.getText());
	}
	
	public int getMonth(){
		return Integer.parseInt(cmbMonth.getSelectedItem().toString());
	}
	
	public int getYear(){
		return Integer.parseInt(cmbYear.getSelectedItem().toString());
	}
	
	public String getFullname(){
		return txtFullname.getText();
	}
	
	public String getTeam(){
		return cmbTeam.getSelectedItem().toString();
	}
	
	public int getTotalTickets(){
		return Integer.parseInt(txtTotalTickets.getText());
	}
	
	public double getE2E(){
		return Double.parseDouble(txtE2E.getText());
	}
	
	public double getDisputed(){
		return Double.parseDouble(txtDisputed.getText());
	}
	
	public int getMissedTickets(){
		return Integer.parseInt(txtMissedTickets.getText());
	}
	
	public int getFYR(){
		return Integer.parseInt(txtFYR.getText());
	}
	
	public int getControllableMis(){
		return 	Integer.parseInt(txtControllableMis.getText());
	}
	
	public double getCallRegistration(){
		return Double.parseDouble(txtCallRegistration.getText());
	}

	public double getCSAT(){
		 return Double.parseDouble(txtCSAT.getText());
	}
	
	public double getQA(){
		return Double.parseDouble(txtQA.getText());
	}
	
	public int getExternalEscalation(){
		return Integer.parseInt(txtExternalEscalation.getText());
	}
	
	void addManualListener(ActionListener event){
		btnEnter.addActionListener(event);
	}
	
	void addAutomaticEmployeeListener(ActionListener event ){
		btnSelectEmployeeCSVFile.addActionListener(event);
	}
	
	void addAutomaticCSATListener(ActionListener event ){
		btnSelectCsatcsvFile.addActionListener(event);
	}
	
	void addAutomaticScorecardListener(ActionListener event ){
		btnSelectScorecardCSVFile.addActionListener(event);
	}
	
	void addAutomaticQAListener(ActionListener event ){
		btnSelectQacsv.addActionListener(event);
	}
	
	void addAutomaticEscalationListener(ActionListener event ){
		btnSelectEscalationcsv.addActionListener(event);
	}
	
	void addAutomaticSync(ActionListener event ){
		btnSync.addActionListener(event);
	}
	
}
