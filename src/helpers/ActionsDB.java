package helpers;

import java.sql.*;

import model.Reader;

/**
 *
 * @author edgar
 */
public class ActionsDB {
    final private static String userDatabase = "jdbc:sqlite:library_users.db";
    final private static String bookDatabase = "jdbc:sqlite:library_books.db";
    
    // Connect to a database
    public static void connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(userDatabase);
            
            System.out.println("CONNECTION TO SQLITE HAS BEEN ESTABLISHED");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // If connection is not equal to null, close the connection
                if (con != null) {
                    con.close();
                }
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Create User data table
    public static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n"
                + "ID integer PRIMARY KEY,\n"
                + "NAME text NOT NULL,\n" 
                + "SURNAME text NOT NULL,\n" 
                + "USERNAME text NOT NULL,\n"
                + "PASSWORD text NOT NULL, \n"
                + "USER_NUMBER integer NOT NULL"+ ")";
        
        try (Connection con = DriverManager.getConnection(userDatabase)){
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println("CREATED USERS TABLE");
        } catch (SQLException e) {
           System.out.println(e.getMessage()); 
        }
    }
    
    // Create Books data table
    public static void createBooksTable() {
        String sql = "CREATE TABLE IF NOT EXISTS BOOKS (\n"
                + "ID integer PRIMARY KEY,\n"
                + "ISBN text NOT NULL,\n" 
                + "YEAR integer NOT NULL,\n"
                + "AUTHOR text NOT NULL, \n"
                + "TITLE text NOT NULL, \n"
                + "RATING integer NOT NULL, \n"
                + "CONDITION text NOT NULL, \n"
                + "RARITY text NOT NULL"+ ")";
        
        try (Connection con = DriverManager.getConnection(bookDatabase)){
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println("CREATED BOOKS TABLE");
        } catch (SQLException e) {
           System.out.println(e.getMessage()); 
        }
    }
    
    public static Reader getUserFromDatabase(String readerUsername) {
    	String sql = "SELECT * FROM USERS WHERE USERNAME=?";
    	Reader r = null;
    	
    	try (Connection conn = DriverManager.getConnection(userDatabase)){
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, readerUsername);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
                    r = new Reader(
    			rs.getString("NAME"),
    			rs.getString("SURNAME"),
    			rs.getInt("USER_NUMBER"),
    			null
                    );
    		}
    		
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    	return r;
    }
    
    public static void main(String [] args) {
        connect();
        createUsersTable();
        createBooksTable();
    }
}
