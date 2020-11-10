//This class connects to the database

import java.sql.*;

import javax.swing.JOptionPane;

public class dbConnection {
	Connection conn=null;
	
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\W10 User\\Documents\\DataBases\\ToDoList");
			return conn;
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}	
		
}
