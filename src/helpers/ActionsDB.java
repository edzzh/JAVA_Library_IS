/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.*;

/**
 *
 * @author edgar
 */
public class ActionsDB {
    final private static String userDatabase = "jdbc:sqlite:library_users.db";
    
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
                // If conection is not equal to null, close the connection
                if (con != null) {
                    con.close();
                }
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Create VARIAIONS data table
    public static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n"
                + "ID integer PRIMARY KEY,\n"
                + "NAME text NOT NULL,\n" 
                + "SURNAME text NOT NULL,\n" 
                + "USERNAME text NOT NULL,\n"
                + "PASSWORD text NOT NULL" + ")";
        
        try (Connection con = DriverManager.getConnection(userDatabase)){
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            System.out.println("CREATED USERS TABLE");
        } catch (SQLException e) {
           System.out.println(e.getMessage()); 
        }
    }
    
    public static void main(String [] args) {
        connect();
        createUsersTable();
    }
}
