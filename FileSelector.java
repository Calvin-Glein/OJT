import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileSelector {
	private static JFileChooser fileChooser = new JFileChooser();
	private File csvFile;
	private DBConnect db = new DBConnect();;

	public FileSelector() {

		
		
		
	}

	public void employeeCSV() {
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			csvFile = fileChooser.getSelectedFile();
			System.out.println(csvFile.getName());
			System.out.println(csvFile.getPath());
			

			
//			System.out.println("sa csvsync  " + path);
		
			
			
		}
		db.loadCSVEmployee(csvFile);
	}
	
	public void csatCSV(){
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			csvFile = fileChooser.getSelectedFile();
			System.out.println(csvFile.getName());
			System.out.println(csvFile.getPath());
					
		}
		db.loadCSVCSAT(csvFile);
	}
	
	public void scorecardCSV(){
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			csvFile = fileChooser.getSelectedFile();
			System.out.println(csvFile.getName());
			System.out.println(csvFile.getPath());
					
		}
		db.loadCSVScorecard(csvFile);
		System.out.println("nasa scorecardcsv");
	}
}

// public String getCSVPath() {
// fileChooser = new JFileChooser();
//
// File path;
//
// String type = "None";
//// int approve = fileChooser.showOpenDialog(null);
//
// // if(approve == JFileChooser.APPROVE_OPTION){
// // System.out.println("getCurrentDirectory(): " +
// // fileChooser.getCurrentDirectory());
// // System.out.println("getSelectedFile() : " +
// // fileChooser.getSelectedFile());
// // }
//
// path = fileChooser.getSelectedFile();
// try {
// type = path.toString();
// System.out.println(path);
//
// } catch (Exception e) {
// System.out.println("None selected");
// }
// return type;
//
// }
