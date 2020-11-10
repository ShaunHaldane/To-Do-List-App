//This class contains commands needed to change database of ToDoApp.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ToDoAppDB {
	
	//Inserts data into database
    public void insert(int id, String newDate, String task) {
        String sql = "INSERT INTO tasks(id, date, task) VALUES(?,?,?)";

        try (Connection conn = dbConnection.dbConnector();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, id);
        	pstmt.setString(2, newDate);
            pstmt.setString(3, task);
            pstmt.executeUpdate();
        } 
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    
    
    
    
    //Returns amount of rows in database.
    public static int countRows(){
        String sql = "SELECT task FROM tasks";
        int rowCount = 0;
        
        try (Connection conn = dbConnection.dbConnector();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	rowCount++;
            }
        } 
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return rowCount;
    }
    
    
    
    
    
    //Returns all the rows from database as an Arraylist of strings.
    public static ArrayList<String> selectAll(){
        String sql = "SELECT * FROM tasks";
        ArrayList<String> index = new ArrayList<String>();
     
        try (Connection conn = dbConnection.dbConnector();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                index.add(rs.getInt("id") + "\t" + rs.getString("date") + "\t" + rs.getString("task") + "\t");
            }

        } 
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return index;
    }
    
    
    
    
    
    //Deletes a row from database
    public static void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        System.out.println("in delete");

        try (Connection conn = dbConnection.dbConnector();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } 
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    
    //Deletes all rows from the database
    public static void deleteAll() {
        String sql = "DELETE FROM tasks";
        System.out.println("in delete");

        try (Connection conn = dbConnection.dbConnector();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {            
            // execute the delete statement
            pstmt.executeUpdate();

        } 
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
